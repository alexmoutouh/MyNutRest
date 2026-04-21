package com.alexm.MyNutRest.infrastructure.repository;

import org.springframework.data.repository.CrudRepository;

import com.alexm.MyNutRest.infrastructure.entity.Program;

public interface ProgramCrudRepository extends CrudRepository<Program, Long> {
}
