package com.alexm.MyNutRest.domain.model;

public record WorkoutExerciseResponseDomain(
		Long workoutId,
		Long exerciseId,
		Integer orderInWorkout,
		Integer sets,
		Integer reps,
		Integer restSeconds
) {
}
