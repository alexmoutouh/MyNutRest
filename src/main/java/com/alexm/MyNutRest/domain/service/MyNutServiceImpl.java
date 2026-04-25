package com.alexm.MyNutRest.domain.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.alexm.MyNutRest.domain.model.NutDomain;
import com.alexm.MyNutRest.domain.model.NutResponseDomain;
import com.alexm.MyNutRest.domain.model.NutUserDomain;
import com.alexm.MyNutRest.domain.model.NutUserResponseDomain;
import com.alexm.MyNutRest.infrastructure.repository.MyNutPort;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MyNutServiceImpl implements MyNutService {

	private MyNutPort myNutPort;

	@Override
	public NutUserResponseDomain registerNewUser(NutUserDomain nutUserDomain) {
		return myNutPort.save(nutUserDomain);
	}

	@Override
	public List<NutUserResponseDomain> registerNewUsers(List<NutUserDomain> nutUsersDomain) {
		return myNutPort.saveAll(nutUsersDomain);
	}

	@Override
	public NutUserResponseDomain findUserById(Long userId) {
		return myNutPort.findUserById(userId);
	}

	@Override
	public List<NutUserResponseDomain> findUsersByLastName(String lastName) {
		return myNutPort.findByLastname(lastName);
	}

	@Override
	public NutResponseDomain addNutToUser(Long userId, NutDomain nutDomain) {
		return myNutPort.save(userId, nutDomain);
	}
}
