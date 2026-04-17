package com.alexm.MyNutRest.presentation.mapper;

import com.alexm.MyNutRest.domain.model.NutDomain;
import com.alexm.MyNutRest.domain.model.NutResponseDomain;
import com.alexm.MyNutRest.presentation.dto.NutDTO;
import com.alexm.MyNutRest.presentation.dto.NutResponseDTO;

public class NutDTOMapper {

	private NutDTOMapper() {
	}

	public static NutDomain toDomain(NutDTO dto) {
		return new NutDomain(
			dto.kcal(),
			dto.fat(),
			dto.saturatedFattyAcids(),
			dto.carbohydrates(),
			dto.sugar(),
			dto.fibers(),
			dto.protein(),
			dto.sodium()
		);
	}

	public static NutResponseDTO toResponseDTO(NutResponseDomain domain) {
		return new NutResponseDTO(
			domain.id(),
			domain.instant(),
			domain.kcal(),
			domain.fat(),
			domain.saturatedFattyAcids(),
			domain.carbohydrates(),
			domain.sugar(),
			domain.fibers(),
			domain.protein(),
			domain.sodium()
		);
	}
}
