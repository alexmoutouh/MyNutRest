package com.alexm.MyNutRest.domain.model;

import org.springframework.ai.tool.annotation.ToolParam;

public record ProgramDomain(
		@ToolParam(description = "Nom du programme") String name,
		@ToolParam(description = "Description du programme") String description,
		@ToolParam(description = "Niveau de difficulté : BEGINNER, INTERMEDIATE ou ADVANCED") String difficulty,
		@ToolParam(description = "Durée du programme en semaines") Integer durationWeeks
) {
}
