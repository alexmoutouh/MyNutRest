package com.alexm.MyNutRest.domain.model;

import org.springframework.ai.tool.annotation.ToolParam;

public record WorkoutExerciseDomain(
		@ToolParam(description = "Ordre de l'exercice dans le workout") Integer orderInWorkout,
		@ToolParam(description = "Nombre de séries") Integer sets,
		@ToolParam(description = "Nombre de répétitions") Integer reps,
		@ToolParam(description = "Temps de repos en secondes") Integer restSeconds
) {
}
