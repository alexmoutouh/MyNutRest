package com.alexm.MyNutRest.cucumber.steps;

import com.alexm.MyNutRest.domain.model.ExerciseDomain;
import com.alexm.MyNutRest.domain.model.ExerciseResponseDomain;
import com.alexm.MyNutRest.presentation.dto.request.ExerciseDTO;
import com.alexm.MyNutRest.presentation.dto.response.ExerciseResponseDTO;
import com.alexm.MyNutRest.presentation.mapper.ExerciseDTOMapper;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Et;
import io.cucumber.java.fr.Quand;
import io.cucumber.java.fr.Étantdonné;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ExerciseDTOMapperSteps {

	private String dtoName;
	private String dtoDescription;
	private String dtoMuscleGroup;
	private String dtoEquipmentNeeded;

	private Long responseDomainId;
	private String responseDomainName;
	private String responseDomainDescription;
	private String responseDomainMuscleGroup;
	private String responseDomainEquipmentNeeded;

	private ExerciseDomain exerciseDomain;
	private ExerciseResponseDTO exerciseResponseDTO;

	@Étantdonné("un ExerciseDTO avec le name {string}")
	public void anExerciseDTOWithName(String name) {
		dtoName = name;
	}

	@Et("le ExerciseDTO ayant aussi la description {string}")
	public void theExerciseDTOAlsoWithDescription(String description) {
		dtoDescription = description;
	}

	@Et("le ExerciseDTO ayant aussi le muscleGroup {string}")
	public void theExerciseDTOAlsoWithMuscleGroup(String muscleGroup) {
		dtoMuscleGroup = muscleGroup;
	}

	@Et("le ExerciseDTO ayant aussi le equipmentNeeded {string}")
	public void theExerciseDTOAlsoWithEquipmentNeeded(String equipmentNeeded) {
		dtoEquipmentNeeded = equipmentNeeded;
	}

	@Quand("il est convertit en ExerciseDomain")
	public void itIsConvertedToExerciseDomain() {
		ExerciseDTO dto = new ExerciseDTO(dtoName, dtoDescription, dtoMuscleGroup, dtoEquipmentNeeded);
		exerciseDomain = ExerciseDTOMapper.toDomain(dto);
	}

	@Alors("le ExerciseDomain résultant contient le name {string}")
	public void theResultContainsName(String name) {
		assertThat(exerciseDomain.name(), is(name));
	}

	@Et("le ExerciseDomain résultant contient la description {string}")
	public void theResultContainsDescription(String description) {
		assertThat(exerciseDomain.description(), is(description));
	}

	@Et("le ExerciseDomain résultant contient le muscleGroup {string}")
	public void theResultContainsMuscleGroup(String muscleGroup) {
		assertThat(exerciseDomain.muscleGroup(), is(muscleGroup));
	}

	@Et("le ExerciseDomain résultant contient le equipmentNeeded {string}")
	public void theResultContainsEquipmentNeeded(String equipmentNeeded) {
		assertThat(exerciseDomain.equipmentNeeded(), is(equipmentNeeded));
	}

	@Étantdonné("un ExerciseResponseDomain avec l'id {long}")
	public void anExerciseResponseDomainWithId(Long id) {
		responseDomainId = id;
	}

	@Et("le ExerciseResponseDomain ayant aussi le name {string}")
	public void theExerciseResponseDomainAlsoWithName(String name) {
		responseDomainName = name;
	}

	@Et("le ExerciseResponseDomain ayant aussi la description {string}")
	public void theExerciseResponseDomainAlsoWithDescription(String description) {
		responseDomainDescription = description;
	}

	@Et("le ExerciseResponseDomain ayant aussi le muscleGroup {string}")
	public void theExerciseResponseDomainAlsoWithMuscleGroup(String muscleGroup) {
		responseDomainMuscleGroup = muscleGroup;
	}

	@Et("le ExerciseResponseDomain ayant aussi le equipmentNeeded {string}")
	public void theExerciseResponseDomainAlsoWithEquipmentNeeded(String equipmentNeeded) {
		responseDomainEquipmentNeeded = equipmentNeeded;
	}

	@Quand("il est convertit en ExerciseResponseDTO")
	public void itIsConvertedToExerciseResponseDTO() {
		ExerciseResponseDomain domain = new ExerciseResponseDomain(
				responseDomainId, responseDomainName, responseDomainDescription,
				responseDomainMuscleGroup, responseDomainEquipmentNeeded);
		exerciseResponseDTO = ExerciseDTOMapper.toResponseDTO(domain);
	}

	@Alors("le ExerciseResponseDTO résultant contient l'id {long}")
	public void theResultingDTOContainsId(Long id) {
		assertThat(exerciseResponseDTO.id(), is(id));
	}

	@Et("le ExerciseResponseDTO résultant contient le name {string}")
	public void theResultingDTOContainsName(String name) {
		assertThat(exerciseResponseDTO.name(), is(name));
	}

	@Et("le ExerciseResponseDTO résultant contient la description {string}")
	public void theResultingDTOContainsDescription(String description) {
		assertThat(exerciseResponseDTO.description(), is(description));
	}

	@Et("le ExerciseResponseDTO résultant contient le muscleGroup {string}")
	public void theResultingDTOContainsMuscleGroup(String muscleGroup) {
		assertThat(exerciseResponseDTO.muscleGroup(), is(muscleGroup));
	}

	@Et("le ExerciseResponseDTO résultant contient le equipmentNeeded {string}")
	public void theResultingDTOContainsEquipmentNeeded(String equipmentNeeded) {
		assertThat(exerciseResponseDTO.equipmentNeeded(), is(equipmentNeeded));
	}
}
