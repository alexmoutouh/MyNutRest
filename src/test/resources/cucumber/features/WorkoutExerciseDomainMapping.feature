# language: fr
Fonctionnalité: Conversion des liens workout-exercice entre les couches Domain et Infrastructure

  Scénario: Conversion WorkoutExerciseDomain vers WorkoutExercise entity
    Étant donné un WorkoutExerciseDomain avec le workoutId 1 et le exerciseId 2
    Et le orderInWorkout 1
    Et le sets 4
    Et le reps 10
    Et le restSeconds 90
    Quand il est convertit en entité WorkoutExercise
    Alors l'entité WorkoutExercise résultante contient le workoutId 1
    Et l'entité WorkoutExercise résultante contient le exerciseId 2
    Et l'entité WorkoutExercise résultante contient le orderInWorkout 1
    Et l'entité WorkoutExercise résultante contient le sets 4
    Et l'entité WorkoutExercise résultante contient le reps 10
    Et l'entité WorkoutExercise résultante contient le restSeconds 90

  Scénario: Conversion WorkoutExercise entity vers WorkoutExerciseResponseDomain
    Étant donné une entité WorkoutExercise avec le workoutId 1 et le exerciseId 2
    Et le orderInWorkout entity 1
    Et le sets entity 4
    Et le reps entity 10
    Et le restSeconds entity 90
    Quand elle est convertit en WorkoutExerciseResponseDomain
    Alors le WorkoutExerciseResponseDomain résultant contient le workoutId 1
    Et le WorkoutExerciseResponseDomain résultant contient le exerciseId 2
    Et le WorkoutExerciseResponseDomain résultant contient le orderInWorkout 1
    Et le WorkoutExerciseResponseDomain résultant contient le sets 4
    Et le WorkoutExerciseResponseDomain résultant contient le reps 10
    Et le WorkoutExerciseResponseDomain résultant contient le restSeconds 90
