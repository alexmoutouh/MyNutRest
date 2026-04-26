package com.alexm.MyNutRest.infrastructure.adapter;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeTypeUtils;

import com.alexm.MyNutRest.domain.model.NutScanExtractionDomain;
import com.alexm.MyNutRest.domain.port.NutScanPort;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class NutScanAdapter implements NutScanPort {

	private final ChatClient.Builder chatClientBuilder;

	@Override
	public NutScanExtractionDomain extractNutritionFromImage(byte[] imageBytes) {
		return chatClientBuilder.build()
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
				.entity(NutScanExtractionDomain.class);
	}
}
