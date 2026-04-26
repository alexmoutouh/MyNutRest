package com.alexm.MyNutRest.domain.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.alexm.MyNutRest.domain.model.NutDomain;
import com.alexm.MyNutRest.domain.model.NutResponseDomain;
import com.alexm.MyNutRest.domain.model.NutScanExtractionDomain;
import com.alexm.MyNutRest.domain.model.NutScanResultDomain;
import com.alexm.MyNutRest.domain.model.NutScanStatus;
import com.alexm.MyNutRest.domain.port.MyNutPort;
import com.alexm.MyNutRest.domain.port.MyNutScanService;
import com.alexm.MyNutRest.domain.port.NutScanPort;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MyNutScanServiceImpl implements MyNutScanService {

	private static final BigDecimal HUNDRED = BigDecimal.valueOf(100);

	private final NutScanPort nutScanPort;
	private final MyNutPort myNutPort;

	@Override
	public NutScanResultDomain scanAndSave(Long userId, byte[] imageBytes, BigDecimal grams) {
		NutScanExtractionDomain extraction = nutScanPort.extractNutritionFromImage(imageBytes);

		List<String> messages = new ArrayList<>();
		NutScanStatus status = evaluateStatus(extraction, messages);

		if (status == NutScanStatus.FAILURE) {
			return new NutScanResultDomain(status, messages, null);
		}

		NutDomain scaled = applyRatio(extraction, grams);
		NutResponseDomain saved = myNutPort.save(userId, scaled);

		return new NutScanResultDomain(status, messages, saved);
	}

	private NutScanStatus evaluateStatus(NutScanExtractionDomain extraction, List<String> messages) {
		List<String> nullFields = extraction.getNullFieldNames();

		if (nullFields.size() == 8) {
			messages.add("Impossible d'extraire les informations nutritionnelles de cette image.");
			return NutScanStatus.FAILURE;
		}
		if (!nullFields.isEmpty()) {
			messages.add("Champs non reconnus : " + String.join(", ", nullFields));
			return NutScanStatus.PARTIAL;
		}
		return NutScanStatus.COMPLETE;
	}

	private NutDomain applyRatio(NutScanExtractionDomain extraction, BigDecimal grams) {
		return new NutDomain(
				scale(extraction.kcal(), grams),
				scale(extraction.fat(), grams),
				scale(extraction.saturatedFattyAcids(), grams),
				scale(extraction.carbohydrates(), grams),
				scale(extraction.sugar(), grams),
				scale(extraction.fibers(), grams),
				scale(extraction.protein(), grams),
				scale(extraction.sodium(), grams)
		);
	}

	private BigDecimal scale(BigDecimal valuePer100g, BigDecimal grams) {
		if (valuePer100g == null) return null;
		return valuePer100g.multiply(grams).divide(HUNDRED, 2, RoundingMode.HALF_UP);
	}
}
