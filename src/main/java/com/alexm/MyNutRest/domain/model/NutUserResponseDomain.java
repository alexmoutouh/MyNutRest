package com.alexm.MyNutRest.domain.model;

import java.time.Instant;
import java.util.List;

public record NutUserResponseDomain(
		Long id,
		String firstname,
		String lastname,
		String gender,
		Instant birthdate,
		List<NutResponseDomain> nuts
) {
}
