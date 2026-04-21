# language: fr
Fonctionnalité: Conversion des programmes entre les couches Presentation et Domain

  Scénario: Conversion ProgramDTO vers ProgramDomain
    Étant donné un ProgramDTO avec le name "Push Pull Legs"
    Et le ProgramDTO ayant aussi la description "Programme PPL classique"
    Et le ProgramDTO ayant aussi la difficulté "INTERMEDIATE"
    Et le ProgramDTO ayant aussi la durée en semaines 12
    Quand il est convertit en ProgramDomain
    Alors le ProgramDomain résultant contient le name "Push Pull Legs"
    Et le ProgramDomain résultant contient la description "Programme PPL classique"
    Et le ProgramDomain résultant contient la difficulté "INTERMEDIATE"
    Et le ProgramDomain résultant contient la durée en semaines 12

  Scénario: Conversion ProgramResponseDomain vers ProgramResponseDTO
    Étant donné un ProgramResponseDomain avec l'id 1
    Et le ProgramResponseDomain ayant aussi le name "Push Pull Legs"
    Et le ProgramResponseDomain ayant aussi la description "Programme PPL classique"
    Et le ProgramResponseDomain ayant aussi la difficulté "INTERMEDIATE"
    Et le ProgramResponseDomain ayant aussi la durée en semaines 12
    Et le ProgramResponseDomain ayant aussi le createdAt "2024-06-01T10:00:00Z"
    Quand il est convertit en ProgramResponseDTO
    Alors le ProgramResponseDTO résultant contient l'id 1
    Et le ProgramResponseDTO résultant contient le name "Push Pull Legs"
    Et le ProgramResponseDTO résultant contient la description "Programme PPL classique"
    Et le ProgramResponseDTO résultant contient la difficulté "INTERMEDIATE"
    Et le ProgramResponseDTO résultant contient la durée en semaines 12
    Et le ProgramResponseDTO résultant contient le createdAt "2024-06-01T10:00:00Z"
