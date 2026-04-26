package com.alexm.MyNutRest.cucumber.steps;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import com.alexm.MyNutRest.domain.model.NutResponseDomain;
import com.alexm.MyNutRest.domain.model.NutScanResultDomain;
import com.alexm.MyNutRest.domain.model.NutScanStatus;
import com.alexm.MyNutRest.domain.service.MyNutScanServiceImpl;
import io.cucumber.java.fr.Et;
import io.cucumber.java.fr.Quand;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class NutScanSteps {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private MyNutScanServiceImpl myNutScanServiceImpl;

	private final ScenarioContext context;

	private byte[] imageBytes;
	private BigDecimal grams;

	public NutScanSteps(ScenarioContext context) {
		this.context = context;
	}

	@Et("une image d'étiquette nutritionnelle lisible")
	public void aReadableNutritionalLabelImage() {
		imageBytes = new byte[]{1, 2, 3};
	}

	@Et("une image d'étiquette partiellement lisible")
	public void aPartiallyReadableImage() {
		imageBytes = new byte[]{4, 5, 6};
	}

	@Et("une image illisible")
	public void anUnreadableImage() {
		imageBytes = new byte[]{7, 8, 9};
	}

	@Et("un poids consommé de {int} grammes")
	public void aConsumedWeightOfXGrams(int g) {
		grams = new BigDecimal(g);
	}

	@Et("le service de scan retourne un résultat complet")
	public void theScanServiceReturnsCompleteResult() {
		NutResponseDomain nutResponse = new NutResponseDomain(1L, Instant.now(),
				new BigDecimal("750.00"), new BigDecimal("30.00"), new BigDecimal("7.50"),
				new BigDecimal("90.00"), new BigDecimal("15.00"), new BigDecimal("12.00"),
				new BigDecimal("37.50"), new BigDecimal("2.25"));
		NutScanResultDomain result = new NutScanResultDomain(NutScanStatus.COMPLETE, List.of(), nutResponse);
		when(myNutScanServiceImpl.scanAndSave(eq(1L), any(byte[].class), any(BigDecimal.class)))
				.thenReturn(result);
	}

	@Et("le service de scan retourne un résultat partiel")
	public void theScanServiceReturnsPartialResult() {
		NutResponseDomain nutResponse = new NutResponseDomain(2L, Instant.now(),
				new BigDecimal("1000.00"), new BigDecimal("40.00"), new BigDecimal("10.00"),
				new BigDecimal("120.00"), new BigDecimal("20.00"), null,
				new BigDecimal("50.00"), null);
		NutScanResultDomain result = new NutScanResultDomain(NutScanStatus.PARTIAL,
				List.of("Champs non reconnus : fibers, sodium"), nutResponse);
		when(myNutScanServiceImpl.scanAndSave(eq(1L), any(byte[].class), any(BigDecimal.class)))
				.thenReturn(result);
	}

	@Et("le service de scan retourne un échec")
	public void theScanServiceReturnsFailure() {
		NutScanResultDomain result = new NutScanResultDomain(NutScanStatus.FAILURE,
				List.of("Impossible d'extraire les informations nutritionnelles de cette image."), null);
		when(myNutScanServiceImpl.scanAndSave(eq(1L), any(byte[].class), any(BigDecimal.class)))
				.thenReturn(result);
	}

	@Quand("on effectue un POST multipart scan sur {string}")
	public void aMultipartPostScanOn(String uri) throws Exception {
		MockMultipartFile file = new MockMultipartFile("image", "label.jpg",
				MediaType.IMAGE_JPEG_VALUE, imageBytes);
		context.setLastResult(mockMvc.perform(multipart(uri)
				.file(file)
				.param("grams", grams.toString())
				.accept(MediaType.APPLICATION_JSON)));
	}

	@Et("le statut du scan est {string}")
	public void theScanStatusIs(String expectedStatus) throws Exception {
		context.getLastResult().andExpect(jsonPath("$.status", is(expectedStatus)));
	}

	@Et("la réponse du scan contient {int} messages")
	public void theScanResponseContainsNMessages(int count) throws Exception {
		context.getLastResult().andExpect(jsonPath("$.messages.length()", is(count)));
	}

	@Et("la réponse du scan contient un nut avec l'id {long}")
	public void theScanResponseContainsNutWithId(Long id) throws Exception {
		context.getLastResult().andExpect(jsonPath("$.nut.id", is(id.intValue())));
	}

	@Et("la réponse du scan ne contient pas de nut")
	public void theScanResponseContainsNoNut() throws Exception {
		context.getLastResult().andExpect(jsonPath("$.nut").value(nullValue()));
	}
}
