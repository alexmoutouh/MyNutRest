# language: fr
Fonctionnalité: Logique métier du service de scan nutritionnel

  Scénario: Extraction complète — insertion avec ratio appliqué
    Étant donné un port de scan qui retourne une extraction complète avec 500 kcal et 20 fat pour 100g
    Et un port de persistance prêt à sauvegarder
    Quand le service de scan est appelé pour l'utilisateur 1 avec 150 grammes
    Alors le résultat a le statut "COMPLETE"
    Et le résultat a 0 messages
    Et la persistance a été appelée avec 750,00 kcal et 30,00 fat

  Scénario: Extraction partielle — insertion avec champs null
    Étant donné un port de scan qui retourne une extraction avec fibers et sodium null
    Et un port de persistance prêt à sauvegarder
    Quand le service de scan est appelé pour l'utilisateur 1 avec 200 grammes
    Alors le résultat a le statut "PARTIAL"
    Et le résultat contient le message "Champs non reconnus : fibers, sodium"
    Et la persistance a été appelée avec des valeurs null pour fibers et sodium

  Scénario: Extraction échouée — pas d'insertion
    Étant donné un port de scan qui retourne une extraction entièrement vide
    Quand le service de scan est appelé pour l'utilisateur 1 avec 100 grammes
    Alors le résultat a le statut "FAILURE"
    Et le résultat contient le message "Impossible d'extraire les informations nutritionnelles de cette image."
    Et la persistance n'a pas été appelée

  Scénario: Arrondi HALF_UP à 2 décimales
    Étant donné un port de scan qui retourne 33,33 kcal pour 100g
    Et un port de persistance prêt à sauvegarder
    Quand le service de scan est appelé pour l'utilisateur 1 avec 33 grammes
    Alors la persistance a été appelée avec 11,00 kcal
