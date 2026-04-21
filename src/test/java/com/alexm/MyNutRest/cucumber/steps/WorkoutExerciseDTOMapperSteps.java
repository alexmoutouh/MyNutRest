package com.alexm.MyNutRest.cucumber.steps;

import com.alexm.MyNutRest.domain.model.WorkoutExerciseDomain;
import com.alexm.MyNutRest.domain.model.WorkoutExerciseResponseDomain;
import com.alexm.MyNutRest.presentation.dto.request.WorkoutExerciseDTO;
import com.alexm.MyNutRest.presentation.dto.response.WorkoutExerciseResponseDTO;
import com.alexm.MyNutRest.presentation.mapper.WorkoutExerciseDTOMapper;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Et;
import io.cucumber.java.fr.Quand;
import io.cucumber.java.fr.Étantdonné;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class WorkoutExerciseDTOMapperSteps {

	private Integer dtoOrderInWorkout;
	private Integer dtoSets;
	private Integer dtoReps;
	private Integer dtoRestSeconds;

	private Long responseDomainWorkoutId;
	private Long responseDomainExerciseId;
	private Integer responseDomainOrderInWorkout;
	private Integer responseDomainSets;
	private Integer responseDomainReps;
	private Integer responseDomainRestSeconds;

	private WorkoutExerciseDomain workoutExerciseDomain;
	private WorkoutExerciseResponseDTO workoutExerciseResponseDTO;

	@Étantdonné("un WorkoutExerciseDTO avec le orderInWorkout {int}")
	public void aWorkoutExerciseDTOWithOrderInWorkout(Integer orderInWorkout) {
		dtoOrderInWorkout = orderInWorkout;
	}

	@Et("le WorkoutExerciseDTO ayant aussi le sets {int}")
	public void theWorkoutExerciseDTOAlsoWithSets(Integer sets) {
		dtoSets = sets;
	}

	@Et("le WorkoutExerciseDTO ayant aussi le reps {int}")
	public void theWorkoutExerciseDTOAlsoWithReps(Integer reps) {
		dtoReps = reps;
	}

	@Et("le WorkoutExerciseDTO ayant aussi le restSeconds {int}")
	public void theWorkoutExerciseDTOAlsoWithRestSeconds(Integer restSeconds) {
		dtoRestSeconds = restSeconds;
	}

	@Quand("il est convertit en WorkoutExerciseDomain")
	public void itIsConvertedToWorkoutExerciseDomain() {
		WorkoutExerciseDTO dto = new WorkoutExerciseDTO(dtoOrderInWorkout, dtoSets, dtoReps, dtoRestSeconds);
		workoutExerciseDomain = WorkoutExerciseDTOMapper.toDomain(dto);
	}

	@Alors("le WorkoutExerciseDomain résultant contient le orderInWorkout {int}")
	public void theResultContainsOrderInWorkout(Integer orderInWorkout) {
		assertThat(workoutExerciseDomain.orderInWorkout(), is(orderInWorkout));
	}

	@Et("le WorkoutExerciseDomain résultant contient le sets {int}")
	public void theResultContainsSets(Integer sets) {
		assertThat(workoutExerciseDomain.sets(), is(sets));
	}

	@Et("le WorkoutExerciseDomain résultant contient le reps {int}")
	public void theResultContainsReps(Integer reps) {
		assertThat(workoutExerciseDomain.reps(), is(reps));
	}

	@Et("le WorkoutExerciseDomain résultant contient le restSeconds {int}")
	public void theResultContainsRestSeconds(Integer restSeconds) {
		assertThat(workoutExerciseDomain.restSeconds(), is(restSeconds));
	}

	@Étantdonné("un WorkoutExerciseResponseDomain avec le workoutId {long} et le exerciseId {long}")
	public void aWorkoutExerciseResponseDomainWithIds(Long workoutId, Long exerciseId) {
		responseDomainWorkoutId = workoutId;
		responseDomainExerciseId = exerciseId;
	}

	@Et("le WorkoutExerciseResponseDomain ayant aussi le orderInWorkout {int}")
	public void theWorkoutExerciseResponseDomainAlsoWithOrderInWorkout(Integer orderInWorkout) {
		responseDomainOrderInWorkout = orderInWorkout;
	}

	@Et("le WorkoutExerciseResponseDomain ayant aussi le sets {int}")
	public void theWorkoutExerciseResponseDomainAlsoWithSets(Integer sets) {
		responseDomainSets = sets;
	}

	@Et("le WorkoutExerciseResponseDomain ayant aussi le reps {int}")
	public void theWorkoutExerciseResponseDomainAlsoWithReps(Integer reps) {
		responseDomainReps = reps;
	}

	@Et("le WorkoutExerciseResponseDomain ayant aussi le restSeconds {int}")
	public void theWorkoutExerciseResponseDomainAlsoWithRestSeconds(Integer restSeconds) {
		responseDomainRestSeconds = restSeconds;
	}

	@Quand("il est convertit en WorkoutExerciseResponseDTO")
	public void itIsConvertedToWorkoutExerciseResponseDTO() {
		WorkoutExerciseResponseDomain domain = new WorkoutExerciseResponseDomain(
				responseDomainWorkoutId, responseDomainExerciseId, responseDomainOrderInWorkout,
				responseDomainSets, responseDomainReps, responseDomainRestSeconds);
		workoutExerciseResponseDTO = WorkoutExerciseDTOMapper.toResponseDTO(domain);
	}

	@Alors("le WorkoutExerciseResponseDTO résultant contient le workoutId {long}")
	public void theResultingDTOContainsWorkoutId(Long workoutId) {
		assertThat(workoutExerciseResponseDTO.workoutId(), is(workoutId));
	}

	@Et("le WorkoutExerciseResponseDTO résultant contient le exerciseId {long}")
	public void theResultingDTOContainsExerciseId(Long exerciseId) {
		assertThat(workoutExerciseResponseDTO.exerciseId(), is(exerciseId));
	}

	@Et("le WorkoutExerciseResponseDTO résultant contient le orderInWorkout {int}")
	public void theResultingDTOContainsOrderInWorkout(Integer orderInWorkout) {
		assertThat(workoutExerciseResponseDTO.orderInWorkout(), is(orderInWorkout));
	}

	@Et("le WorkoutExerciseResponseDTO résultant contient le sets {int}")
	public void theResultingDTOContainsSets(Integer sets) {
		assertThat(workoutExerciseResponseDTO.sets(), is(sets));
	}

	@Et("le WorkoutExerciseResponseDTO résultant contient le reps {int}")
	public void theResultingDTOContainsReps(Integer reps) {
		assertThat(workoutExerciseResponseDTO.reps(), is(reps));
	}

	@Et("le WorkoutExerciseResponseDTO résultant contient le restSeconds {int}")
	public void theResultingDTOContainsRestSeconds(Integer restSeconds) {
		assertThat(workoutExerciseResponseDTO.restSeconds(), is(restSeconds));
	}
}
