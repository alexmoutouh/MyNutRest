package com.alexm.MyNutRest.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "workout_exercise")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WorkoutExercise {

	@EmbeddedId
	private WorkoutExerciseId id;

	@ManyToOne
	@MapsId("workoutId")
	@JoinColumn(name = "workout_id")
	private Workout workout;

	@ManyToOne
	@MapsId("exerciseId")
	@JoinColumn(name = "exercise_id")
	private Exercise exercise;

	@Column(nullable = false)
	private Integer sets;

	@Column(nullable = false)
	private Integer reps;

	private Integer restSeconds;
}
