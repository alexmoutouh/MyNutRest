# language: fr
Fonctionnalité: Conversion NutScanResultDomain vers NutScanResponseDTO

  Scénario: Conversion d'un résultat complet
    Étant donné un NutScanResultDomain avec le statut "COMPLETE"
    Et le NutScanResultDomain sans messages
    Et le NutScanResultDomain avec une réponse nutritionnelle id 1 et instant "2024-01-15T12:00:00Z"
    Et la réponse nutritionnelle ayant 500.0 kcal
    Et la réponse nutritionnelle ayant 20.0 fat
    Et la réponse nutritionnelle ayant 5.0 saturatedFattyAcids
    Et la réponse nutritionnelle ayant 60.0 carbohydrates
    Et la réponse nutritionnelle ayant 10.0 sugar
    Et la réponse nutritionnelle ayant 8.0 fibers
    Et la réponse nutritionnelle ayant 25.0 protein
    Et la réponse nutritionnelle ayant 1.5 sodium
    Quand il est converti en NutScanResponseDTO
    Alors le NutScanResponseDTO a le statut "COMPLETE"
    Et le NutScanResponseDTO a 0 messages
    Et le NutScanResponseDTO contient un nut avec l'id 1
    Et le nut du NutScanResponseDTO contient 500.0 kcal

  Scénario: Conversion d'un résultat en échec
    Étant donné un NutScanResultDomain avec le statut "FAILURE"
    Et le NutScanResultDomain avec le message "Impossible d'extraire les informations nutritionnelles de cette image."
    Et le NutScanResultDomain sans réponse nutritionnelle
    Quand il est converti en NutScanResponseDTO
    Alors le NutScanResponseDTO a le statut "FAILURE"
    Et le NutScanResponseDTO a 1 messages
    Et le NutScanResponseDTO ne contient pas de nut
