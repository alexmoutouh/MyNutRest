package com.alexm.MyNutRest.domain.model;

import java.time.LocalDate;
import org.springframework.ai.tool.annotation.ToolParam;

public record UserProgramDomain(
		@ToolParam(description = "Date de début du programme (format YYYY-MM-DD)") LocalDate startDate,
		@ToolParam(description = "Date de fin du programme (format YYYY-MM-DD)") LocalDate endDate,
		@ToolParam(description = "Indique si le programme est actif") Boolean isActive
) {
}
