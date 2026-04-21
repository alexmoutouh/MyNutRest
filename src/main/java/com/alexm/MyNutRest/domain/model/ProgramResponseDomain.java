package com.alexm.MyNutRest.domain.model;

import java.time.Instant;

public record ProgramResponseDomain(
		Long id,
		String name,
		String description,
		String difficulty,
		Integer durationWeeks,
		Instant createdAt
) {
}
