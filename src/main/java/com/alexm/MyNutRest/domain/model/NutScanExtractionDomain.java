package com.alexm.MyNutRest.domain.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public record NutScanExtractionDomain(
		BigDecimal kcal,
		BigDecimal fat,
		BigDecimal saturatedFattyAcids,
		BigDecimal carbohydrates,
		BigDecimal sugar,
		BigDecimal fibers,
		BigDecimal protein,
		BigDecimal sodium
) {
	public List<String> getNullFieldNames() {
		List<String> nulls = new ArrayList<>();
		if (kcal == null) nulls.add("kcal");
		if (fat == null) nulls.add("fat");
		if (saturatedFattyAcids == null) nulls.add("saturatedFattyAcids");
		if (carbohydrates == null) nulls.add("carbohydrates");
		if (sugar == null) nulls.add("sugar");
		if (fibers == null) nulls.add("fibers");
		if (protein == null) nulls.add("protein");
		if (sodium == null) nulls.add("sodium");
		return nulls;
	}
}
