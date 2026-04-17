# language: fr
Fonctionnalité: Conversion des entrées nutritionnelles entre les couches Presentation et Domain

  Scénario: Conversion NutDTO vers NutDomain
    Étant donné un NutDTO avec 500.0 kcal
    Et le NutDTO ayant aussi 20.0 fat
    Et le NutDTO ayant aussi 5.0 saturatedFattyAcids
    Et le NutDTO ayant aussi 60.0 carbohydrates
    Et le NutDTO ayant aussi 10.0 sugar
    Et le NutDTO ayant aussi 8.0 fibers
    Et le NutDTO ayant aussi 25.0 protein
    Et le NutDTO ayant aussi 1.5 sodium
    Quand il est convertit en NutDomain
    Alors le NutDomain résultant contient 500.0 kcal
    Et le NutDomain résultant contient 20.0 fat
    Et le NutDomain résultant contient 5.0 saturatedFattyAcids
    Et le NutDomain résultant contient 60.0 carbohydrates
    Et le NutDomain résultant contient 10.0 sugar
    Et le NutDomain résultant contient 8.0 fibers
    Et le NutDomain résultant contient 25.0 protein
    Et le NutDomain résultant contient 1.5 sodium

  Scénario: Conversion NutResponseDomain vers NutResponseDTO
    Étant donné un NutResponseDomain avec l'id 1
    Et le NutResponseDomain ayant aussi l'instant "2024-01-15T12:00:00Z"
    Et le NutResponseDomain ayant aussi 500.0 kcal
    Et le NutResponseDomain ayant aussi 20.0 fat
    Et le NutResponseDomain ayant aussi 5.0 saturatedFattyAcids
    Et le NutResponseDomain ayant aussi 60.0 carbohydrates
    Et le NutResponseDomain ayant aussi 10.0 sugar
    Et le NutResponseDomain ayant aussi 8.0 fibers
    Et le NutResponseDomain ayant aussi 25.0 protein
    Et le NutResponseDomain ayant aussi 1.5 sodium
    Quand il est convertit en NutResponseDTO
    Alors le NutResponseDTO résultant contient l'id 1
    Et le NutResponseDTO résultant contient l'instant "2024-01-15T12:00:00Z"
    Et le NutResponseDTO résultant contient 500.0 kcal
    Et le NutResponseDTO résultant contient 20.0 fat
    Et le NutResponseDTO résultant contient 5.0 saturatedFattyAcids
    Et le NutResponseDTO résultant contient 60.0 carbohydrates
    Et le NutResponseDTO résultant contient 10.0 sugar
    Et le NutResponseDTO résultant contient 8.0 fibers
    Et le NutResponseDTO résultant contient 25.0 protein
    Et le NutResponseDTO résultant contient 1.5 sodium
