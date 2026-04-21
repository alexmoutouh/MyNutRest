# language: fr
Fonctionnalité: Conversion des workouts entre les couches Presentation et Domain

  Scénario: Conversion WorkoutDTO vers WorkoutDomain
    Étant donné un WorkoutDTO avec le name "Push Day"
    Et le WorkoutDTO ayant aussi la description "Séance poussée"
    Et le WorkoutDTO ayant aussi le dayOfWeek 1
    Quand il est convertit en WorkoutDomain
    Alors le WorkoutDomain résultant contient le name "Push Day"
    Et le WorkoutDomain résultant contient la description "Séance poussée"
    Et le WorkoutDomain résultant contient le dayOfWeek 1

  Scénario: Conversion WorkoutResponseDomain vers WorkoutResponseDTO
    Étant donné un WorkoutResponseDomain avec l'id 1
    Et le WorkoutResponseDomain ayant aussi le name "Push Day"
    Et le WorkoutResponseDomain ayant aussi la description "Séance poussée"
    Et le WorkoutResponseDomain ayant aussi le dayOfWeek 1
    Quand il est convertit en WorkoutResponseDTO
    Alors le WorkoutResponseDTO résultant contient l'id 1
    Et le WorkoutResponseDTO résultant contient le name "Push Day"
    Et le WorkoutResponseDTO résultant contient la description "Séance poussée"
    Et le WorkoutResponseDTO résultant contient le dayOfWeek 1
