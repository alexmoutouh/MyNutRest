package com.alexm.MyNutRest.domain.mapper;

import java.time.Instant;

import com.alexm.MyNutRest.domain.model.NutDomain;
import com.alexm.MyNutRest.domain.model.NutResponseDomain;
import com.alexm.MyNutRest.infrastructure.entity.Nut;

public class NutDomainMapper {

	private NutDomainMapper() {
	}

	public static Nut toEntity(NutDomain nutDomain) {
		Nut nut = new Nut();
		nut.setInstant(Instant.now());
		nut.setKcal(nutDomain.kcal());
		nut.setFat(nutDomain.fat());
		nut.setSaturatedFattyAcids(nutDomain.saturatedFattyAcids());
		nut.setCarbohydrates(nutDomain.carbohydrates());
		nut.setSugar(nutDomain.sugar());
		nut.setFibers(nutDomain.fibers());
		nut.setProtein(nutDomain.protein());
		nut.setSodium(nutDomain.sodium());
		return nut;
	}

	public static NutResponseDomain toResponseDomain(Nut nut) {
		return new NutResponseDomain(
				nut.getId(),
				nut.getInstant(),
				nut.getKcal(),
				nut.getFat(),
				nut.getSaturatedFattyAcids(),
				nut.getCarbohydrates(),
				nut.getSugar(),
				nut.getFibers(),
				nut.getProtein(),
				nut.getSodium()
		);
	}
}
