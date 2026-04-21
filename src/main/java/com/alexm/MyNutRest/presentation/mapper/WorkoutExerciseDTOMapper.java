package com.alexm.MyNutRest.presentation.mapper;

import com.alexm.MyNutRest.domain.model.WorkoutExerciseDomain;
import com.alexm.MyNutRest.domain.model.WorkoutExerciseResponseDomain;
import com.alexm.MyNutRest.presentation.dto.request.WorkoutExerciseDTO;
import com.alexm.MyNutRest.presentation.dto.response.WorkoutExerciseResponseDTO;

public class WorkoutExerciseDTOMapper {

	private WorkoutExerciseDTOMapper() {
	}

	public static WorkoutExerciseDomain toDomain(WorkoutExerciseDTO dto) {
		return new WorkoutExerciseDomain(
				dto.orderInWorkout(),
				dto.sets(),
				dto.reps(),
				dto.restSeconds()
		);
	}

	public static WorkoutExerciseResponseDTO toResponseDTO(WorkoutExerciseResponseDomain domain) {
		return new WorkoutExerciseResponseDTO(
				domain.workoutId(),
				domain.exerciseId(),
				domain.orderInWorkout(),
				domain.sets(),
				domain.reps(),
				domain.restSeconds()
		);
	}
}
