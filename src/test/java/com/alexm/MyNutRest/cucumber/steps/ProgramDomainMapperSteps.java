package com.alexm.MyNutRest.cucumber.steps;

import java.time.Instant;

import com.alexm.MyNutRest.domain.mapper.ProgramDomainMapper;
import com.alexm.MyNutRest.domain.model.ProgramDomain;
import com.alexm.MyNutRest.domain.model.ProgramResponseDomain;
import com.alexm.MyNutRest.infrastructure.entity.Difficulty;
import com.alexm.MyNutRest.infrastructure.entity.Program;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Et;
import io.cucumber.java.fr.Quand;
import io.cucumber.java.fr.Étantdonné;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class ProgramDomainMapperSteps {

	private String nameDomain;
	private String descriptionDomain;
	private String difficultyDomain;
	private Integer durationWeeksDomain;
	private Program programEntity;

	private Long idEntity;
	private String nameEntity;
	private String descriptionEntity;
	private String difficultyEntity;
	private Integer durationWeeksEntity;
	private String createdAtEntity;
	private ProgramResponseDomain programResponseDomain;

	@Étantdonné("un ProgramDomain avec le name {string}")
	public void aProgramDomainWithName(String name) {
		nameDomain = name;
	}

	@Et("la description programme {string}")
	public void theDescriptionProgram(String description) {
		descriptionDomain = description;
	}

	@Et("la difficulté {string}")
	public void theDifficulty(String difficulty) {
		difficultyDomain = difficulty;
	}

	@Et("la durée en semaines {int}")
	public void theDurationWeeks(Integer durationWeeks) {
		durationWeeksDomain = durationWeeks;
		durationWeeksEntity = durationWeeks;
	}

	@Quand("il est convertit en entité Program")
	public void itIsConvertedToProgramEntity() {
		ProgramDomain domain = new ProgramDomain(nameDomain, descriptionDomain, difficultyDomain, durationWeeksDomain);
		programEntity = ProgramDomainMapper.toEntity(domain);
	}

	@Alors("l'entité Program résultante contient le name {string}")
	public void theEntityContainsName(String name) {
		assertThat(programEntity.getName(), is(name));
	}

	@Et("l'entité Program résultante contient la description {string}")
	public void theEntityContainsDescription(String description) {
		assertThat(programEntity.getDescription(), is(description));
	}

	@Et("l'entité Program résultante contient la difficulté {string}")
	public void theEntityContainsDifficulty(String difficulty) {
		assertThat(programEntity.getDifficulty().name(), is(difficulty));
	}

	@Et("l'entité Program résultante contient la durée en semaines {int}")
	public void theEntityContainsDurationWeeks(Integer durationWeeks) {
		assertThat(programEntity.getDurationWeeks(), is(durationWeeks));
	}

	@Et("l'entité Program résultante contient un createdAt non null")
	public void theEntityContainsNonNullCreatedAt() {
		assertThat(programEntity.getCreatedAt(), is(notNullValue()));
	}

	@Étantdonné("une entité Program avec l'id {long}")
	public void aProgramEntityWithId(Long id) {
		idEntity = id;
	}

	@Et("le name programme {string}")
	public void theNameProgram(String name) {
		nameEntity = name;
	}

	@Et("la description programme entity {string}")
	public void theDescriptionProgramEntity(String description) {
		descriptionEntity = description;
	}

	@Et("la difficulté entity {string}")
	public void theDifficultyEntity(String difficulty) {
		difficultyEntity = difficulty;
	}

	@Et("la durée en semaines entity {int}")
	public void theDurationWeeksEntity(Integer durationWeeks) {
		durationWeeksEntity = durationWeeks;
	}

	@Et("le createdAt {string}")
	public void theCreatedAt(String createdAt) {
		createdAtEntity = createdAt;
	}

	@Quand("elle est convertit en ProgramResponseDomain")
	public void itIsConvertedToProgramResponseDomain() {
		Program program = new Program();
		program.setId(idEntity);
		program.setName(nameEntity);
		program.setDescription(descriptionEntity);
		program.setDifficulty(Difficulty.valueOf(difficultyEntity));
		program.setDurationWeeks(durationWeeksEntity);
		program.setCreatedAt(Instant.parse(createdAtEntity));
		programResponseDomain = ProgramDomainMapper.toResponseDomain(program);
	}

	@Alors("le ProgramResponseDomain résultant contient l'id {long}")
	public void theResponseDomainContainsId(Long id) {
		assertThat(programResponseDomain.id(), is(id));
	}

	@Et("le ProgramResponseDomain résultant contient le name {string}")
	public void theResponseDomainContainsName(String name) {
		assertThat(programResponseDomain.name(), is(name));
	}

	@Et("le ProgramResponseDomain résultant contient la description {string}")
	public void theResponseDomainContainsDescription(String description) {
		assertThat(programResponseDomain.description(), is(description));
	}

	@Et("le ProgramResponseDomain résultant contient la difficulté {string}")
	public void theResponseDomainContainsDifficulty(String difficulty) {
		assertThat(programResponseDomain.difficulty(), is(difficulty));
	}

	@Et("le ProgramResponseDomain résultant contient la durée en semaines {int}")
	public void theResponseDomainContainsDurationWeeks(Integer durationWeeks) {
		assertThat(programResponseDomain.durationWeeks(), is(durationWeeks));
	}

	@Et("le ProgramResponseDomain résultant contient le createdAt {string}")
	public void theResponseDomainContainsCreatedAt(String createdAt) {
		assertThat(programResponseDomain.createdAt(), is(Instant.parse(createdAt)));
	}
}
