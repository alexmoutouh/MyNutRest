package com.alexm.MyNutRest.cucumber.steps;

import com.alexm.MyNutRest.domain.mapper.WorkoutExerciseDomainMapper;
import com.alexm.MyNutRest.domain.model.WorkoutExerciseDomain;
import com.alexm.MyNutRest.domain.model.WorkoutExerciseResponseDomain;
import com.alexm.MyNutRest.infrastructure.entity.WorkoutExercise;
import com.alexm.MyNutRest.infrastructure.entity.WorkoutExerciseId;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Et;
import io.cucumber.java.fr.Quand;
import io.cucumber.java.fr.Étantdonné;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class WorkoutExerciseDomainMapperSteps {

	private Long workoutIdDomain;
	private Long exerciseIdDomain;
	private Integer orderInWorkoutDomain;
	private Integer setsDomain;
	private Integer repsDomain;
	private Integer restSecondsDomain;
	private WorkoutExercise workoutExerciseEntity;

	private Long workoutIdEntity;
	private Long exerciseIdEntity;
	private Integer orderInWorkoutEntity;
	private Integer setsEntity;
	private Integer repsEntity;
	private Integer restSecondsEntity;
	private WorkoutExerciseResponseDomain workoutExerciseResponseDomain;

	@Étantdonné("un WorkoutExerciseDomain avec le workoutId {long} et le exerciseId {long}")
	public void aWorkoutExerciseDomainWithIds(Long workoutId, Long exerciseId) {
		workoutIdDomain = workoutId;
		exerciseIdDomain = exerciseId;
	}

	@Et("le orderInWorkout {int}")
	public void theOrderInWorkout(Integer orderInWorkout) {
		orderInWorkoutDomain = orderInWorkout;
		orderInWorkoutEntity = orderInWorkout;
	}

	@Et("le sets {int}")
	public void theSets(Integer sets) {
		setsDomain = sets;
		setsEntity = sets;
	}

	@Et("le reps {int}")
	public void theReps(Integer reps) {
		repsDomain = reps;
		repsEntity = reps;
	}

	@Et("le restSeconds {int}")
	public void theRestSeconds(Integer restSeconds) {
		restSecondsDomain = restSeconds;
		restSecondsEntity = restSeconds;
	}

	@Quand("il est convertit en entité WorkoutExercise")
	public void itIsConvertedToWorkoutExerciseEntity() {
		WorkoutExerciseDomain domain = new WorkoutExerciseDomain(
				orderInWorkoutDomain, setsDomain, repsDomain, restSecondsDomain);
		workoutExerciseEntity = WorkoutExerciseDomainMapper.toEntity(workoutIdDomain, exerciseIdDomain, domain);
	}

	@Alors("l'entité WorkoutExercise résultante contient le workoutId {long}")
	public void theEntityContainsWorkoutId(Long workoutId) {
		assertThat(workoutExerciseEntity.getId().getWorkoutId(), is(workoutId));
	}

	@Et("l'entité WorkoutExercise résultante contient le exerciseId {long}")
	public void theEntityContainsExerciseId(Long exerciseId) {
		assertThat(workoutExerciseEntity.getId().getExerciseId(), is(exerciseId));
	}

	@Et("l'entité WorkoutExercise résultante contient le orderInWorkout {int}")
	public void theEntityContainsOrderInWorkout(Integer orderInWorkout) {
		assertThat(workoutExerciseEntity.getId().getOrderInWorkout(), is(orderInWorkout));
	}

	@Et("l'entité WorkoutExercise résultante contient le sets {int}")
	public void theEntityContainsSets(Integer sets) {
		assertThat(workoutExerciseEntity.getSets(), is(sets));
	}

	@Et("l'entité WorkoutExercise résultante contient le reps {int}")
	public void theEntityContainsReps(Integer reps) {
		assertThat(workoutExerciseEntity.getReps(), is(reps));
	}

	@Et("l'entité WorkoutExercise résultante contient le restSeconds {int}")
	public void theEntityContainsRestSeconds(Integer restSeconds) {
		assertThat(workoutExerciseEntity.getRestSeconds(), is(restSeconds));
	}

	@Étantdonné("une entité WorkoutExercise avec le workoutId {long} et le exerciseId {long}")
	public void aWorkoutExerciseEntityWithIds(Long workoutId, Long exerciseId) {
		workoutIdEntity = workoutId;
		exerciseIdEntity = exerciseId;
	}

	@Et("le orderInWorkout entity {int}")
	public void theOrderInWorkoutEntity(Integer orderInWorkout) {
		orderInWorkoutEntity = orderInWorkout;
	}

	@Et("le sets entity {int}")
	public void theSetsEntity(Integer sets) {
		setsEntity = sets;
	}

	@Et("le reps entity {int}")
	public void theRepsEntity(Integer reps) {
		repsEntity = reps;
	}

	@Et("le restSeconds entity {int}")
	public void theRestSecondsEntity(Integer restSeconds) {
		restSecondsEntity = restSeconds;
	}

	@Quand("elle est convertit en WorkoutExerciseResponseDomain")
	public void itIsConvertedToWorkoutExerciseResponseDomain() {
		WorkoutExercise workoutExercise = new WorkoutExercise();
		WorkoutExerciseId id = new WorkoutExerciseId(workoutIdEntity, exerciseIdEntity, orderInWorkoutEntity);
		workoutExercise.setId(id);
		workoutExercise.setSets(setsEntity);
		workoutExercise.setReps(repsEntity);
		workoutExercise.setRestSeconds(restSecondsEntity);
		workoutExerciseResponseDomain = WorkoutExerciseDomainMapper.toResponseDomain(workoutExercise);
	}

	@Alors("le WorkoutExerciseResponseDomain résultant contient le workoutId {long}")
	public void theResponseDomainContainsWorkoutId(Long workoutId) {
		assertThat(workoutExerciseResponseDomain.workoutId(), is(workoutId));
	}

	@Et("le WorkoutExerciseResponseDomain résultant contient le exerciseId {long}")
	public void theResponseDomainContainsExerciseId(Long exerciseId) {
		assertThat(workoutExerciseResponseDomain.exerciseId(), is(exerciseId));
	}

	@Et("le WorkoutExerciseResponseDomain résultant contient le orderInWorkout {int}")
	public void theResponseDomainContainsOrderInWorkout(Integer orderInWorkout) {
		assertThat(workoutExerciseResponseDomain.orderInWorkout(), is(orderInWorkout));
	}

	@Et("le WorkoutExerciseResponseDomain résultant contient le sets {int}")
	public void theResponseDomainContainsSets(Integer sets) {
		assertThat(workoutExerciseResponseDomain.sets(), is(sets));
	}

	@Et("le WorkoutExerciseResponseDomain résultant contient le reps {int}")
	public void theResponseDomainContainsReps(Integer reps) {
		assertThat(workoutExerciseResponseDomain.reps(), is(reps));
	}

	@Et("le WorkoutExerciseResponseDomain résultant contient le restSeconds {int}")
	public void theResponseDomainContainsRestSeconds(Integer restSeconds) {
		assertThat(workoutExerciseResponseDomain.restSeconds(), is(restSeconds));
	}
}
