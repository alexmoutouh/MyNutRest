package com.alexm.MyNutRest.domain.mapper;

import com.alexm.MyNutRest.domain.model.ExerciseDomain;
import com.alexm.MyNutRest.domain.model.ExerciseResponseDomain;
import com.alexm.MyNutRest.infrastructure.entity.Exercise;

public class ExerciseDomainMapper {

	private ExerciseDomainMapper() {
	}

	public static Exercise toEntity(ExerciseDomain domain) {
		Exercise exercise = new Exercise();
		exercise.setName(domain.name());
		exercise.setDescription(domain.description());
		exercise.setMuscleGroup(domain.muscleGroup());
		exercise.setEquipmentNeeded(domain.equipmentNeeded());
		return exercise;
	}

	public static ExerciseResponseDomain toResponseDomain(Exercise exercise) {
		return new ExerciseResponseDomain(
				exercise.getId(),
				exercise.getName(),
				exercise.getDescription(),
				exercise.getMuscleGroup(),
				exercise.getEquipmentNeeded()
		);
	}
}
