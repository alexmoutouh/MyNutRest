package com.alexm.MyNutRest.cucumber.steps;

import java.math.BigDecimal;
import java.util.List;

import com.alexm.MyNutRest.domain.model.NutScanExtractionDomain;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Et;
import io.cucumber.java.fr.Quand;
import io.cucumber.java.fr.Étantdonné;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;

public class NutScanExtractionSteps {

	private NutScanExtractionDomain extraction;
	private List<String> nullFieldNames;

	@Étantdonné("une extraction avec tous les champs remplis")
	public void anExtractionWithAllFieldsFilled() {
		extraction = new NutScanExtractionDomain(
				new BigDecimal("500"), new BigDecimal("20"), new BigDecimal("5"),
				new BigDecimal("60"), new BigDecimal("10"), new BigDecimal("8"),
				new BigDecimal("25"), new BigDecimal("1.5"));
	}

	@Étantdonné("une extraction avec fibers et sodium null")
	public void anExtractionWithFibersAndSodiumNull() {
		extraction = new NutScanExtractionDomain(
				new BigDecimal("500"), new BigDecimal("20"), new BigDecimal("5"),
				new BigDecimal("60"), new BigDecimal("10"), null,
				new BigDecimal("25"), null);
	}

	@Étantdonné("une extraction avec tous les champs null")
	public void anExtractionWithAllFieldsNull() {
		extraction = new NutScanExtractionDomain(null, null, null, null, null, null, null, null);
	}

	@Quand("on récupère les noms des champs null")
	public void weGetTheNullFieldNames() {
		nullFieldNames = extraction.getNullFieldNames();
	}

	@Alors("la liste des champs null est vide")
	public void theNullFieldListIsEmpty() {
		assertThat(nullFieldNames.isEmpty(), is(true));
	}

	@Alors("la liste des champs null contient {string}")
	public void theNullFieldListContains(String fieldName) {
		assertThat(nullFieldNames, hasItem(fieldName));
	}

	@Alors("la liste des champs null a {int} éléments")
	public void theNullFieldListHasNElements(int count) {
		assertThat(nullFieldNames.size(), is(count));
	}
}
