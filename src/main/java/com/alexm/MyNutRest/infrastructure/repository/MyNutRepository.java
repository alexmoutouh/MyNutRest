package com.alexm.MyNutRest.infrastructure.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

import com.alexm.MyNutRest.domain.model.NutDomain;
import com.alexm.MyNutRest.domain.model.NutResponseDomain;
import com.alexm.MyNutRest.domain.model.NutUserDomain;
import com.alexm.MyNutRest.domain.model.NutUserResponseDomain;
import com.alexm.MyNutRest.infrastructure.entity.Nut;
import com.alexm.MyNutRest.infrastructure.entity.NutUser;
import com.alexm.MyNutRest.infrastructure.mapper.NutDomainMapper;
import com.alexm.MyNutRest.infrastructure.mapper.NutUserDomainMapper;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class MyNutRepository implements MyNutPort {

	private UserCrudRepository userCrudRepository;
	private NutCrudRepository nutCrudRepository;

	@Override
	public NutUserResponseDomain save(NutUserDomain nutUserDomain) {
		NutUser user = NutUserDomainMapper.toEntity(nutUserDomain);
		return NutUserDomainMapper.toResponseDomain(userCrudRepository.save(user));
	}

	@Override
	public NutResponseDomain save(Long userId, NutDomain nutDomain) {
		NutUser nutUser = userCrudRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
		Nut nut = NutDomainMapper.toEntity(nutDomain);
		nut.setNutUser(nutUser);
		return NutDomainMapper.toResponseDomain(nutCrudRepository.save(nut));
	}

	@Override
	public List<NutUserResponseDomain> saveAll(List<NutUserDomain> nutUsersDomain) {
		List<NutUser> usersEntities = nutUsersDomain.stream()
				.map(NutUserDomainMapper::toEntity)
				.toList();
		Iterable<NutUser> nutUsers = userCrudRepository.saveAll(usersEntities);
		List<NutUserResponseDomain> nutUserResponsesDomain = new ArrayList<>();
		for (NutUser nutUser : nutUsers) {
			nutUserResponsesDomain.add(NutUserDomainMapper.toResponseDomain(nutUser));
		}
		return nutUserResponsesDomain;
	}

	@Override
	public NutUserResponseDomain findUserById(Long userId) {
		return userCrudRepository.findById(userId).map(NutUserDomainMapper::toResponseDomain).orElse(null);
	}

	@Override
	public List<NutUserResponseDomain> findByLastname(String lastName) {
		return userCrudRepository.findByLastname(lastName).stream().map(NutUserDomainMapper::toResponseDomain).toList();
	}
}
