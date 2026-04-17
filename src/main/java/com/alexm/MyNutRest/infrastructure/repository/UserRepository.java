package com.alexm.MyNutRest.infrastructure.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.alexm.MyNutRest.infrastructure.entity.NutUser;

public interface UserRepository extends CrudRepository<NutUser, Long> {
	List<NutUser> findByLastname(String lastname);
}
