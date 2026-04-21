# language: fr
Fonctionnalité: Gestion des programmes fitness

  Scénario: Créer un programme
    Étant donné un nouveau programme avec le name "Push Pull Legs"
    Et la description du programme "Programme PPL classique"
    Et la difficulté du programme "INTERMEDIATE"
    Et la durée du programme 12 semaines
    Quand on effectue un POST fitness sur '/my-nut/api/v1/program'
    Alors la réponse HTTP fitness est 200
    Et la réponse programme contient le name "Push Pull Legs"
    Et la réponse programme contient la difficulté "INTERMEDIATE"
    Et la réponse programme contient la durée 12

  Scénario: Créer un exercice
    Étant donné un nouvel exercice avec le name "Bench Press"
    Et la description de l'exercice "Développé couché avec barre"
    Et le muscleGroup de l'exercice "Chest"
    Et le equipmentNeeded de l'exercice "Barbell"
    Quand on effectue un POST fitness sur '/my-nut/api/v1/exercise'
    Alors la réponse HTTP fitness est 200
    Et la réponse exercice contient le name "Bench Press"
    Et la réponse exercice contient le muscleGroup "Chest"

  Scénario: Ajouter un workout à un programme existant
    Étant donné un programme existant avec l'id 1
    Et un nouveau workout avec le name "Push Day"
    Et la description du workout "Séance poussée"
    Et le dayOfWeek du workout 1
    Quand on effectue un POST fitness sur '/my-nut/api/v1/program/id/{program-id}/workout'
    Alors la réponse HTTP fitness est 200
    Et la réponse workout contient le name "Push Day"
    Et la réponse workout contient le dayOfWeek 1

  Scénario: Ajouter un workout à un programme inexistant
    Étant donné un programme inexistant avec l'id 999
    Et un nouveau workout avec le name "Push Day"
    Et la description du workout "Séance poussée"
    Et le dayOfWeek du workout 1
    Quand on effectue un POST fitness sur '/my-nut/api/v1/program/id/{program-id}/workout'
    Alors une erreur fitness est levée avec le message "Program not found"

  Scénario: Lier un exercice à un workout existant
    Étant donné un workout existant avec l'id 1 et un exercice existant avec l'id 2
    Et un lien workout-exercice avec le orderInWorkout 1
    Et le sets du lien 4
    Et le reps du lien 10
    Et le restSeconds du lien 90
    Quand on effectue un POST fitness sur '/my-nut/api/v1/workout/id/{workout-id}/exercise/{exercise-id}'
    Alors la réponse HTTP fitness est 200
    Et la réponse workoutExercise contient le sets 4
    Et la réponse workoutExercise contient le reps 10
    Et la réponse workoutExercise contient le orderInWorkout 1

  Scénario: Lier un exercice à un workout inexistant
    Étant donné un workout inexistant avec l'id 999 et un exercice existant avec l'id 2
    Et un lien workout-exercice avec le orderInWorkout 1
    Et le sets du lien 4
    Et le reps du lien 10
    Et le restSeconds du lien 90
    Quand on effectue un POST fitness sur '/my-nut/api/v1/workout/id/{workout-id}/exercise/{exercise-id}'
    Alors une erreur fitness est levée avec le message "Workout not found"

  Scénario: Inscrire un utilisateur à un programme existant
    Étant donné un utilisateur fitness existant avec l'id 1 et un programme existant avec l'id 2
    Et une inscription avec la startDate "2024-06-01"
    Et la endDate de l'inscription "2024-08-31"
    Et le isActive de l'inscription true
    Quand on effectue un POST fitness sur '/my-nut/api/v1/user/id/{user-id}/program/{program-id}'
    Alors la réponse HTTP fitness est 200
    Et la réponse userProgram contient la startDate "2024-06-01"
    Et la réponse userProgram contient le isActive true

  Scénario: Inscrire un utilisateur inexistant à un programme
    Étant donné un utilisateur fitness inexistant avec l'id 999 et un programme existant avec l'id 2
    Et une inscription avec la startDate "2024-06-01"
    Et la endDate de l'inscription "2024-08-31"
    Et le isActive de l'inscription true
    Quand on effectue un POST fitness sur '/my-nut/api/v1/user/id/{user-id}/program/{program-id}'
    Alors une erreur fitness est levée avec le message "User not found"
