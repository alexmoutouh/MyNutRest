package com.alexm.MyNutRest.domain.model;

import java.math.BigDecimal;
import org.springframework.ai.tool.annotation.ToolParam;

public record NutDomain(
		@ToolParam(description = "Kilocalories") BigDecimal kcal,
		@ToolParam(description = "Lipides en grammes") BigDecimal fat,
		@ToolParam(description = "Acides gras saturés en grammes") BigDecimal saturatedFattyAcids,
		@ToolParam(description = "Glucides en grammes") BigDecimal carbohydrates,
		@ToolParam(description = "Sucre en grammes") BigDecimal sugar,
		@ToolParam(description = "Fibres en grammes") BigDecimal fibers,
		@ToolParam(description = "Protéines en grammes") BigDecimal protein,
		@ToolParam(description = "Sodium en grammes") BigDecimal sodium
) {
}
