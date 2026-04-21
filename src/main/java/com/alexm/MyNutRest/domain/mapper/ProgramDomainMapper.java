package com.alexm.MyNutRest.domain.mapper;

import java.time.Instant;

import com.alexm.MyNutRest.domain.model.ProgramDomain;
import com.alexm.MyNutRest.domain.model.ProgramResponseDomain;
import com.alexm.MyNutRest.infrastructure.entity.Difficulty;
import com.alexm.MyNutRest.infrastructure.entity.Program;

public class ProgramDomainMapper {

	private ProgramDomainMapper() {
	}

	public static Program toEntity(ProgramDomain domain) {
		Program program = new Program();
		program.setName(domain.name());
		program.setDescription(domain.description());
		program.setDifficulty(Difficulty.valueOf(domain.difficulty()));
		program.setDurationWeeks(domain.durationWeeks());
		program.setCreatedAt(Instant.now());
		return program;
	}

	public static ProgramResponseDomain toResponseDomain(Program program) {
		return new ProgramResponseDomain(
				program.getId(),
				program.getName(),
				program.getDescription(),
				program.getDifficulty().name(),
				program.getDurationWeeks(),
				program.getCreatedAt()
		);
	}
}
