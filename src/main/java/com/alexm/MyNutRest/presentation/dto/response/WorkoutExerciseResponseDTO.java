package com.alexm.MyNutRest.presentation.dto.response;

public record WorkoutExerciseResponseDTO(
		Long workoutId,
		Long exerciseId,
		Integer orderInWorkout,
		Integer sets,
		Integer reps,
		Integer restSeconds
) {
}
