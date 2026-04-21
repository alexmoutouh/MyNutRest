package com.alexm.MyNutRest.domain.model;

import org.springframework.ai.tool.annotation.ToolParam;

public record ExerciseDomain(
		@ToolParam(description = "Nom de l'exercice") String name,
		@ToolParam(description = "Description de l'exercice") String description,
		@ToolParam(description = "Groupe musculaire ciblé") String muscleGroup,
		@ToolParam(description = "Équipement nécessaire") String equipmentNeeded
) {
}
