package com.alexm.MyNutRest.cucumber.steps;

import java.math.BigDecimal;
import java.time.Instant;

import com.alexm.MyNutRest.domain.model.NutDomain;
import com.alexm.MyNutRest.domain.model.NutResponseDomain;
import com.alexm.MyNutRest.presentation.dto.NutDTO;
import com.alexm.MyNutRest.presentation.dto.NutResponseDTO;
import com.alexm.MyNutRest.presentation.mapper.NutDTOMapper;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Et;
import io.cucumber.java.fr.Quand;
import io.cucumber.java.fr.Étantdonné;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;
import static org.hamcrest.Matchers.is;

public class NutDTOMapperSteps {

	private BigDecimal nutDTOKcal;
	private BigDecimal nutDTOFat;
	private BigDecimal nutDTOSaturatedFattyAcids;
	private BigDecimal nutDTOCarbohydrates;
	private BigDecimal nutDTOSugar;
	private BigDecimal nutDTOFibers;
	private BigDecimal nutDTOProtein;
	private BigDecimal nutDTOSodium;

	private Long nutResponseDomainId;
	private String nutResponseDomainInstant;
	private BigDecimal nutResponseDomainKcal;
	private BigDecimal nutResponseDomainFat;
	private BigDecimal nutResponseDomainSaturatedFattyAcids;
	private BigDecimal nutResponseDomainCarbohydrates;
	private BigDecimal nutResponseDomainSugar;
	private BigDecimal nutResponseDomainFibers;
	private BigDecimal nutResponseDomainProtein;
	private BigDecimal nutResponseDomainSodium;

	private NutDomain nutDomain;
	private NutResponseDTO nutResponseDTO;

	@Étantdonné("un NutDTO avec {bigdecimal} kcal")
	public void aNutDTOWithXKcal(BigDecimal kcal) {
		nutDTOKcal = kcal;
	}

	@Et("le NutDTO ayant aussi {bigdecimal} fat")
	public void theNutDTOAlsoWithXFat(BigDecimal fat) {
		nutDTOFat = fat;
	}

	@Et("le NutDTO ayant aussi {bigdecimal} saturatedFattyAcids")
	public void theNutDTOAlsoWithXSaturatedFattyAcids(BigDecimal value) {
		nutDTOSaturatedFattyAcids = value;
	}

	@Et("le NutDTO ayant aussi {bigdecimal} carbohydrates")
	public void theNutDTOAlsoWithXCarbohydrates(BigDecimal value) {
		nutDTOCarbohydrates = value;
	}

	@Et("le NutDTO ayant aussi {bigdecimal} sugar")
	public void theNutDTOAlsoWithXSugar(BigDecimal value) {
		nutDTOSugar = value;
	}

	@Et("le NutDTO ayant aussi {bigdecimal} fibers")
	public void theNutDTOAlsoWithXFibers(BigDecimal value) {
		nutDTOFibers = value;
	}

	@Et("le NutDTO ayant aussi {bigdecimal} protein")
	public void theNutDTOAlsoWithXProtein(BigDecimal value) {
		nutDTOProtein = value;
	}

	@Et("le NutDTO ayant aussi {bigdecimal} sodium")
	public void theNutDTOAlsoWithXSodium(BigDecimal value) {
		nutDTOSodium = value;
	}

	@Quand("il est convertit en NutDomain")
	public void itIsConvertedToNutDomain() {
		NutDTO nutDTO = new NutDTO(nutDTOKcal, nutDTOFat, nutDTOSaturatedFattyAcids,
				nutDTOCarbohydrates, nutDTOSugar, nutDTOFibers, nutDTOProtein, nutDTOSodium);
		nutDomain = NutDTOMapper.toDomain(nutDTO);
	}

	@Alors("le NutDomain résultant contient {bigdecimal} kcal")
	public void theResultingNutDomainContainsXKcal(BigDecimal kcal) {
		assertThat(nutDomain.kcal(), comparesEqualTo(kcal));
	}

	@Et("le NutDomain résultant contient {bigdecimal} fat")
	public void theResultingNutDomainContainsXFat(BigDecimal value) {
		assertThat(nutDomain.fat(), comparesEqualTo(value));
	}

	@Et("le NutDomain résultant contient {bigdecimal} saturatedFattyAcids")
	public void theResultingNutDomainContainsXSaturatedFattyAcids(BigDecimal value) {
		assertThat(nutDomain.saturatedFattyAcids(), comparesEqualTo(value));
	}

	@Et("le NutDomain résultant contient {bigdecimal} carbohydrates")
	public void theResultingNutDomainContainsXCarbohydrates(BigDecimal value) {
		assertThat(nutDomain.carbohydrates(), comparesEqualTo(value));
	}

	@Et("le NutDomain résultant contient {bigdecimal} sugar")
	public void theResultingNutDomainContainsXSugar(BigDecimal value) {
		assertThat(nutDomain.sugar(), comparesEqualTo(value));
	}

	@Et("le NutDomain résultant contient {bigdecimal} fibers")
	public void theResultingNutDomainContainsXFibers(BigDecimal value) {
		assertThat(nutDomain.fibers(), comparesEqualTo(value));
	}

	@Et("le NutDomain résultant contient {bigdecimal} protein")
	public void theResultingNutDomainContainsXProtein(BigDecimal value) {
		assertThat(nutDomain.protein(), comparesEqualTo(value));
	}

	@Et("le NutDomain résultant contient {bigdecimal} sodium")
	public void theResultingNutDomainContainsXSodium(BigDecimal value) {
		assertThat(nutDomain.sodium(), comparesEqualTo(value));
	}

	@Étantdonné("un NutResponseDomain avec l'id {long}")
	public void aNutResponseDomainWithId(Long id) {
		nutResponseDomainId = id;
	}

	@Et("le NutResponseDomain ayant aussi l'instant {string}")
	public void theNutResponseDomainAlsoWithInstant(String instant) {
		nutResponseDomainInstant = instant;
	}

	@Et("le NutResponseDomain ayant aussi {bigdecimal} kcal")
	public void theNutResponseDomainAlsoWithXKcal(BigDecimal kcal) {
		nutResponseDomainKcal = kcal;
	}

	@Et("le NutResponseDomain ayant aussi {bigdecimal} fat")
	public void theNutResponseDomainAlsoWithXFat(BigDecimal value) {
		nutResponseDomainFat = value;
	}

	@Et("le NutResponseDomain ayant aussi {bigdecimal} saturatedFattyAcids")
	public void theNutResponseDomainAlsoWithXSaturatedFattyAcids(BigDecimal value) {
		nutResponseDomainSaturatedFattyAcids = value;
	}

	@Et("le NutResponseDomain ayant aussi {bigdecimal} carbohydrates")
	public void theNutResponseDomainAlsoWithXCarbohydrates(BigDecimal value) {
		nutResponseDomainCarbohydrates = value;
	}

	@Et("le NutResponseDomain ayant aussi {bigdecimal} sugar")
	public void theNutResponseDomainAlsoWithXSugar(BigDecimal value) {
		nutResponseDomainSugar = value;
	}

	@Et("le NutResponseDomain ayant aussi {bigdecimal} fibers")
	public void theNutResponseDomainAlsoWithXFibers(BigDecimal value) {
		nutResponseDomainFibers = value;
	}

	@Et("le NutResponseDomain ayant aussi {bigdecimal} protein")
	public void theNutResponseDomainAlsoWithXProtein(BigDecimal value) {
		nutResponseDomainProtein = value;
	}

	@Et("le NutResponseDomain ayant aussi {bigdecimal} sodium")
	public void theNutResponseDomainAlsoWithXSodium(BigDecimal value) {
		nutResponseDomainSodium = value;
	}

	@Quand("il est convertit en NutResponseDTO")
	public void itIsConvertedToNutResponseDTO() {
		NutResponseDomain nutResponseDomain = new NutResponseDomain(nutResponseDomainId,
				Instant.parse(nutResponseDomainInstant), nutResponseDomainKcal, nutResponseDomainFat,
				nutResponseDomainSaturatedFattyAcids, nutResponseDomainCarbohydrates, nutResponseDomainSugar,
				nutResponseDomainFibers, nutResponseDomainProtein, nutResponseDomainSodium);
		nutResponseDTO = NutDTOMapper.toResponseDTO(nutResponseDomain);
	}

	@Alors("le NutResponseDTO résultant contient l'id {long}")
	public void theResultingNutResponseDTOContainsId(Long id) {
		assertThat(nutResponseDTO.id(), is(id));
	}

	@Et("le NutResponseDTO résultant contient l'instant {string}")
	public void theResultingNutResponseDTOContainsInstant(String instant) {
		assertThat(nutResponseDTO.instant(), is(Instant.parse(instant)));
	}

	@Et("le NutResponseDTO résultant contient {bigdecimal} kcal")
	public void theResultingNutResponseDTOContainsXKcal(BigDecimal kcal) {
		assertThat(nutResponseDTO.kcal(), comparesEqualTo(kcal));
	}

	@Et("le NutResponseDTO résultant contient {bigdecimal} fat")
	public void theResultingNutResponseDTOContainsXFat(BigDecimal value) {
		assertThat(nutResponseDTO.fat(), comparesEqualTo(value));
	}

	@Et("le NutResponseDTO résultant contient {bigdecimal} saturatedFattyAcids")
	public void theResultingNutResponseDTOContainsXSaturatedFattyAcids(BigDecimal value) {
		assertThat(nutResponseDTO.saturatedFattyAcids(), comparesEqualTo(value));
	}

	@Et("le NutResponseDTO résultant contient {bigdecimal} carbohydrates")
	public void theResultingNutResponseDTOContainsXCarbohydrates(BigDecimal value) {
		assertThat(nutResponseDTO.carbohydrates(), comparesEqualTo(value));
	}

	@Et("le NutResponseDTO résultant contient {bigdecimal} sugar")
	public void theResultingNutResponseDTOContainsXSugar(BigDecimal value) {
		assertThat(nutResponseDTO.sugar(), comparesEqualTo(value));
	}

	@Et("le NutResponseDTO résultant contient {bigdecimal} fibers")
	public void theResultingNutResponseDTOContainsXFibers(BigDecimal value) {
		assertThat(nutResponseDTO.fibers(), comparesEqualTo(value));
	}

	@Et("le NutResponseDTO résultant contient {bigdecimal} protein")
	public void theResultingNutResponseDTOContainsXProtein(BigDecimal value) {
		assertThat(nutResponseDTO.protein(), comparesEqualTo(value));
	}

	@Et("le NutResponseDTO résultant contient {bigdecimal} sodium")
	public void theResultingNutResponseDTOContainsXSodium(BigDecimal value) {
		assertThat(nutResponseDTO.sodium(), comparesEqualTo(value));
	}
}
