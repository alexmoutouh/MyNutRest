package com.alexm.MyNutRest.infrastructure.adapter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeTypeUtils;

import com.alexm.MyNutRest.domain.model.NutScanExtractionDomain;
import com.alexm.MyNutRest.domain.port.NutScanPort;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class NutScanAdapter implements NutScanPort {

	private static final Pattern THINK_PATTERN = Pattern.compile("\\[THINK].*?\\[/THINK]", Pattern.DOTALL);
	private static final Pattern JSON_BLOCK_PATTERN = Pattern.compile("```(?:json)?\\s*(\\{.*?})\\s*```", Pattern.DOTALL);
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	private final ChatClient.Builder chatClientBuilder;

	@Override
	public NutScanExtractionDomain extractNutritionFromImage(byte[] imageBytes) {
		String rawResponse = chatClientBuilder.build()
				.prompt()
				.user(u -> u.text("""
						Analyse cette étiquette nutritionnelle.
						Extrais les valeurs POUR 100g si disponibles.
						Si l'étiquette ne mentionne que des valeurs par portion, identifie le grammage \
						de la portion et recalcule les valeurs pour 100g.
						Retourne un JSON avec ces champs exactement :
						kcal, fat, saturatedFattyAcids, carbohydrates, sugar, fibers, protein, sodium.
						Valeurs numériques (BigDecimal). Si un champ est illisible ou absent, mets null.
						""")
						.media(MimeTypeUtils.IMAGE_JPEG, new ByteArrayResource(imageBytes)))
				.call()
				.content();

		String json = extractJson(rawResponse);

		try {
			return OBJECT_MAPPER.readValue(json, NutScanExtractionDomain.class);
		} catch (Exception e) {
			throw new RuntimeException("Failed to parse LLM response: " + json, e);
		}
	}

	private String extractJson(String rawResponse) {
		String cleaned = THINK_PATTERN.matcher(rawResponse).replaceAll("").trim();

		Matcher blockMatcher = JSON_BLOCK_PATTERN.matcher(cleaned);
		if (blockMatcher.find()) {
			return blockMatcher.group(1).trim();
		}

		int start = cleaned.indexOf('{');
		int end = cleaned.lastIndexOf('}');
		if (start >= 0 && end > start) {
			return cleaned.substring(start, end + 1);
		}

		return cleaned;
	}
}
