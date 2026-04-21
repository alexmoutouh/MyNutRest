package com.alexm.MyNutRest.domain.model;

public record WorkoutResponseDomain(
		Long id,
		String name,
		String description,
		Integer dayOfWeek
) {
}
