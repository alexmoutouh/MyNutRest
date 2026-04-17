package com.alexm.MyNutRest.cucumber.steps;

import java.math.BigDecimal;
import java.time.Instant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.alexm.MyNutRest.domain.model.NutDomain;
import com.alexm.MyNutRest.domain.model.NutResponseDomain;
import com.alexm.MyNutRest.domain.service.MyNutService;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Et;
import io.cucumber.java.fr.Quand;
import io.cucumber.java.fr.Étantdonné;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

public class NutSteps {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private MyNutService myNutService;

	private final ScenarioContext context;
	private Exception caughtException;

	private boolean nonExistingUser;
	private Long currentUserId;
	private int currentKcal;
	private BigDecimal currentFat;
	private BigDecimal currentSaturatedFattyAcids;
	private BigDecimal currentCarbohydrates;
	private BigDecimal currentSugar;
	private BigDecimal currentFibers;
	private BigDecimal currentProtein;
	private BigDecimal currentSodium;

	public NutSteps(ScenarioContext context) {
		this.context = context;
	}

	@Étantdonné("un utilisateur inexistant avec l'id {long}")
	public void aNonExistingUserWithId(Long id) {
		nonExistingUser = true;
		when(myNutService.addNutToUser(eq(id), any(NutDomain.class)))
				.thenThrow(new RuntimeException("User not found with id: " + id));
	}

	@Et("une entrée nutritionnelle pour l'utilisateur {long}")
	public void aNutritionalEntryForUser(Long userId) {
		this.currentUserId = userId;
		if (!nonExistingUser) {
			NutResponseDomain response = new NutResponseDomain(1L, Instant.now(),
					new BigDecimal("500"), new BigDecimal("20.0"), new BigDecimal("5.0"),
					new BigDecimal("60.0"), new BigDecimal("10.0"), new BigDecimal("8.0"),
					new BigDecimal("25.0"), new BigDecimal("1.5"));
			when(myNutService.addNutToUser(eq(userId), any(NutDomain.class))).thenReturn(response);
		}
	}

	@Et("avec {int} kcal")
	public void withKcal(int kcal) {
		this.currentKcal = kcal;
	}

	@Et("avec {bigdecimal} fat")
	public void withFat(BigDecimal fat) {
		this.currentFat = fat;
	}

	@Et("avec {bigdecimal} saturatedFattyAcids")
	public void withSaturatedFattyAcids(BigDecimal saturatedFattyAcids) {
		this.currentSaturatedFattyAcids = saturatedFattyAcids;
	}

	@Et("avec {bigdecimal} carbohydrates")
	public void withCarbohydrates(BigDecimal carbohydrates) {
		this.currentCarbohydrates = carbohydrates;
	}

	@Et("avec {bigdecimal} sugar")
	public void withSugar(BigDecimal sugar) {
		this.currentSugar = sugar;
	}

	@Et("avec {bigdecimal} fibers")
	public void withFibers(BigDecimal fibers) {
		this.currentFibers = fibers;
	}

	@Et("avec {bigdecimal} protein")
	public void withProtein(BigDecimal protein) {
		this.currentProtein = protein;
	}

	@Et("avec {bigdecimal} sodium")
	public void withSodium(BigDecimal sodium) {
		this.currentSodium = sodium;
	}

	@Quand("on effectue un POST sur {string}")
	public void callingWithPOST(String uri) {
		String json = String.format("""
						{"kcal":%d,"fat":%s,"saturatedFattyAcids":%s,"carbohydrates":%s,"sugar":%s,"fibers":%s,"protein":%s,"sodium":%s}
						""",
				currentKcal,
				currentFat, currentSaturatedFattyAcids,
				currentCarbohydrates, currentSugar, currentFibers,
				currentProtein,
				currentSodium);
		try {
			context.setLastResult(mockMvc.perform(post(uri, currentUserId)
					.contentType(MediaType.APPLICATION_JSON)
					.content(json)
					.accept(MediaType.APPLICATION_JSON)));
		} catch (Exception e) {
			caughtException = e;
		}
	}

	@Alors("la réponse nutritionnelle contient {int} kcal")
	public void theNutritionalResponseContainsKcal(int kcal) throws Exception {
		context.getLastResult().andExpect(jsonPath("$.kcal", is(kcal)));
	}

	@Et("la réponse nutritionnelle contient {word} fat")
	public void theNutritionalResponseContainsFat(String fat) throws Exception {
		context.getLastResult().andExpect(jsonPath("$.fat", is(Double.parseDouble(fat))));
	}

	@Et("la réponse nutritionnelle contient {word} saturatedFattyAcids")
	public void theNutritionalResponseContainsSaturatedFattyAcids(String value) throws Exception {
		context.getLastResult().andExpect(jsonPath("$.saturatedFattyAcids", is(Double.parseDouble(value))));
	}

	@Et("la réponse nutritionnelle contient {word} carbohydrates")
	public void theNutritionalResponseContainsCarbohydrates(String value) throws Exception {
		context.getLastResult().andExpect(jsonPath("$.carbohydrates", is(Double.parseDouble(value))));
	}

	@Et("la réponse nutritionnelle contient {word} sugar")
	public void theNutritionalResponseContainsSugar(String value) throws Exception {
		context.getLastResult().andExpect(jsonPath("$.sugar", is(Double.parseDouble(value))));
	}

	@Et("la réponse nutritionnelle contient {word} fibers")
	public void theNutritionalResponseContainsFibers(String value) throws Exception {
		context.getLastResult().andExpect(jsonPath("$.fibers", is(Double.parseDouble(value))));
	}

	@Et("la réponse nutritionnelle contient {word} protein")
	public void theNutritionalResponseContainsProtein(String value) throws Exception {
		context.getLastResult().andExpect(jsonPath("$.protein", is(Double.parseDouble(value))));
	}

	@Et("la réponse nutritionnelle contient {word} sodium")
	public void theNutritionalResponseContainsSodium(String value) throws Exception {
		context.getLastResult().andExpect(jsonPath("$.sodium", is(Double.parseDouble(value))));
	}

	@Alors("une erreur serveur est levée avec le message {string}")
	public void aServerErrorIsRaisedWithMessage(String message) {
		assertThat(caughtException, is(notNullValue()));
		assertThat(caughtException.getCause(), instanceOf(RuntimeException.class));
		assertThat(caughtException.getCause().getMessage(), containsString(message));
	}
}
