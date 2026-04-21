package com.alexm.MyNutRest.infrastructure.repository;

import org.springframework.data.repository.CrudRepository;

import com.alexm.MyNutRest.infrastructure.entity.Exercise;

public interface ExerciseCrudRepository extends CrudRepository<Exercise, Long> {
}
