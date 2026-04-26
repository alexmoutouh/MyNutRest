package com.alexm.MyNutRest.presentation.mapper;

import com.alexm.MyNutRest.domain.model.NutScanResultDomain;
import com.alexm.MyNutRest.presentation.dto.response.NutScanResponseDTO;

public class NutScanDTOMapper {

	private NutScanDTOMapper() {
	}

	public static NutScanResponseDTO toResponseDTO(NutScanResultDomain domain) {
		return new NutScanResponseDTO(
				domain.status(),
				domain.messages(),
				domain.nutResponse() != null ? NutDTOMapper.toResponseDTO(domain.nutResponse()) : null
		);
	}
}
