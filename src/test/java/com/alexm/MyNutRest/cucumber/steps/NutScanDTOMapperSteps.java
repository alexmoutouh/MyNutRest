package com.alexm.MyNutRest.cucumber.steps;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.alexm.MyNutRest.domain.model.NutResponseDomain;
import com.alexm.MyNutRest.domain.model.NutScanResultDomain;
import com.alexm.MyNutRest.domain.model.NutScanStatus;
import com.alexm.MyNutRest.presentation.dto.response.NutScanResponseDTO;
import com.alexm.MyNutRest.presentation.mapper.NutScanDTOMapper;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Et;
import io.cucumber.java.fr.Quand;
import io.cucumber.java.fr.Étantdonné;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;

public class NutScanDTOMapperSteps {

	private NutScanStatus status;
	private List<String> messages = new ArrayList<>();
	private Long nutResponseId;
	private Instant nutResponseInstant;
	private BigDecimal nutKcal;
	private BigDecimal nutFat;
	private BigDecimal nutSaturatedFattyAcids;
	private BigDecimal nutCarbohydrates;
	private BigDecimal nutSugar;
	private BigDecimal nutFibers;
	private BigDecimal nutProtein;
	private BigDecimal nutSodium;
	private boolean hasNutResponse = true;

	private NutScanResponseDTO result;

	@Étantdonné("un NutScanResultDomain avec le statut {string}")
	public void aNutScanResultDomainWithStatus(String statusStr) {
		status = NutScanStatus.valueOf(statusStr);
	}

	@Et("le NutScanResultDomain sans messages")
	public void theNutScanResultDomainWithNoMessages() {
		messages = new ArrayList<>();
	}

	@Et("le NutScanResultDomain avec le message {string}")
	public void theNutScanResultDomainWithMessage(String message) {
		messages.add(message);
	}

	@Et("le NutScanResultDomain avec une réponse nutritionnelle id {long} et instant {string}")
	public void theNutScanResultDomainWithNutResponse(Long id, String instant) {
		hasNutResponse = true;
		nutResponseId = id;
		nutResponseInstant = Instant.parse(instant);
	}

	@Et("le NutScanResultDomain sans réponse nutritionnelle")
	public void theNutScanResultDomainWithNoNutResponse() {
		hasNutResponse = false;
	}

	@Et("la réponse nutritionnelle ayant {bigdecimal} kcal")
	public void theNutResponseWithKcal(BigDecimal value) { nutKcal = value; }

	@Et("la réponse nutritionnelle ayant {bigdecimal} fat")
	public void theNutResponseWithFat(BigDecimal value) { nutFat = value; }

	@Et("la réponse nutritionnelle ayant {bigdecimal} saturatedFattyAcids")
	public void theNutResponseWithSaturatedFattyAcids(BigDecimal value) { nutSaturatedFattyAcids = value; }

	@Et("la réponse nutritionnelle ayant {bigdecimal} carbohydrates")
	public void theNutResponseWithCarbohydrates(BigDecimal value) { nutCarbohydrates = value; }

	@Et("la réponse nutritionnelle ayant {bigdecimal} sugar")
	public void theNutResponseWithSugar(BigDecimal value) { nutSugar = value; }

	@Et("la réponse nutritionnelle ayant {bigdecimal} fibers")
	public void theNutResponseWithFibers(BigDecimal value) { nutFibers = value; }

	@Et("la réponse nutritionnelle ayant {bigdecimal} protein")
	public void theNutResponseWithProtein(BigDecimal value) { nutProtein = value; }

	@Et("la réponse nutritionnelle ayant {bigdecimal} sodium")
	public void theNutResponseWithSodium(BigDecimal value) { nutSodium = value; }

	@Quand("il est converti en NutScanResponseDTO")
	public void itIsConvertedToNutScanResponseDTO() {
		NutResponseDomain nutResponse = hasNutResponse
				? new NutResponseDomain(nutResponseId, nutResponseInstant, nutKcal, nutFat,
						nutSaturatedFattyAcids, nutCarbohydrates, nutSugar, nutFibers, nutProtein, nutSodium)
				: null;
		NutScanResultDomain domain = new NutScanResultDomain(status, messages, nutResponse);
		result = NutScanDTOMapper.toResponseDTO(domain);
	}

	@Alors("le NutScanResponseDTO a le statut {string}")
	public void theNutScanResponseDTOHasStatus(String statusStr) {
		assertThat(result.status(), is(NutScanStatus.valueOf(statusStr)));
	}

	@Et("le NutScanResponseDTO a {int} messages")
	public void theNutScanResponseDTOHasNMessages(int count) {
		assertThat(result.messages().size(), is(count));
	}

	@Et("le NutScanResponseDTO contient un nut avec l'id {long}")
	public void theNutScanResponseDTOContainsNutWithId(Long id) {
		assertThat(result.nut(), is(notNullValue()));
		assertThat(result.nut().id(), is(id));
	}

	@Et("le nut du NutScanResponseDTO contient {bigdecimal} kcal")
	public void theNutOfNutScanResponseDTOContainsKcal(BigDecimal value) {
		assertThat(result.nut().kcal(), comparesEqualTo(value));
	}

	@Et("le NutScanResponseDTO ne contient pas de nut")
	public void theNutScanResponseDTOContainsNoNut() {
		assertThat(result.nut(), is(nullValue()));
	}
}
