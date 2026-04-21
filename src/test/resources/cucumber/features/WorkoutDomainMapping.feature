# language: fr
Fonctionnalité: Conversion des workouts entre les couches Domain et Infrastructure

  Scénario: Conversion WorkoutDomain vers Workout entity
    Étant donné un WorkoutDomain avec le name "Push Day"
    Et la description workout "Séance poussée"
    Et le dayOfWeek 1
    Quand il est convertit en entité Workout
    Alors l'entité Workout résultante contient le name "Push Day"
    Et l'entité Workout résultante contient la description "Séance poussée"
    Et l'entité Workout résultante contient le dayOfWeek 1

  Scénario: Conversion Workout entity vers WorkoutResponseDomain
    Étant donné une entité Workout avec l'id 1
    Et le name workout "Push Day"
    Et la description workout entity "Séance poussée"
    Et le dayOfWeek entity 1
    Quand elle est convertit en WorkoutResponseDomain
    Alors le WorkoutResponseDomain résultant contient l'id 1
    Et le WorkoutResponseDomain résultant contient le name "Push Day"
    Et le WorkoutResponseDomain résultant contient la description "Séance poussée"
    Et le WorkoutResponseDomain résultant contient le dayOfWeek 1
