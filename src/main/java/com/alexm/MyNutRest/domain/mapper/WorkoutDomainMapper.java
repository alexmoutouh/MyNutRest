package com.alexm.MyNutRest.domain.mapper;

import com.alexm.MyNutRest.domain.model.WorkoutDomain;
import com.alexm.MyNutRest.domain.model.WorkoutResponseDomain;
import com.alexm.MyNutRest.infrastructure.entity.Workout;

public class WorkoutDomainMapper {

	private WorkoutDomainMapper() {
	}

	public static Workout toEntity(WorkoutDomain domain) {
		Workout workout = new Workout();
		workout.setName(domain.name());
		workout.setDescription(domain.description());
		workout.setDayOfWeek(domain.dayOfWeek());
		return workout;
	}

	public static WorkoutResponseDomain toResponseDomain(Workout workout) {
		return new WorkoutResponseDomain(
				workout.getId(),
				workout.getName(),
				workout.getDescription(),
				workout.getDayOfWeek()
		);
	}
}
