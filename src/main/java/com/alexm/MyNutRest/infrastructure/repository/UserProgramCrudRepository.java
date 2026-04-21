package com.alexm.MyNutRest.infrastructure.repository;

import org.springframework.data.repository.CrudRepository;

import com.alexm.MyNutRest.infrastructure.entity.UserProgram;
import com.alexm.MyNutRest.infrastructure.entity.UserProgramId;

public interface UserProgramCrudRepository extends CrudRepository<UserProgram, UserProgramId> {
}
