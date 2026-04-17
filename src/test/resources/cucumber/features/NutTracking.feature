# language: fr
Fonctionnalité: Suivi nutritionnel

  Scénario: Ajouter une entrée nutritionnelle pour un utilisateur existant
    Étant donné un utilisateur existant avec l'id 1
    Et une entrée nutritionnelle pour l'utilisateur 1
    Et avec 500 kcal
    Et avec 20.0 fat
    Et avec 5.0 saturatedFattyAcids
    Et avec 60.0 carbohydrates
    Et avec 10.0 sugar
    Et avec 8.0 fibers
    Et avec 25.0 protein
    Et avec 1.5 sodium
    Quand on effectue un POST sur '/my-nut/api/v1/user/id/{user-id}/nut'
    Alors la réponse HTTP est 200
    Et la réponse nutritionnelle contient 500 kcal
    Et la réponse nutritionnelle contient 20.0 fat
    Et la réponse nutritionnelle contient 5.0 saturatedFattyAcids
    Et la réponse nutritionnelle contient 60.0 carbohydrates
    Et la réponse nutritionnelle contient 10.0 sugar
    Et la réponse nutritionnelle contient 8.0 fibers
    Et la réponse nutritionnelle contient 25.0 protein
    Et la réponse nutritionnelle contient 1.5 sodium

  Scénario: Ajouter une entrée nutritionnelle pour un utilisateur inexistant
    Étant donné un utilisateur inexistant avec l'id 999
    Et une entrée nutritionnelle pour l'utilisateur 999
    Et avec 500 kcal
    Et avec 20.0 fat
    Et avec 5.0 saturatedFattyAcids
    Et avec 60.0 carbohydrates
    Et avec 10.0 sugar
    Et avec 8.0 fibers
    Et avec 25.0 protein
    Et avec 1.5 sodium
    Quand on effectue un POST sur '/my-nut/api/v1/user/id/{user-id}/nut'
    Alors une erreur serveur est levée avec le message "User not found with id: 999"
