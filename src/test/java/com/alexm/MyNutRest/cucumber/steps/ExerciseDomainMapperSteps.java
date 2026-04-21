package com.alexm.MyNutRest.cucumber.steps;

import com.alexm.MyNutRest.domain.mapper.ExerciseDomainMapper;
import com.alexm.MyNutRest.domain.model.ExerciseDomain;
import com.alexm.MyNutRest.domain.model.ExerciseResponseDomain;
import com.alexm.MyNutRest.infrastructure.entity.Exercise;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Et;
import io.cucumber.java.fr.Quand;
import io.cucumber.java.fr.Étantdonné;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ExerciseDomainMapperSteps {

	private String nameDomain;
	private String descriptionDomain;
	private String muscleGroupDomain;
	private String equipmentNeededDomain;
	private Exercise exerciseEntity;

	private Long idEntity;
	private String nameEntity;
	private String descriptionEntity;
	private String muscleGroupEntity;
	private String equipmentNeededEntity;
	private ExerciseResponseDomain exerciseResponseDomain;

	@Étantdonné("un ExerciseDomain avec le name {string}")
	public void anExerciseDomainWithName(String name) {
		nameDomain = name;
	}

	@Et("la description exercice {string}")
	public void theDescriptionExercise(String description) {
		descriptionDomain = description;
	}

	@Et("le muscleGroup {string}")
	public void theMuscleGroup(String muscleGroup) {
		muscleGroupDomain = muscleGroup;
	}

	@Et("le equipmentNeeded {string}")
	public void theEquipmentNeeded(String equipmentNeeded) {
		equipmentNeededDomain = equipmentNeeded;
	}

	@Quand("il est convertit en entité Exercise")
	public void itIsConvertedToExerciseEntity() {
		ExerciseDomain domain = new ExerciseDomain(nameDomain, descriptionDomain, muscleGroupDomain, equipmentNeededDomain);
		exerciseEntity = ExerciseDomainMapper.toEntity(domain);
	}

	@Alors("l'entité Exercise résultante contient le name {string}")
	public void theEntityContainsName(String name) {
		assertThat(exerciseEntity.getName(), is(name));
	}

	@Et("l'entité Exercise résultante contient la description {string}")
	public void theEntityContainsDescription(String description) {
		assertThat(exerciseEntity.getDescription(), is(description));
	}

	@Et("l'entité Exercise résultante contient le muscleGroup {string}")
	public void theEntityContainsMuscleGroup(String muscleGroup) {
		assertThat(exerciseEntity.getMuscleGroup(), is(muscleGroup));
	}

	@Et("l'entité Exercise résultante contient le equipmentNeeded {string}")
	public void theEntityContainsEquipmentNeeded(String equipmentNeeded) {
		assertThat(exerciseEntity.getEquipmentNeeded(), is(equipmentNeeded));
	}

	@Étantdonné("une entité Exercise avec l'id {long}")
	public void anExerciseEntityWithId(Long id) {
		idEntity = id;
	}

	@Et("le name exercice {string}")
	public void theNameExercise(String name) {
		nameEntity = name;
	}

	@Et("la description exercice entity {string}")
	public void theDescriptionExerciseEntity(String description) {
		descriptionEntity = description;
	}

	@Et("le muscleGroup entity {string}")
	public void theMuscleGroupEntity(String muscleGroup) {
		muscleGroupEntity = muscleGroup;
	}

	@Et("le equipmentNeeded entity {string}")
	public void theEquipmentNeededEntity(String equipmentNeeded) {
		equipmentNeededEntity = equipmentNeeded;
	}

	@Quand("elle est convertit en ExerciseResponseDomain")
	public void itIsConvertedToExerciseResponseDomain() {
		Exercise exercise = new Exercise();
		exercise.setId(idEntity);
		exercise.setName(nameEntity);
		exercise.setDescription(descriptionEntity);
		exercise.setMuscleGroup(muscleGroupEntity);
		exercise.setEquipmentNeeded(equipmentNeededEntity);
		exerciseResponseDomain = ExerciseDomainMapper.toResponseDomain(exercise);
	}

	@Alors("le ExerciseResponseDomain résultant contient l'id {long}")
	public void theResponseDomainContainsId(Long id) {
		assertThat(exerciseResponseDomain.id(), is(id));
	}

	@Et("le ExerciseResponseDomain résultant contient le name {string}")
	public void theResponseDomainContainsName(String name) {
		assertThat(exerciseResponseDomain.name(), is(name));
	}

	@Et("le ExerciseResponseDomain résultant contient la description {string}")
	public void theResponseDomainContainsDescription(String description) {
		assertThat(exerciseResponseDomain.description(), is(description));
	}

	@Et("le ExerciseResponseDomain résultant contient le muscleGroup {string}")
	public void theResponseDomainContainsMuscleGroup(String muscleGroup) {
		assertThat(exerciseResponseDomain.muscleGroup(), is(muscleGroup));
	}

	@Et("le ExerciseResponseDomain résultant contient le equipmentNeeded {string}")
	public void theResponseDomainContainsEquipmentNeeded(String equipmentNeeded) {
		assertThat(exerciseResponseDomain.equipmentNeeded(), is(equipmentNeeded));
	}
}
