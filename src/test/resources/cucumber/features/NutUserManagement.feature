# language: fr
Fonctionnalité: Gestion des utilisateurs

  Scénario: Rechercher un utilisateur par id
    Étant donné un utilisateur existant avec l'id 1
    Et le prénom "Alice"
    Et le nom "Dupont"
    Et le genre "F"
    Et la date de naissance "1990-05-15T00:00:00Z"
    Quand je recherche l'utilisateur avec l'id 1
    Alors la réponse HTTP est 200
    Et la réponse contient le prénom "Alice"
    Et la réponse contient le nom "Dupont"

  Scénario: Rechercher un utilisateur inexistant par id
    Étant donné aucun utilisateur avec l'id 999
    Quand je recherche l'utilisateur avec l'id 999
    Alors la réponse HTTP est 200
    Et la réponse est vide

  Scénario: Rechercher des utilisateurs par nom de famille
    Étant donné des utilisateurs avec le nom de famille "Martin"
    Quand je recherche les utilisateurs avec le nom "Martin"
    Alors la réponse HTTP est 200
    Et la réponse contient une liste de 2 utilisateurs

  Scénario: Rechercher par nom de famille inconnu
    Étant donné aucun utilisateur avec le nom de famille "Inconnu"
    Quand je recherche les utilisateurs avec le nom "Inconnu"
    Alors la réponse HTTP est 200
    Et la réponse contient une liste vide

  Scénario: Enregistrer un nouvel utilisateur
    Étant donné un nouvel utilisateur avec le prénom "Bob"
    Et le nom "Leroy"
    Et le genre "M"
    Et la date de naissance "1985-03-20T00:00:00Z"
    Quand j'enregistre cet utilisateur
    Alors la réponse HTTP est 200
    Et la réponse contient le prénom "Bob"
    Et la réponse contient le nom "Leroy"

  Scénario: Enregistrer plusieurs utilisateurs
    Étant donné une liste de 2 nouveaux utilisateurs
    Quand j'enregistre ces utilisateurs
    Alors la réponse HTTP est 200
    Et la réponse contient une liste de 2 utilisateurs
