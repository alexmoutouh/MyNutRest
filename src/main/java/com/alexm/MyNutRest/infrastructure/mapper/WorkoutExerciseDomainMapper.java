package com.alexm.MyNutRest.infrastructure.mapper;

import com.alexm.MyNutRest.domain.model.WorkoutExerciseDomain;
import com.alexm.MyNutRest.domain.model.WorkoutExerciseResponseDomain;
import com.alexm.MyNutRest.infrastructure.entity.WorkoutExercise;
import com.alexm.MyNutRest.infrastructure.entity.WorkoutExerciseId;

public class WorkoutExerciseDomainMapper {

	private WorkoutExerciseDomainMapper() {
	}

	public static WorkoutExercise toEntity(Long workoutId, Long exerciseId, WorkoutExerciseDomain domain) {
		WorkoutExercise workoutExercise = new WorkoutExercise();
		WorkoutExerciseId id = new WorkoutExerciseId(workoutId, exerciseId, domain.orderInWorkout());
		workoutExercise.setId(id);
		workoutExercise.setSets(domain.sets());
		workoutExercise.setReps(domain.reps());
		workoutExercise.setRestSeconds(domain.restSeconds());
		return workoutExercise;
	}

	public static WorkoutExerciseResponseDomain toResponseDomain(WorkoutExercise workoutExercise) {
		return new WorkoutExerciseResponseDomain(
				workoutExercise.getId().getWorkoutId(),
				workoutExercise.getId().getExerciseId(),
				workoutExercise.getId().getOrderInWorkout(),
				workoutExercise.getSets(),
				workoutExercise.getReps(),
				workoutExercise.getRestSeconds()
		);
	}
}
