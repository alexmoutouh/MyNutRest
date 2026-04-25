package com.alexm.MyNutRest.infrastructure.mapper;

import java.time.Instant;
import java.util.Collections;

import com.alexm.MyNutRest.domain.model.NutUserDomain;
import com.alexm.MyNutRest.domain.model.NutUserResponseDomain;
import com.alexm.MyNutRest.infrastructure.entity.NutUser;

public class NutUserDomainMapper {

	private NutUserDomainMapper() {
	}

	public static NutUser toEntity(NutUserDomain userDomain) {
		NutUser user = new NutUser();
		user.setFirstname(userDomain.firstname());
		user.setLastname(userDomain.lastname());
		user.setGender(userDomain.gender());
		user.setBirthdate(Instant.parse(userDomain.birthdate()));
		return user;
	}

	public static NutUserResponseDomain toResponseDomain(NutUser user) {
		return new NutUserResponseDomain(
				user.getId(),
				user.getFirstname(),
				user.getLastname(),
				user.getGender(),
				user.getBirthdate(),
				user.getNuts() != null
						? user.getNuts().stream().map(NutDomainMapper::toResponseDomain).toList()
						: Collections.emptyList()
		);
	}
}
