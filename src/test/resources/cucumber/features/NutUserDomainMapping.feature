# language: fr
Fonctionnalité: Conversion des utilisateurs entre les couches Domain et Infrastructure

  Scénario: Conversion NutUserDomain vers NutUser entity
    Étant donné un NutUserDomain avec le prénom "Alice"
    Et le NutUserDomain ayant aussi le nom "Dupont"
    Et le NutUserDomain ayant aussi le genre "F"
    Et le NutUserDomain ayant aussi la date de naissance "1990-05-15T00:00:00Z"
    Quand il est convertit en entité NutUser
    Alors l'entité NutUser résultante contient le prénom "Alice"
    Et l'entité NutUser résultante contient le nom "Dupont"
    Et l'entité NutUser résultante contient le genre "F"
    Et l'entité NutUser résultante contient la date de naissance "1990-05-15T00:00:00Z"

  Scénario: Conversion NutUser entity vers NutUserResponseDomain avec nuts
    Étant donné une entité NutUser avec l'id 1
    Et l'entité NutUser ayant aussi le prénom "Alice"
    Et l'entité NutUser ayant aussi le nom "Dupont"
    Et l'entité NutUser ayant aussi le genre "F"
    Et l'entité NutUser ayant aussi la date de naissance "1990-05-15T00:00:00Z"
    Et l'entité NutUser ayant aussi une liste de nuts
    Quand elle est convertit en NutUserResponseDomain
    Alors le NutUserResponseDomain résultant contient l'id 1
    Et le NutUserResponseDomain résultant contient le prénom "Alice"
    Et le NutUserResponseDomain résultant contient une liste de nuts non vide

  Scénario: Conversion NutUser entity vers NutUserResponseDomain avec nuts null
    Étant donné une entité NutUser avec l'id 2
    Et l'entité NutUser ayant aussi le prénom "Bob"
    Et l'entité NutUser ayant aussi le nom "Martin"
    Et l'entité NutUser ayant aussi le genre "M"
    Et l'entité NutUser ayant aussi la date de naissance "1985-03-20T00:00:00Z"
    Et l'entité NutUser ayant aussi des nuts null
    Quand elle est convertit en NutUserResponseDomain
    Alors le NutUserResponseDomain résultant contient une liste de nuts vide
