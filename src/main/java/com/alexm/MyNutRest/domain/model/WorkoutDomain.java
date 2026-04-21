package com.alexm.MyNutRest.domain.model;

import org.springframework.ai.tool.annotation.ToolParam;

public record WorkoutDomain(
		@ToolParam(description = "Nom du workout") String name,
		@ToolParam(description = "Description du workout") String description,
		@ToolParam(description = "Jour de la semaine (1=lundi, 7=dimanche)") Integer dayOfWeek
) {
}
