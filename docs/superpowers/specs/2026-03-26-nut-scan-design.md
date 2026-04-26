# Design : Scan d'etiquettes nutritionnelles via LLM Vision

## Contexte

MyNutRest est une API REST Spring Boot (Java 25) avec architecture hexagonale qui gere le suivi nutritionnel et fitness. L'application sert aussi de serveur MCP via Spring AI.

L'objectif est d'ajouter un endpoint permettant d'envoyer une photo d'etiquette nutritionnelle depuis un futur frontend mobile. L'image est analysee par un modele LLM de vision (Ministral 3 14B Reasoning) heberge sur LM Studio, les valeurs nutritionnelles sont extraites, ajustees au poids consomme, puis inserees en base.

## Decisions de design

- **Pas de stockage d'image** : l'image est envoyee, analysee, puis jetee.
- **Insertion automatique** : pas de validation utilisateur avant insertion. Insertion si statut COMPLETE ou PARTIAL. Pas d'insertion si FAILURE.
- **Communication LLM via Spring AI** : utilisation du `ChatClient` avec le starter OpenAI, pointe vers LM Studio (API compatible OpenAI).
- **Extraction pour 100g** : le LLM extrait toujours les valeurs pour 100g. Si l'etiquette ne mentionne que des valeurs par portion, le LLM recalcule pour 100g. Le backend applique ensuite le ratio `valeur × grammes / 100`.
- **Service dedie** : `MyNutScanService` / `MyNutScanServiceImpl`, separe du CRUD existant.
- **Endpoint dans le controller existant** : nouvelle methode dans `MyNutController`, pas de nouveau controller.
- **DTO de reponse enrichi** : `NutScanResponseDTO` avec statut, messages et donnees nutritionnelles.

## Endpoint

```
POST /my-nut/api/v1/user/id/{user-id}/nut/scan
Content-Type: multipart/form-data
```

### Parametres

| Parametre | Type | Source | Description |
|-----------|------|--------|-------------|
| `user-id` | Long | Path variable | ID de l'utilisateur |
| `image` | MultipartFile | Request part | Photo de l'etiquette (JPEG/PNG) |
| `grams` | BigDecimal | Request param | Poids consomme en grammes |

### Reponse

```json
{
  "status": "PARTIAL",
  "messages": ["Champs non reconnus : fibers, sodium"],
  "nut": {
    "id": 42,
    "instant": "2026-03-26T12:00:00Z",
    "kcal": 187.50,
    "fat": 6.25,
    "saturatedFattyAcids": 2.00,
    "carbohydrates": 25.00,
    "sugar": 12.50,
    "fibers": null,
    "protein": 8.75,
    "sodium": null
  }
}
```

En cas d'echec total :

```json
{
  "status": "FAILURE",
  "messages": ["Impossible d'extraire les informations nutritionnelles de cette image."],
  "nut": null
}
```

## Flux de donnees

```
Mobile (photo + grams)
    |
MyNutController.scanNutForUser(userId, image, grams)
    |
MyNutScanService.scanAndSave(userId, imageBytes, grams)
    |
NutScanPort.extractNutritionFromImage(imageBytes)
    |
NutScanAdapter -> Spring AI ChatClient -> LM Studio (vision)
    |
NutScanExtractionDomain (valeurs pour 100g, champs nullable)
    |
evaluateStatus() -> COMPLETE / PARTIAL / FAILURE
    |
Si FAILURE -> retour NutScanResultDomain(FAILURE, messages, null)
Si COMPLETE/PARTIAL -> applyRatio(extraction, grams) -> NutDomain
    |
MyNutPort.save(userId, nutDomain) -> NutResponseDomain
    |
NutScanResultDomain(status, messages, nutResponse)
    |
NutScanDTOMapper -> NutScanResponseDTO (vers le front)
```

## Architecture des composants

### Nouveaux fichiers

```
src/main/java/com/alexm/MyNutRest/
  presentation/
    dto/response/
      NutScanResponseDTO.java          # record(status, messages, nut)
    mapper/
      NutScanDTOMapper.java            # NutScanResultDomain -> NutScanResponseDTO
  domain/
    model/
      NutScanStatus.java               # enum COMPLETE, PARTIAL, FAILURE
      NutScanResultDomain.java         # record(status, messages, nutResponse)
      NutScanExtractionDomain.java     # record des valeurs pour 100g + getNullFieldNames()
    port/
      MyNutScanService.java            # interface service
      NutScanPort.java                 # interface port LLM
    service/
      MyNutScanServiceImpl.java        # orchestration LLM -> ratio -> insertion
  infrastructure/
    adapter/
      NutScanAdapter.java              # implementation Spring AI ChatClient
```

### Fichiers existants modifies

- **`MyNutController.java`** : ajout de la methode `scanNutForUser()`
- **`pom.xml`** : ajout de la dependance `spring-ai-starter-model-openai`
- **`application.properties`** : ajout config LM Studio et limites upload
- **`application-test.properties`** : exclusion autoconfiguration OpenAI

### Dependances entre composants

```
MyNutController
    -> MyNutScanService (interface dans domain/port)

MyNutScanServiceImpl (dans domain/service)
    -> NutScanPort (interface dans domain/port, appel LLM)
    -> MyNutPort (interface dans domain/port, insertion en base)

NutScanAdapter (dans infrastructure/adapter)
    -> ChatClient.Builder (Spring AI)
    -> implements NutScanPort
```

## Logique metier

### Evaluation du statut

| Champs extraits | Statut | Insertion | Messages |
|-----------------|--------|-----------|----------|
| 8 sur 8 | `COMPLETE` | Oui | _(aucun)_ |
| 1 a 7 sur 8 | `PARTIAL` | Oui (null pour le reste) | Liste des champs non reconnus |
| 0 sur 8 | `FAILURE` | Non | "Impossible d'extraire les informations nutritionnelles de cette image." |

### Calcul du ratio

```
valeur_finale = valeur_100g * grammes / 100
```

- Arrondi : `HALF_UP`, 2 decimales
- Si un champ est `null` (non extrait), il reste `null` apres le ratio

### Prompt LLM

Le prompt demande au LLM de :
- Extraire les valeurs **pour 100g** si disponibles sur l'etiquette
- Si l'etiquette ne mentionne que des valeurs par portion, identifier le grammage de la portion et recalculer pour 100g
- Retourner un JSON avec les 8 champs exacts : `kcal`, `fat`, `saturatedFattyAcids`, `carbohydrates`, `sugar`, `fibers`, `protein`, `sodium`
- Mettre `null` pour les champs illisibles ou absents

Spring AI gere le parsing JSON vers `NutScanExtractionDomain` via `.entity()`.

## Gestion d'erreurs

| Cas | Comportement |
|-----|-------------|
| LM Studio injoignable | Exception propagee -> HTTP 500 |
| JSON invalide du LLM | Exception Spring AI -> HTTP 500 |
| User ID inexistant | Exception existante de `MyNutPort.save()` |
| Image vide ou corrompue | Le LLM recoit l'image telle quelle — si rien n'est lisible, `FAILURE` |

Pas de gestion d'erreurs custom — Spring gere les exceptions techniques classiques.

## Configuration

### Dependance Maven

```xml
<dependency>
    <groupId>org.springframework.ai</groupId>
    <artifactId>spring-ai-starter-model-openai</artifactId>
</dependency>
```

Version resolue par le BOM Spring AI 2.0.0-M2 existant.

### application.properties

```properties
spring.ai.openai.base-url=http://localhost:1234
spring.ai.openai.api-key=lm-studio
spring.ai.openai.chat.options.model=ministral-3-14b-reasoning
spring.servlet.multipart.max-file-size=10MB
spring.servlet.multipart.max-request-size=10MB
```

### application-test.properties

Ajout de l'exclusion de l'autoconfiguration OpenAI :

```properties
spring.autoconfigure.exclude=org.springframework.ai.mcp.server.autoconfigure.McpServerAutoConfiguration,org.springframework.ai.mcp.server.autoconfigure.McpWebMvcServerAutoConfiguration,org.springframework.ai.openai.autoconfigure.OpenAiAutoConfiguration
```

## Tests

### Approche

Tests Cucumber BDD en francais, coherent avec l'existant. Les ports (`NutScanPort`, `MyNutPort`) sont mockes.

### Feature file : `NutScan.feature`

```gherkin
# language: fr
Fonctionnalite: Scan d'etiquettes nutritionnelles

  Scenario: Scan complet d'une etiquette nutritionnelle
    Etant donne un utilisateur avec l'id 1
    Et une image d'etiquette nutritionnelle lisible
    Et un poids consomme de 150 grammes
    Quand je scanne l'etiquette pour cet utilisateur
    Alors le statut de la reponse est "COMPLETE"
    Et aucun message d'erreur n'est retourne
    Et une entree nutritionnelle est creee avec les valeurs ajustees au ratio

  Scenario: Scan partiel d'une etiquette nutritionnelle
    Etant donne un utilisateur avec l'id 1
    Et une image d'etiquette partiellement lisible
    Et un poids consomme de 200 grammes
    Quand je scanne l'etiquette pour cet utilisateur
    Alors le statut de la reponse est "PARTIAL"
    Et les messages contiennent les champs non reconnus
    Et une entree nutritionnelle est creee avec des valeurs null pour les champs manquants

  Scenario: Echec total du scan
    Etant donne un utilisateur avec l'id 1
    Et une image illisible
    Et un poids consomme de 100 grammes
    Quand je scanne l'etiquette pour cet utilisateur
    Alors le statut de la reponse est "FAILURE"
    Et un message d'erreur explicatif est retourne
    Et aucune entree nutritionnelle n'est creee
```

### Step definitions

- `NutScanSteps.java` : step definitions pour les scenarios
- Mock de `NutScanPort` retournant des `NutScanExtractionDomain` avec tous, quelques, ou aucun champs selon le scenario
- Mock de `MyNutPort` pour l'insertion

### Tests des mappers

- `NutScanDTOMapping.feature` : teste la conversion `NutScanResultDomain` -> `NutScanResponseDTO`

### Hors scope des tests automatises

- Appel reel a LM Studio (test d'integration manuel)
- Qualite d'extraction du LLM (depend du modele)
