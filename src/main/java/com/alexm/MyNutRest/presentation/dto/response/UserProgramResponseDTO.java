package com.alexm.MyNutRest.presentation.dto.response;

import java.time.LocalDate;

public record UserProgramResponseDTO(
		Long userId,
		Long programId,
		LocalDate startDate,
		LocalDate endDate,
		Boolean isActive
) {
}
