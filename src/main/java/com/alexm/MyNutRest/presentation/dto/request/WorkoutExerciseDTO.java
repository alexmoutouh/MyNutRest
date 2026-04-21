package com.alexm.MyNutRest.presentation.dto.request;

public record WorkoutExerciseDTO(Integer orderInWorkout, Integer sets, Integer reps, Integer restSeconds) {
}
