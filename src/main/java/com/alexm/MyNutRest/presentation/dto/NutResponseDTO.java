package com.alexm.MyNutRest.presentation.dto;

import java.math.BigDecimal;
import java.time.Instant;

public record NutResponseDTO(
	Long id,
	Instant instant,
	BigDecimal kcal,
	BigDecimal fat,
	BigDecimal saturatedFattyAcids,
	BigDecimal carbohydrates,
	BigDecimal sugar,
	BigDecimal fibers,
	BigDecimal protein,
	BigDecimal sodium
) {
}
