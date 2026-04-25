package com.alexm.MyNutRest.infrastructure.repository;

import java.util.List;

import com.alexm.MyNutRest.domain.model.NutDomain;
import com.alexm.MyNutRest.domain.model.NutResponseDomain;
import com.alexm.MyNutRest.domain.model.NutUserDomain;
import com.alexm.MyNutRest.domain.model.NutUserResponseDomain;

public interface MyNutPort {

	NutUserResponseDomain save(NutUserDomain nutUserDomain);

	NutResponseDomain save(Long userId, NutDomain nutDomain);

	List<NutUserResponseDomain> saveAll(List<NutUserDomain> nutUsersDomain);

	NutUserResponseDomain findUserById(Long userId);

	List<NutUserResponseDomain> findByLastname(String lastName);
}
