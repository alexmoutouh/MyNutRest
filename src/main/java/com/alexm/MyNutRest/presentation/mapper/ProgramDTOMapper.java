package com.alexm.MyNutRest.presentation.mapper;

import com.alexm.MyNutRest.domain.model.ProgramDomain;
import com.alexm.MyNutRest.domain.model.ProgramResponseDomain;
import com.alexm.MyNutRest.presentation.dto.request.ProgramDTO;
import com.alexm.MyNutRest.presentation.dto.response.ProgramResponseDTO;

public class ProgramDTOMapper {

	private ProgramDTOMapper() {
	}

	public static ProgramDomain toDomain(ProgramDTO dto) {
		return new ProgramDomain(
				dto.name(),
				dto.description(),
				dto.difficulty(),
				dto.durationWeeks()
		);
	}

	public static ProgramResponseDTO toResponseDTO(ProgramResponseDomain domain) {
		return new ProgramResponseDTO(
				domain.id(),
				domain.name(),
				domain.description(),
				domain.difficulty(),
				domain.durationWeeks(),
				domain.createdAt()
		);
	}
}
