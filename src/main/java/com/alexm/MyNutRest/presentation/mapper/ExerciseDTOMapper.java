package com.alexm.MyNutRest.presentation.mapper;

import com.alexm.MyNutRest.domain.model.ExerciseDomain;
import com.alexm.MyNutRest.domain.model.ExerciseResponseDomain;
import com.alexm.MyNutRest.presentation.dto.request.ExerciseDTO;
import com.alexm.MyNutRest.presentation.dto.response.ExerciseResponseDTO;

public class ExerciseDTOMapper {

	private ExerciseDTOMapper() {
	}

	public static ExerciseDomain toDomain(ExerciseDTO dto) {
		return new ExerciseDomain(
				dto.name(),
				dto.description(),
				dto.muscleGroup(),
				dto.equipmentNeeded()
		);
	}

	public static ExerciseResponseDTO toResponseDTO(ExerciseResponseDomain domain) {
		return new ExerciseResponseDTO(
				domain.id(),
				domain.name(),
				domain.description(),
				domain.muscleGroup(),
				domain.equipmentNeeded()
		);
	}
}
