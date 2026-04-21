package com.alexm.MyNutRest.cucumber.steps;

import com.alexm.MyNutRest.domain.model.WorkoutDomain;
import com.alexm.MyNutRest.domain.model.WorkoutResponseDomain;
import com.alexm.MyNutRest.presentation.dto.request.WorkoutDTO;
import com.alexm.MyNutRest.presentation.dto.response.WorkoutResponseDTO;
import com.alexm.MyNutRest.presentation.mapper.WorkoutDTOMapper;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Et;
import io.cucumber.java.fr.Quand;
import io.cucumber.java.fr.Étantdonné;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class WorkoutDTOMapperSteps {

	private String dtoName;
	private String dtoDescription;
	private Integer dtoDayOfWeek;

	private Long responseDomainId;
	private String responseDomainName;
	private String responseDomainDescription;
	private Integer responseDomainDayOfWeek;

	private WorkoutDomain workoutDomain;
	private WorkoutResponseDTO workoutResponseDTO;

	@Étantdonné("un WorkoutDTO avec le name {string}")
	public void aWorkoutDTOWithName(String name) {
		dtoName = name;
	}

	@Et("le WorkoutDTO ayant aussi la description {string}")
	public void theWorkoutDTOAlsoWithDescription(String description) {
		dtoDescription = description;
	}

	@Et("le WorkoutDTO ayant aussi le dayOfWeek {int}")
	public void theWorkoutDTOAlsoWithDayOfWeek(Integer dayOfWeek) {
		dtoDayOfWeek = dayOfWeek;
	}

	@Quand("il est convertit en WorkoutDomain")
	public void itIsConvertedToWorkoutDomain() {
		WorkoutDTO dto = new WorkoutDTO(dtoName, dtoDescription, dtoDayOfWeek);
		workoutDomain = WorkoutDTOMapper.toDomain(dto);
	}

	@Alors("le WorkoutDomain résultant contient le name {string}")
	public void theResultContainsName(String name) {
		assertThat(workoutDomain.name(), is(name));
	}

	@Et("le WorkoutDomain résultant contient la description {string}")
	public void theResultContainsDescription(String description) {
		assertThat(workoutDomain.description(), is(description));
	}

	@Et("le WorkoutDomain résultant contient le dayOfWeek {int}")
	public void theResultContainsDayOfWeek(Integer dayOfWeek) {
		assertThat(workoutDomain.dayOfWeek(), is(dayOfWeek));
	}

	@Étantdonné("un WorkoutResponseDomain avec l'id {long}")
	public void aWorkoutResponseDomainWithId(Long id) {
		responseDomainId = id;
	}

	@Et("le WorkoutResponseDomain ayant aussi le name {string}")
	public void theWorkoutResponseDomainAlsoWithName(String name) {
		responseDomainName = name;
	}

	@Et("le WorkoutResponseDomain ayant aussi la description {string}")
	public void theWorkoutResponseDomainAlsoWithDescription(String description) {
		responseDomainDescription = description;
	}

	@Et("le WorkoutResponseDomain ayant aussi le dayOfWeek {int}")
	public void theWorkoutResponseDomainAlsoWithDayOfWeek(Integer dayOfWeek) {
		responseDomainDayOfWeek = dayOfWeek;
	}

	@Quand("il est convertit en WorkoutResponseDTO")
	public void itIsConvertedToWorkoutResponseDTO() {
		WorkoutResponseDomain domain = new WorkoutResponseDomain(
				responseDomainId, responseDomainName, responseDomainDescription, responseDomainDayOfWeek);
		workoutResponseDTO = WorkoutDTOMapper.toResponseDTO(domain);
	}

	@Alors("le WorkoutResponseDTO résultant contient l'id {long}")
	public void theResultingDTOContainsId(Long id) {
		assertThat(workoutResponseDTO.id(), is(id));
	}

	@Et("le WorkoutResponseDTO résultant contient le name {string}")
	public void theResultingDTOContainsName(String name) {
		assertThat(workoutResponseDTO.name(), is(name));
	}

	@Et("le WorkoutResponseDTO résultant contient la description {string}")
	public void theResultingDTOContainsDescription(String description) {
		assertThat(workoutResponseDTO.description(), is(description));
	}

	@Et("le WorkoutResponseDTO résultant contient le dayOfWeek {int}")
	public void theResultingDTOContainsDayOfWeek(Integer dayOfWeek) {
		assertThat(workoutResponseDTO.dayOfWeek(), is(dayOfWeek));
	}
}
