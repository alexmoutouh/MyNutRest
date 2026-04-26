package com.alexm.MyNutRest.domain.model;

import java.util.List;

public record NutScanResultDomain(
		NutScanStatus status,
		List<String> messages,
		NutResponseDomain nutResponse
) {
}
