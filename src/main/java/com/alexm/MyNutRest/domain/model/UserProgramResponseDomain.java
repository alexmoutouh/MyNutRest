package com.alexm.MyNutRest.domain.model;

import java.time.LocalDate;

public record UserProgramResponseDomain(
		Long userId,
		Long programId,
		LocalDate startDate,
		LocalDate endDate,
		Boolean isActive
) {
}
