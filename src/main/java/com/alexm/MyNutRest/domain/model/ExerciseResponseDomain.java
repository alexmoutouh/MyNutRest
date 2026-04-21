package com.alexm.MyNutRest.domain.model;

public record ExerciseResponseDomain(
		Long id,
		String name,
		String description,
		String muscleGroup,
		String equipmentNeeded
) {
}
