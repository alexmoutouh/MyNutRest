package com.alexm.MyNutRest.infrastructure.repository;

import org.springframework.data.repository.CrudRepository;

import com.alexm.MyNutRest.infrastructure.entity.Workout;

public interface WorkoutCrudRepository extends CrudRepository<Workout, Long> {
}
