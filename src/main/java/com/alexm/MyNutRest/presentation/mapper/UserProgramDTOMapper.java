package com.alexm.MyNutRest.presentation.mapper;

import com.alexm.MyNutRest.domain.model.UserProgramDomain;
import com.alexm.MyNutRest.domain.model.UserProgramResponseDomain;
import com.alexm.MyNutRest.presentation.dto.request.UserProgramDTO;
import com.alexm.MyNutRest.presentation.dto.response.UserProgramResponseDTO;

public class UserProgramDTOMapper {

	private UserProgramDTOMapper() {
	}

	public static UserProgramDomain toDomain(UserProgramDTO dto) {
		return new UserProgramDomain(
				dto.startDate(),
				dto.endDate(),
				dto.isActive()
		);
	}

	public static UserProgramResponseDTO toResponseDTO(UserProgramResponseDomain domain) {
		return new UserProgramResponseDTO(
				domain.userId(),
				domain.programId(),
				domain.startDate(),
				domain.endDate(),
				domain.isActive()
		);
	}
}
