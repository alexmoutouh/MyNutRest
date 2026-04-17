# language: fr
Fonctionnalité: Conversion des entrées nutritionnelles entre les couches Domain et Infrastructure

  Scénario: Conversion NutDomain vers Nut entity
    Étant donné un NutDomain avec 500.0 kcal
    Et 20.0 fat
    Et 5.0 saturatedFattyAcids
    Et 60.0 carbohydrates
    Et 10.0 sugar
    Et 8.0 fibers
    Et 25.0 protein
    Et 1.5 sodium
    Quand il est convertit en entité Nut
    Alors l'entité Nut résultante contient 500.0 kcal
    Et l'entité Nut résultante contient 20.0 fat
    Et l'entité Nut résultante contient 5.0 saturatedFattyAcids
    Et l'entité Nut résultante contient 60.0 carbohydrates
    Et l'entité Nut résultante contient 10.0 sugar
    Et l'entité Nut résultante contient 8.0 fibers
    Et l'entité Nut résultante contient 25.0 protein
    Et l'entité Nut résultante contient 1.5 sodium
    Et l'entité Nut résultante contient un instant non null

  Scénario: Conversion Nut entity vers NutResponseDomain
    Étant donné une entité Nut avec l'id 1
    Et l'instant "2024-01-15T12:00:00Z"
    Et 500.0 kcal
    Et 20.0 fat
    Et 5.0 saturatedFattyAcids
    Et 60.0 carbohydrates
    Et 10.0 sugar
    Et 8.0 fibers
    Et 25.0 protein
    Et 1.5 sodium
    Quand elle est convertit en NutResponseDomain
    Alors le NutResponseDomain résultant contient l'id 1
    Et le NutResponseDomain résultant contient l'instant "2024-01-15T12:00:00Z"
    Et le NutResponseDomain résultant contient 500.0 kcal
    Et le NutResponseDomain résultant contient 20.0 fat
    Et le NutResponseDomain résultant contient 5.0 saturatedFattyAcids
    Et le NutResponseDomain résultant contient 60.0 carbohydrates
    Et le NutResponseDomain résultant contient 10.0 sugar
    Et le NutResponseDomain résultant contient 8.0 fibers
    Et le NutResponseDomain résultant contient 25.0 protein
    Et le NutResponseDomain résultant contient 1.5 sodium
