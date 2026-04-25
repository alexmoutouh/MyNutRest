package com.alexm.MyNutRest.cucumber.steps;

import com.alexm.MyNutRest.domain.model.WorkoutDomain;
import com.alexm.MyNutRest.domain.model.WorkoutResponseDomain;
import com.alexm.MyNutRest.infrastructure.entity.Workout;
import com.alexm.MyNutRest.infrastructure.mapper.WorkoutDomainMapper;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Et;
import io.cucumber.java.fr.Quand;
import io.cucumber.java.fr.Étantdonné;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class WorkoutDomainMapperSteps {

	private String nameDomain;
	private String descriptionDomain;
	private Integer dayOfWeekDomain;
	private Workout workoutEntity;

	private Long idEntity;
	private String nameEntity;
	private String descriptionEntity;
	private Integer dayOfWeekEntity;
	private WorkoutResponseDomain workoutResponseDomain;

	@Étantdonné("un WorkoutDomain avec le name {string}")
	public void aWorkoutDomainWithName(String name) {
		nameDomain = name;
	}

	@Et("la description workout {string}")
	public void theDescriptionWorkout(String description) {
		descriptionDomain = description;
	}

	@Et("le dayOfWeek {int}")
	public void theDayOfWeek(Integer dayOfWeek) {
		dayOfWeekDomain = dayOfWeek;
		dayOfWeekEntity = dayOfWeek;
	}

	@Quand("il est convertit en entité Workout")
	public void itIsConvertedToWorkoutEntity() {
		WorkoutDomain domain = new WorkoutDomain(nameDomain, descriptionDomain, dayOfWeekDomain);
		workoutEntity = WorkoutDomainMapper.toEntity(domain);
	}

	@Alors("l'entité Workout résultante contient le name {string}")
	public void theEntityContainsName(String name) {
		assertThat(workoutEntity.getName(), is(name));
	}

	@Et("l'entité Workout résultante contient la description {string}")
	public void theEntityContainsDescription(String description) {
		assertThat(workoutEntity.getDescription(), is(description));
	}

	@Et("l'entité Workout résultante contient le dayOfWeek {int}")
	public void theEntityContainsDayOfWeek(Integer dayOfWeek) {
		assertThat(workoutEntity.getDayOfWeek(), is(dayOfWeek));
	}

	@Étantdonné("une entité Workout avec l'id {long}")
	public void aWorkoutEntityWithId(Long id) {
		idEntity = id;
	}

	@Et("le name workout {string}")
	public void theNameWorkout(String name) {
		nameEntity = name;
	}

	@Et("la description workout entity {string}")
	public void theDescriptionWorkoutEntity(String description) {
		descriptionEntity = description;
	}

	@Et("le dayOfWeek entity {int}")
	public void theDayOfWeekEntity(Integer dayOfWeek) {
		dayOfWeekEntity = dayOfWeek;
	}

	@Quand("elle est convertit en WorkoutResponseDomain")
	public void itIsConvertedToWorkoutResponseDomain() {
		Workout workout = new Workout();
		workout.setId(idEntity);
		workout.setName(nameEntity);
		workout.setDescription(descriptionEntity);
		workout.setDayOfWeek(dayOfWeekEntity);
		workoutResponseDomain = WorkoutDomainMapper.toResponseDomain(workout);
	}

	@Alors("le WorkoutResponseDomain résultant contient l'id {long}")
	public void theResponseDomainContainsId(Long id) {
		assertThat(workoutResponseDomain.id(), is(id));
	}

	@Et("le WorkoutResponseDomain résultant contient le name {string}")
	public void theResponseDomainContainsName(String name) {
		assertThat(workoutResponseDomain.name(), is(name));
	}

	@Et("le WorkoutResponseDomain résultant contient la description {string}")
	public void theResponseDomainContainsDescription(String description) {
		assertThat(workoutResponseDomain.description(), is(description));
	}

	@Et("le WorkoutResponseDomain résultant contient le dayOfWeek {int}")
	public void theResponseDomainContainsDayOfWeek(Integer dayOfWeek) {
		assertThat(workoutResponseDomain.dayOfWeek(), is(dayOfWeek));
	}
}
