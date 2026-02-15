package com.alexm.MyNutRest.domain.model;

import org.springframework.ai.tool.annotation.ToolParam;

public record NutUserDomain(
		@ToolParam(description = "Prénom de l'utilisateur") String firstname,
		@ToolParam(description = "Nom de famille") String lastname,
		@ToolParam(description = "Genre : 'M' ou 'F'") String gender,
		@ToolParam(description = "Date de naissance ISO-8601, ex: '1990-05-15T00:00:00Z'") String birthdate
) {
}
