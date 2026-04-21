# language: fr
Fonctionnalité: Conversion des exercices entre les couches Presentation et Domain

  Scénario: Conversion ExerciseDTO vers ExerciseDomain
    Étant donné un ExerciseDTO avec le name "Bench Press"
    Et le ExerciseDTO ayant aussi la description "Développé couché avec barre"
    Et le ExerciseDTO ayant aussi le muscleGroup "Chest"
    Et le ExerciseDTO ayant aussi le equipmentNeeded "Barbell"
    Quand il est convertit en ExerciseDomain
    Alors le ExerciseDomain résultant contient le name "Bench Press"
    Et le ExerciseDomain résultant contient la description "Développé couché avec barre"
    Et le ExerciseDomain résultant contient le muscleGroup "Chest"
    Et le ExerciseDomain résultant contient le equipmentNeeded "Barbell"

  Scénario: Conversion ExerciseResponseDomain vers ExerciseResponseDTO
    Étant donné un ExerciseResponseDomain avec l'id 1
    Et le ExerciseResponseDomain ayant aussi le name "Bench Press"
    Et le ExerciseResponseDomain ayant aussi la description "Développé couché avec barre"
    Et le ExerciseResponseDomain ayant aussi le muscleGroup "Chest"
    Et le ExerciseResponseDomain ayant aussi le equipmentNeeded "Barbell"
    Quand il est convertit en ExerciseResponseDTO
    Alors le ExerciseResponseDTO résultant contient l'id 1
    Et le ExerciseResponseDTO résultant contient le name "Bench Press"
    Et le ExerciseResponseDTO résultant contient la description "Développé couché avec barre"
    Et le ExerciseResponseDTO résultant contient le muscleGroup "Chest"
    Et le ExerciseResponseDTO résultant contient le equipmentNeeded "Barbell"
