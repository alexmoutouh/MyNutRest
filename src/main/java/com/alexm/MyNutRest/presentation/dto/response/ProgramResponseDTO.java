package com.alexm.MyNutRest.presentation.dto.response;

import java.time.Instant;

public record ProgramResponseDTO(
		Long id,
		String name,
		String description,
		String difficulty,
		Integer durationWeeks,
		Instant createdAt
) {
}
