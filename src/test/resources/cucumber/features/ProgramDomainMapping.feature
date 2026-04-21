# language: fr
Fonctionnalité: Conversion des programmes entre les couches Domain et Infrastructure

  Scénario: Conversion ProgramDomain vers Program entity
    Étant donné un ProgramDomain avec le name "Push Pull Legs"
    Et la description programme "Programme PPL classique"
    Et la difficulté "INTERMEDIATE"
    Et la durée en semaines 12
    Quand il est convertit en entité Program
    Alors l'entité Program résultante contient le name "Push Pull Legs"
    Et l'entité Program résultante contient la description "Programme PPL classique"
    Et l'entité Program résultante contient la difficulté "INTERMEDIATE"
    Et l'entité Program résultante contient la durée en semaines 12
    Et l'entité Program résultante contient un createdAt non null

  Scénario: Conversion Program entity vers ProgramResponseDomain
    Étant donné une entité Program avec l'id 1
    Et le name programme "Push Pull Legs"
    Et la description programme entity "Programme PPL classique"
    Et la difficulté entity "INTERMEDIATE"
    Et la durée en semaines entity 12
    Et le createdAt "2024-06-01T10:00:00Z"
    Quand elle est convertit en ProgramResponseDomain
    Alors le ProgramResponseDomain résultant contient l'id 1
    Et le ProgramResponseDomain résultant contient le name "Push Pull Legs"
    Et le ProgramResponseDomain résultant contient la description "Programme PPL classique"
    Et le ProgramResponseDomain résultant contient la difficulté "INTERMEDIATE"
    Et le ProgramResponseDomain résultant contient la durée en semaines 12
    Et le ProgramResponseDomain résultant contient le createdAt "2024-06-01T10:00:00Z"
