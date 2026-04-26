package com.alexm.MyNutRest.presentation.dto.response;

import java.util.List;

import com.alexm.MyNutRest.domain.model.NutScanStatus;

public record NutScanResponseDTO(
		NutScanStatus status,
		List<String> messages,
		NutResponseDTO nut
) {
}
