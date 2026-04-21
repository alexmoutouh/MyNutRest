# language: fr
Fonctionnalité: Conversion des exercices entre les couches Domain et Infrastructure

  Scénario: Conversion ExerciseDomain vers Exercise entity
    Étant donné un ExerciseDomain avec le name "Bench Press"
    Et la description exercice "Développé couché avec barre"
    Et le muscleGroup "Chest"
    Et le equipmentNeeded "Barbell"
    Quand il est convertit en entité Exercise
    Alors l'entité Exercise résultante contient le name "Bench Press"
    Et l'entité Exercise résultante contient la description "Développé couché avec barre"
    Et l'entité Exercise résultante contient le muscleGroup "Chest"
    Et l'entité Exercise résultante contient le equipmentNeeded "Barbell"

  Scénario: Conversion Exercise entity vers ExerciseResponseDomain
    Étant donné une entité Exercise avec l'id 1
    Et le name exercice "Bench Press"
    Et la description exercice entity "Développé couché avec barre"
    Et le muscleGroup entity "Chest"
    Et le equipmentNeeded entity "Barbell"
    Quand elle est convertit en ExerciseResponseDomain
    Alors le ExerciseResponseDomain résultant contient l'id 1
    Et le ExerciseResponseDomain résultant contient le name "Bench Press"
    Et le ExerciseResponseDomain résultant contient la description "Développé couché avec barre"
    Et le ExerciseResponseDomain résultant contient le muscleGroup "Chest"
    Et le ExerciseResponseDomain résultant contient le equipmentNeeded "Barbell"
