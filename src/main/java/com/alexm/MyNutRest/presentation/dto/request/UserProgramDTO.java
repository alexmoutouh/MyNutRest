package com.alexm.MyNutRest.presentation.dto.request;

import java.time.LocalDate;

public record UserProgramDTO(LocalDate startDate, LocalDate endDate, Boolean isActive) {
}
