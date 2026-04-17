package com.alexm.MyNutRest.domain.model;

import java.math.BigDecimal;
import java.time.Instant;

public record NutResponseDomain(
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
