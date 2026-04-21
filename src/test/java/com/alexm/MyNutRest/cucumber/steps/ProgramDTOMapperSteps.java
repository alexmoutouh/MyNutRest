package com.alexm.MyNutRest.cucumber.steps;

import java.time.Instant;

import com.alexm.MyNutRest.domain.model.ProgramDomain;
import com.alexm.MyNutRest.domain.model.ProgramResponseDomain;
import com.alexm.MyNutRest.presentation.dto.request.ProgramDTO;
import com.alexm.MyNutRest.presentation.dto.response.ProgramResponseDTO;
import com.alexm.MyNutRest.presentation.mapper.ProgramDTOMapper;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Et;
import io.cucumber.java.fr.Quand;
import io.cucumber.java.fr.Étantdonné;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ProgramDTOMapperSteps {

	private String dtoName;
	private String dtoDescription;
	private String dtoDifficulty;
	private Integer dtoDurationWeeks;

	private Long responseDomainId;
	private String responseDomainName;
	private String responseDomainDescription;
	private String responseDomainDifficulty;
	private Integer responseDomainDurationWeeks;
	private String responseDomainCreatedAt;

	private ProgramDomain programDomain;
	private ProgramResponseDTO programResponseDTO;

	@Étantdonné("un ProgramDTO avec le name {string}")
	public void aProgramDTOWithName(String name) {
		dtoName = name;
	}

	@Et("le ProgramDTO ayant aussi la description {string}")
	public void theProgramDTOAlsoWithDescription(String description) {
		dtoDescription = description;
	}

	@Et("le ProgramDTO ayant aussi la difficulté {string}")
	public void theProgramDTOAlsoWithDifficulty(String difficulty) {
		dtoDifficulty = difficulty;
	}

	@Et("le ProgramDTO ayant aussi la durée en semaines {int}")
	public void theProgramDTOAlsoWithDurationWeeks(Integer durationWeeks) {
		dtoDurationWeeks = durationWeeks;
	}

	@Quand("il est convertit en ProgramDomain")
	public void itIsConvertedToProgramDomain() {
		ProgramDTO dto = new ProgramDTO(dtoName, dtoDescription, dtoDifficulty, dtoDurationWeeks);
		programDomain = ProgramDTOMapper.toDomain(dto);
	}

	@Alors("le ProgramDomain résultant contient le name {string}")
	public void theResultContainsName(String name) {
		assertThat(programDomain.name(), is(name));
	}

	@Et("le ProgramDomain résultant contient la description {string}")
	public void theResultContainsDescription(String description) {
		assertThat(programDomain.description(), is(description));
	}

	@Et("le ProgramDomain résultant contient la difficulté {string}")
	public void theResultContainsDifficulty(String difficulty) {
		assertThat(programDomain.difficulty(), is(difficulty));
	}

	@Et("le ProgramDomain résultant contient la durée en semaines {int}")
	public void theResultContainsDurationWeeks(Integer durationWeeks) {
		assertThat(programDomain.durationWeeks(), is(durationWeeks));
	}

	@Étantdonné("un ProgramResponseDomain avec l'id {long}")
	public void aProgramResponseDomainWithId(Long id) {
		responseDomainId = id;
	}

	@Et("le ProgramResponseDomain ayant aussi le name {string}")
	public void theProgramResponseDomainAlsoWithName(String name) {
		responseDomainName = name;
	}

	@Et("le ProgramResponseDomain ayant aussi la description {string}")
	public void theProgramResponseDomainAlsoWithDescription(String description) {
		responseDomainDescription = description;
	}

	@Et("le ProgramResponseDomain ayant aussi la difficulté {string}")
	public void theProgramResponseDomainAlsoWithDifficulty(String difficulty) {
		responseDomainDifficulty = difficulty;
	}

	@Et("le ProgramResponseDomain ayant aussi la durée en semaines {int}")
	public void theProgramResponseDomainAlsoWithDurationWeeks(Integer durationWeeks) {
		responseDomainDurationWeeks = durationWeeks;
	}

	@Et("le ProgramResponseDomain ayant aussi le createdAt {string}")
	public void theProgramResponseDomainAlsoWithCreatedAt(String createdAt) {
		responseDomainCreatedAt = createdAt;
	}

	@Quand("il est convertit en ProgramResponseDTO")
	public void itIsConvertedToProgramResponseDTO() {
		ProgramResponseDomain domain = new ProgramResponseDomain(
				responseDomainId, responseDomainName, responseDomainDescription,
				responseDomainDifficulty, responseDomainDurationWeeks,
				Instant.parse(responseDomainCreatedAt));
		programResponseDTO = ProgramDTOMapper.toResponseDTO(domain);
	}

	@Alors("le ProgramResponseDTO résultant contient l'id {long}")
	public void theResultingDTOContainsId(Long id) {
		assertThat(programResponseDTO.id(), is(id));
	}

	@Et("le ProgramResponseDTO résultant contient le name {string}")
	public void theResultingDTOContainsName(String name) {
		assertThat(programResponseDTO.name(), is(name));
	}

	@Et("le ProgramResponseDTO résultant contient la description {string}")
	public void theResultingDTOContainsDescription(String description) {
		assertThat(programResponseDTO.description(), is(description));
	}

	@Et("le ProgramResponseDTO résultant contient la difficulté {string}")
	public void theResultingDTOContainsDifficulty(String difficulty) {
		assertThat(programResponseDTO.difficulty(), is(difficulty));
	}

	@Et("le ProgramResponseDTO résultant contient la durée en semaines {int}")
	public void theResultingDTOContainsDurationWeeks(Integer durationWeeks) {
		assertThat(programResponseDTO.durationWeeks(), is(durationWeeks));
	}

	@Et("le ProgramResponseDTO résultant contient le createdAt {string}")
	public void theResultingDTOContainsCreatedAt(String createdAt) {
		assertThat(programResponseDTO.createdAt(), is(Instant.parse(createdAt)));
	}
}
