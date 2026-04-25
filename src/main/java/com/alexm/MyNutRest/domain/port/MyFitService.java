package com.alexm.MyNutRest.domain.port;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;

import com.alexm.MyNutRest.domain.model.ExerciseDomain;
import com.alexm.MyNutRest.domain.model.ExerciseResponseDomain;
import com.alexm.MyNutRest.domain.model.ProgramDomain;
import com.alexm.MyNutRest.domain.model.ProgramResponseDomain;
import com.alexm.MyNutRest.domain.model.UserProgramDomain;
import com.alexm.MyNutRest.domain.model.UserProgramResponseDomain;
import com.alexm.MyNutRest.domain.model.WorkoutDomain;
import com.alexm.MyNutRest.domain.model.WorkoutExerciseDomain;
import com.alexm.MyNutRest.domain.model.WorkoutExerciseResponseDomain;
import com.alexm.MyNutRest.domain.model.WorkoutResponseDomain;

public interface MyFitService {

	@Tool(description = "Crée un nouveau programme d'entraînement fitness. Retourne le programme créé avec son id.")
	ProgramResponseDomain createProgram(ProgramDomain programDomain);

	@Tool(description = "Crée un nouvel exercice fitness. Retourne l'exercice créé avec son id.")
	ExerciseResponseDomain createExercise(ExerciseDomain exerciseDomain);

	@Tool(description = "Ajoute un workout (séance d'entraînement) à un programme existant. Retourne le workout créé avec son id.")
	WorkoutResponseDomain addWorkoutToProgram(
			@ToolParam(description = "Identifiant unique du programme") Long programId,
			WorkoutDomain workoutDomain);

	@Tool(description = "Lie un exercice existant à un workout existant avec les paramètres de séries, répétitions et repos.")
	WorkoutExerciseResponseDomain addExerciseToWorkout(
			@ToolParam(description = "Identifiant unique du workout") Long workoutId,
			@ToolParam(description = "Identifiant unique de l'exercice") Long exerciseId,
			WorkoutExerciseDomain workoutExerciseDomain);

	@Tool(description = "Inscrit un utilisateur existant à un programme d'entraînement existant.")
	UserProgramResponseDomain enrollUserInProgram(
			@ToolParam(description = "Identifiant unique de l'utilisateur") Long userId,
			@ToolParam(description = "Identifiant unique du programme") Long programId,
			UserProgramDomain userProgramDomain);
}
