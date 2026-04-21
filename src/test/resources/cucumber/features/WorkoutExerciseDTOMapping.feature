# language: fr
Fonctionnalité: Conversion des liens workout-exercice entre les couches Presentation et Domain

  Scénario: Conversion WorkoutExerciseDTO vers WorkoutExerciseDomain
    Étant donné un WorkoutExerciseDTO avec le orderInWorkout 1
    Et le WorkoutExerciseDTO ayant aussi le sets 4
    Et le WorkoutExerciseDTO ayant aussi le reps 10
    Et le WorkoutExerciseDTO ayant aussi le restSeconds 90
    Quand il est convertit en WorkoutExerciseDomain
    Alors le WorkoutExerciseDomain résultant contient le orderInWorkout 1
    Et le WorkoutExerciseDomain résultant contient le sets 4
    Et le WorkoutExerciseDomain résultant contient le reps 10
    Et le WorkoutExerciseDomain résultant contient le restSeconds 90

  Scénario: Conversion WorkoutExerciseResponseDomain vers WorkoutExerciseResponseDTO
    Étant donné un WorkoutExerciseResponseDomain avec le workoutId 1 et le exerciseId 2
    Et le WorkoutExerciseResponseDomain ayant aussi le orderInWorkout 1
    Et le WorkoutExerciseResponseDomain ayant aussi le sets 4
    Et le WorkoutExerciseResponseDomain ayant aussi le reps 10
    Et le WorkoutExerciseResponseDomain ayant aussi le restSeconds 90
    Quand il est convertit en WorkoutExerciseResponseDTO
    Alors le WorkoutExerciseResponseDTO résultant contient le workoutId 1
    Et le WorkoutExerciseResponseDTO résultant contient le exerciseId 2
    Et le WorkoutExerciseResponseDTO résultant contient le orderInWorkout 1
    Et le WorkoutExerciseResponseDTO résultant contient le sets 4
    Et le WorkoutExerciseResponseDTO résultant contient le reps 10
    Et le WorkoutExerciseResponseDTO résultant contient le restSeconds 90
