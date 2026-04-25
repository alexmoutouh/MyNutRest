package com.alexm.MyNutRest.infrastructure.mapper;

import com.alexm.MyNutRest.domain.model.UserProgramDomain;
import com.alexm.MyNutRest.domain.model.UserProgramResponseDomain;
import com.alexm.MyNutRest.infrastructure.entity.UserProgram;
import com.alexm.MyNutRest.infrastructure.entity.UserProgramId;

public class UserProgramDomainMapper {

	private UserProgramDomainMapper() {
	}

	public static UserProgram toEntity(Long userId, Long programId, UserProgramDomain domain) {
		UserProgram userProgram = new UserProgram();
		UserProgramId id = new UserProgramId(userId, programId, domain.startDate());
		userProgram.setId(id);
		userProgram.setEndDate(domain.endDate());
		userProgram.setIsActive(domain.isActive());
		return userProgram;
	}

	public static UserProgramResponseDomain toResponseDomain(UserProgram userProgram) {
		return new UserProgramResponseDomain(
				userProgram.getId().getUserId(),
				userProgram.getId().getProgramId(),
				userProgram.getId().getStartDate(),
				userProgram.getEndDate(),
				userProgram.getIsActive()
		);
	}
}
