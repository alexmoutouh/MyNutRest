package com.alexm.MyNutRest.cucumber.steps;

import java.math.BigDecimal;
import java.time.Instant;

import com.alexm.MyNutRest.domain.mapper.NutDomainMapper;
import com.alexm.MyNutRest.domain.model.NutDomain;
import com.alexm.MyNutRest.domain.model.NutResponseDomain;
import com.alexm.MyNutRest.infrastructure.entity.Nut;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Et;
import io.cucumber.java.fr.Quand;
import io.cucumber.java.fr.Étantdonné;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class NutDomainMapperSteps {

	private BigDecimal kcalDomain;
	private BigDecimal fatDomain;
	private BigDecimal saturatedFattyAcidsDomain;
	private BigDecimal carbohydratesDomain;
	private BigDecimal sugarDomain;
	private BigDecimal fibersDomain;
	private BigDecimal proteinDomain;
	private BigDecimal sodiumDomain;
	private Nut nutEntity;

	private Long idEntity;
	private String instantEntity;
	private BigDecimal kcalEntity;
	private BigDecimal fatEntity;
	private BigDecimal saturatedFattyAcidsEntity;
	private BigDecimal carbohydratesEntity;
	private BigDecimal sugarEntity;
	private BigDecimal fibersEntity;
	private BigDecimal proteinEntity;
	private BigDecimal sodiumEntity;
	private NutResponseDomain nutResponseDomain;

	@Étantdonné("un NutDomain avec {bigdecimal} kcal")
	public void aNutDomainWithXKCal(BigDecimal kcal) {
		kcalDomain = kcal;
	}

	@Et("{bigdecimal} fat")
	public void andXFat(BigDecimal fat) {
		fatDomain = fat;
		fatEntity = fat;
	}

	@Et("{bigdecimal} saturatedFattyAcids")
	public void andXSaturatedFattyAcids(BigDecimal sfa) {
		saturatedFattyAcidsDomain = sfa;
		saturatedFattyAcidsEntity = sfa;
	}

	@Et("{bigdecimal} carbohydrates")
	public void andXCarbohydrates(BigDecimal carbohydrates) {
		carbohydratesDomain = carbohydrates;
		carbohydratesEntity = carbohydrates;
	}

	@Et("{bigdecimal} sugar")
	public void andXSugar(BigDecimal sugar) {
		sugarDomain = sugar;
		sugarEntity = sugar;
	}

	@Et("{bigdecimal} fibers")
	public void andXFibers(BigDecimal fibers) {
		fibersDomain = fibers;
		fibersEntity = fibers;
	}

	@Et("{bigdecimal} protein")
	public void andXProtein(BigDecimal protein) {
		proteinDomain = protein;
		proteinEntity = protein;
	}

	@Et("{bigdecimal} sodium")
	public void andXSodium(BigDecimal sodium) {
		sodiumDomain = sodium;
		sodiumEntity = sodium;
	}

	@Quand("il est convertit en entité Nut")
	public void itIsConvertedToNutEntity() {
		NutDomain nutDomain = new NutDomain(kcalDomain,
				fatDomain, saturatedFattyAcidsDomain,
				carbohydratesDomain, sugarDomain, fibersDomain,
				proteinDomain,
				sodiumDomain);
		nutEntity = NutDomainMapper.toEntity(nutDomain);
	}

	@Alors("l'entité Nut résultante contient {bigdecimal} kcal")
	public void theEntityContainsXKcal(BigDecimal kcal) {
		assertThat(nutEntity.getKcal(), comparesEqualTo(kcal));
	}

	@Et("l'entité Nut résultante contient {bigdecimal} fat")
	public void theEntityContainsXFat(BigDecimal fat) {
		assertThat(nutEntity.getFat(), comparesEqualTo(fat));
	}

	@Et("l'entité Nut résultante contient {bigdecimal} saturatedFattyAcids")
	public void theEntityContainsXSaturatedFattyAcids(BigDecimal sfa) {
		assertThat(nutEntity.getSaturatedFattyAcids(), comparesEqualTo(sfa));
	}

	@Et("l'entité Nut résultante contient {bigdecimal} carbohydrates")
	public void theEntityContainsXCarbohydrates(BigDecimal carbohydrates) {
		assertThat(nutEntity.getCarbohydrates(), comparesEqualTo(carbohydrates));
	}

	@Et("l'entité Nut résultante contient {bigdecimal} sugar")
	public void theEntityContainsXSugar(BigDecimal sugar) {
		assertThat(nutEntity.getSugar(), comparesEqualTo(sugar));
	}

	@Et("l'entité Nut résultante contient {bigdecimal} fibers")
	public void theEntityContainsXFibers(BigDecimal fibers) {
		assertThat(nutEntity.getFibers(), comparesEqualTo(fibers));
	}

	@Et("l'entité Nut résultante contient {bigdecimal} protein")
	public void theEntityContainsXProtein(BigDecimal protein) {
		assertThat(nutEntity.getProtein(), comparesEqualTo(protein));
	}

	@Et("l'entité Nut résultante contient {bigdecimal} sodium")
	public void theEntityContainsXSodium(BigDecimal sodium) {
		assertThat(nutEntity.getSodium(), comparesEqualTo(sodium));
	}

	@Et("l'entité Nut résultante contient un instant non null")
	public void theEntityContainsANonNullInstant() {
		assertThat(nutEntity.getInstant(), is(notNullValue()));
	}

	@Étantdonné("une entité Nut avec l'id {long}")
	public void aNutEntityWithId(Long id) {
		idEntity = id;
	}

	@Et("l'instant {string}")
	public void andWithInstant(String instant) {
		instantEntity = instant;
	}

	@Et("{bigdecimal} kcal")
	public void andWithXKCal(BigDecimal kcal) {
		kcalEntity = kcal;
	}

	@Quand("elle est convertit en NutResponseDomain")
	public void itIsConvertedToNutResponseDomain() {
		Nut nutEntitySource = new Nut(idEntity, Instant.parse(instantEntity),
				kcalEntity,
				fatEntity, saturatedFattyAcidsEntity,
				carbohydratesEntity, sugarEntity, fibersEntity,
				proteinEntity,
				sodiumEntity,
				null);
		nutResponseDomain = NutDomainMapper.toResponseDomain(nutEntitySource);
	}

	@Alors("le NutResponseDomain résultant contient l'id {long}")
	public void theNutResponseDomainContainsId(Long id) {
		assertThat(nutResponseDomain.id(), is(id));
	}

	@Et("le NutResponseDomain résultant contient l'instant {string}")
	public void theNutResponseDomainContainsInstant(String instant) {
		assertThat(nutResponseDomain.instant(), is(Instant.parse(instant)));
	}

	@Et("le NutResponseDomain résultant contient {bigdecimal} kcal")
	public void theNutResponseDomainContainsXKcal(BigDecimal kcal) {
		assertThat(nutResponseDomain.kcal(), comparesEqualTo(kcal));
	}

	@Et("le NutResponseDomain résultant contient {bigdecimal} fat")
	public void theNutResponseDomainContainsXFat(BigDecimal fat) {
		assertThat(nutResponseDomain.fat(), comparesEqualTo(fat));
	}

	@Et("le NutResponseDomain résultant contient {bigdecimal} saturatedFattyAcids")
	public void theNutResponseDomainContainsXSaturatedFattyAcids(BigDecimal sfa) {
		assertThat(nutResponseDomain.saturatedFattyAcids(), comparesEqualTo(sfa));
	}

	@Et("le NutResponseDomain résultant contient {bigdecimal} carbohydrates")
	public void theNutResponseDomainContainsXCarbohydrates(BigDecimal carbohydrates) {
		assertThat(nutResponseDomain.carbohydrates(), comparesEqualTo(carbohydrates));
	}

	@Et("le NutResponseDomain résultant contient {bigdecimal} sugar")
	public void theNutResponseDomainContainsXSugar(BigDecimal sugar) {
		assertThat(nutResponseDomain.sugar(), comparesEqualTo(sugar));
	}

	@Et("le NutResponseDomain résultant contient {bigdecimal} fibers")
	public void theNutResponseDomainContainsXFibers(BigDecimal fibers) {
		assertThat(nutResponseDomain.fibers(), comparesEqualTo(fibers));
	}

	@Et("le NutResponseDomain résultant contient {bigdecimal} protein")
	public void theNutResponseDomainContainsXProtein(BigDecimal protein) {
		assertThat(nutResponseDomain.protein(), comparesEqualTo(protein));
	}

	@Et("le NutResponseDomain résultant contient {bigdecimal} sodium")
	public void theNutResponseDomainContainsXSodium(BigDecimal sodium) {
		assertThat(nutResponseDomain.sodium(), comparesEqualTo(sodium));
	}
}
