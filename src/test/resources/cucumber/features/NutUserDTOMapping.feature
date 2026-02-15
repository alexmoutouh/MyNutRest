# language: fr
Fonctionnalité: Conversion des utilisateurs entre les couches Presentation et Domain

  Scénario: Conversion UserDTO vers NutUserDomain
    Étant donné un UserDTO avec le prénom "Alice"
    Et le UserDTO ayant aussi le nom "Dupont"
    Et le UserDTO ayant aussi le genre "F"
    Et le UserDTO ayant aussi la date de naissance "1990-05-15T00:00:00Z"
    Quand il est convertit en NutUserDomain
    Alors le NutUserDomain résultant contient le prénom "Alice"
    Et le NutUserDomain résultant contient le nom "Dupont"
    Et le NutUserDomain résultant contient le genre "F"
    Et le NutUserDomain résultant contient la date de naissance "1990-05-15T00:00:00Z"

  Scénario: Conversion NutUserResponseDomain vers NutUserResponseDTO
    Étant donné un NutUserResponseDomain avec l'id 1
    Et le NutUserResponseDomain ayant aussi le prénom "Alice"
    Et le NutUserResponseDomain ayant aussi le nom "Dupont"
    Et le NutUserResponseDomain ayant aussi le genre "F"
    Et le NutUserResponseDomain ayant aussi la date de naissance "1990-05-15T00:00:00Z"
    Et le NutUserResponseDomain ayant aussi une liste de nuts
    Quand il est convertit en NutUserResponseDTO
    Alors le NutUserResponseDTO résultant contient l'id 1
    Et le NutUserResponseDTO résultant contient le prénom "Alice"
    Et le NutUserResponseDTO résultant contient le nom "Dupont"
    Et le NutUserResponseDTO résultant contient le genre "F"
    Et le NutUserResponseDTO résultant contient la date de naissance "1990-05-15T00:00:00Z"
    Et le NutUserResponseDTO résultant contient une liste de nuts
