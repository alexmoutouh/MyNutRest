package com.alexm.MyNutRest.presentation.mapper;

import com.alexm.MyNutRest.domain.model.NutUserDomain;
import com.alexm.MyNutRest.domain.model.NutUserResponseDomain;
import com.alexm.MyNutRest.presentation.dto.request.UserDTO;
import com.alexm.MyNutRest.presentation.dto.response.NutUserResponseDTO;

public class NutUserDTOMapper {

	private NutUserDTOMapper() {
	}

	public static NutUserDomain toDomain(UserDTO dto) {
		return new NutUserDomain(
				dto.firstname(),
				dto.lastname(),
				dto.gender(),
				dto.birthdate()
		);
	}

	public static NutUserResponseDTO toResponseDTO(NutUserResponseDomain domain) {
		return new NutUserResponseDTO(
				domain.id(),
				domain.firstname(),
				domain.lastname(),
				domain.gender(),
				domain.birthdate(),
				domain.nuts().stream()
						.map(NutDTOMapper::toResponseDTO)
						.toList()
		);
	}
}
