package com.alexm.MyNutRest.infrastructure.repository;

import org.springframework.data.repository.CrudRepository;

import com.alexm.MyNutRest.infrastructure.entity.WorkoutExercise;
import com.alexm.MyNutRest.infrastructure.entity.WorkoutExerciseId;

public interface WorkoutExerciseCrudRepository extends CrudRepository<WorkoutExercise, WorkoutExerciseId> {
}
