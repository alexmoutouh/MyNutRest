package com.alexm.MyNutRest.cucumber.steps;

import java.math.BigDecimal;
import java.time.Instant;

import com.alexm.MyNutRest.domain.model.NutDomain;
import com.alexm.MyNutRest.domain.model.NutResponseDomain;
import com.alexm.MyNutRest.domain.model.NutScanExtractionDomain;
import com.alexm.MyNutRest.domain.model.NutScanResultDomain;
import com.alexm.MyNutRest.domain.model.NutScanStatus;
import com.alexm.MyNutRest.domain.port.MyNutPort;
import com.alexm.MyNutRest.domain.port.NutScanPort;
import com.alexm.MyNutRest.domain.service.MyNutScanServiceImpl;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Et;
import io.cucumber.java.fr.Quand;
import io.cucumber.java.fr.Étantdonné;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class NutScanServiceSteps {

	private NutScanPort nutScanPort;
	private MyNutPort myNutPort;
	private MyNutScanServiceImpl service;
	private NutScanResultDomain result;
	private NutDomain capturedNutDomain;

	private void initMocks() {
		if (nutScanPort == null) nutScanPort = mock(NutScanPort.class);
		if (myNutPort == null) myNutPort = mock(MyNutPort.class);
	}

	private void setupSaveCapture() {
		when(myNutPort.save(any(Long.class), any(NutDomain.class))).thenAnswer(invocation -> {
			capturedNutDomain = invocation.getArgument(1);
			return new NutResponseDomain(1L, Instant.now(),
					capturedNutDomain.kcal(), capturedNutDomain.fat(),
					capturedNutDomain.saturatedFattyAcids(), capturedNutDomain.carbohydrates(),
					capturedNutDomain.sugar(), capturedNutDomain.fibers(),
					capturedNutDomain.protein(), capturedNutDomain.sodium());
		});
	}

	@Étantdonné("un port de scan qui retourne une extraction complète avec {bigdecimal} kcal et {bigdecimal} fat pour 100g")
	public void aScanPortReturningCompleteExtraction(BigDecimal kcal, BigDecimal fat) {
		initMocks();
		NutScanExtractionDomain extraction = new NutScanExtractionDomain(
				kcal, fat, new BigDecimal("5"), new BigDecimal("60"),
				new BigDecimal("10"), new BigDecimal("8"), new BigDecimal("25"), new BigDecimal("1.5"));
		when(nutScanPort.extractNutritionFromImage(any(byte[].class))).thenReturn(extraction);
	}

	@Étantdonné("un port de scan qui retourne une extraction avec fibers et sodium null")
	public void aScanPortReturningPartialExtraction() {
		initMocks();
		NutScanExtractionDomain extraction = new NutScanExtractionDomain(
				new BigDecimal("500"), new BigDecimal("20"), new BigDecimal("5"),
				new BigDecimal("60"), new BigDecimal("10"), null,
				new BigDecimal("25"), null);
		when(nutScanPort.extractNutritionFromImage(any(byte[].class))).thenReturn(extraction);
	}

	@Étantdonné("un port de scan qui retourne une extraction entièrement vide")
	public void aScanPortReturningEmptyExtraction() {
		initMocks();
		NutScanExtractionDomain extraction = new NutScanExtractionDomain(
				null, null, null, null, null, null, null, null);
		when(nutScanPort.extractNutritionFromImage(any(byte[].class))).thenReturn(extraction);
	}

	@Étantdonné("un port de scan qui retourne {bigdecimal} kcal pour 100g")
	public void aScanPortReturningKcal(BigDecimal kcal) {
		initMocks();
		NutScanExtractionDomain extraction = new NutScanExtractionDomain(
				kcal, new BigDecimal("0"), new BigDecimal("0"), new BigDecimal("0"),
				new BigDecimal("0"), new BigDecimal("0"), new BigDecimal("0"), new BigDecimal("0"));
		when(nutScanPort.extractNutritionFromImage(any(byte[].class))).thenReturn(extraction);
	}

	@Et("un port de persistance prêt à sauvegarder")
	public void aPersistencePortReadyToSave() {
		initMocks();
		setupSaveCapture();
	}

	@Quand("le service de scan est appelé pour l'utilisateur {long} avec {int} grammes")
	public void theScanServiceIsCalledForUserWithGrams(Long userId, int grams) {
		service = new MyNutScanServiceImpl(nutScanPort, myNutPort);
		result = service.scanAndSave(userId, new byte[]{1, 2, 3}, new BigDecimal(grams));
	}

	@Alors("le résultat a le statut {string}")
	public void theResultHasStatus(String statusStr) {
		assertThat(result.status(), is(NutScanStatus.valueOf(statusStr)));
	}

	@Et("le résultat a {int} messages")
	public void theResultHasNMessages(int count) {
		assertThat(result.messages().size(), is(count));
	}

	@Et("le résultat contient le message {string}")
	public void theResultContainsMessage(String message) {
		assertThat(result.messages().contains(message), is(true));
	}

	@Et("la persistance a été appelée avec {bigdecimal} kcal et {bigdecimal} fat")
	public void thePersistenceWasCalledWithKcalAndFat(BigDecimal kcal, BigDecimal fat) {
		assertThat(capturedNutDomain.kcal(), comparesEqualTo(kcal));
		assertThat(capturedNutDomain.fat(), comparesEqualTo(fat));
	}

	@Et("la persistance a été appelée avec des valeurs null pour fibers et sodium")
	public void thePersistenceWasCalledWithNullFibersAndSodium() {
		assertThat(capturedNutDomain.fibers(), is(nullValue()));
		assertThat(capturedNutDomain.sodium(), is(nullValue()));
	}

	@Alors("la persistance n'a pas été appelée")
	public void thePersistenceWasNotCalled() {
		verify(myNutPort, never()).save(any(Long.class), any(NutDomain.class));
	}

	@Alors("la persistance a été appelée avec {bigdecimal} kcal")
	public void thePersistenceWasCalledWithKcal(BigDecimal kcal) {
		assertThat(capturedNutDomain.kcal(), comparesEqualTo(kcal));
	}
}
