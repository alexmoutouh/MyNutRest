package com.alexm.MyNutRest.infrastructure.repository;

import org.springframework.data.repository.CrudRepository;

import com.alexm.MyNutRest.infrastructure.entity.Nut;

public interface NutCrudRepository extends CrudRepository<Nut, Long> {
}
