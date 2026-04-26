package com.alexm.MyNutRest.domain.port;

import com.alexm.MyNutRest.domain.model.NutScanExtractionDomain;

public interface NutScanPort {
	NutScanExtractionDomain extractNutritionFromImage(byte[] imageBytes);
}
