package com.alexm.MyNutRest.presentation.dto;

import java.time.Instant;
import java.util.List;

public record NutUserResponseDTO(
		Long id,
		String firstname,
		String lastname,
		String gender,
		Instant birthdate,
		List<NutResponseDTO> nuts
) {
}
