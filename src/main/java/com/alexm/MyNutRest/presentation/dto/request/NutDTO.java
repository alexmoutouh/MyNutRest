package com.alexm.MyNutRest.presentation.dto.request;

import java.math.BigDecimal;

public record NutDTO(
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
