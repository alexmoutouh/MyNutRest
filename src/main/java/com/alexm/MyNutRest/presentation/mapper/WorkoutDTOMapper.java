package com.alexm.MyNutRest.presentation.mapper;

import com.alexm.MyNutRest.domain.model.WorkoutDomain;
import com.alexm.MyNutRest.domain.model.WorkoutResponseDomain;
import com.alexm.MyNutRest.presentation.dto.request.WorkoutDTO;
import com.alexm.MyNutRest.presentation.dto.response.WorkoutResponseDTO;

public class WorkoutDTOMapper {

	private WorkoutDTOMapper() {
	}

	public static WorkoutDomain toDomain(WorkoutDTO dto) {
		return new WorkoutDomain(
				dto.name(),
				dto.description(),
				dto.dayOfWeek()
		);
	}

	public static WorkoutResponseDTO toResponseDTO(WorkoutResponseDomain domain) {
		return new WorkoutResponseDTO(
				domain.id(),
				domain.name(),
				domain.description(),
				domain.dayOfWeek()
		);
	}
}
