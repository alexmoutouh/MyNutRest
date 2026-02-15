package com.alexm.MyNutRest.infrastructure.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class WorkoutExerciseId implements Serializable {

	@Column(name = "workout_id")
	private Long workoutId;

	@Column(name = "exercise_id")
	private Long exerciseId;

	@Column(name = "order_in_workout")
	private Integer orderInWorkout;
}
