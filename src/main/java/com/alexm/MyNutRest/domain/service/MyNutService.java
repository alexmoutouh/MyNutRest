package com.alexm.MyNutRest.domain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

import com.alexm.MyNutRest.domain.mapper.NutDomainMapper;
import com.alexm.MyNutRest.domain.mapper.NutUserDomainMapper;
import com.alexm.MyNutRest.domain.model.NutDomain;
import com.alexm.MyNutRest.domain.model.NutResponseDomain;
import com.alexm.MyNutRest.domain.model.NutUserDomain;
import com.alexm.MyNutRest.domain.model.NutUserResponseDomain;
import com.alexm.MyNutRest.infrastructure.entity.Nut;
import com.alexm.MyNutRest.infrastructure.entity.NutUser;
import com.alexm.MyNutRest.infrastructure.repository.NutRepository;
import com.alexm.MyNutRest.infrastructure.repository.UserRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MyNutService {

	private UserRepository userRepository;
	private NutRepository nutRepository;

	@Tool(description = "Enregistre un nouvel utilisateur dans l'application de suivi nutritionnel MyNut. "
			+ "Retourne l'utilisateur créé avec son id.")
	public NutUserResponseDomain registerNewUser(NutUserDomain nutUserDomain) {
		NutUser user = NutUserDomainMapper.toEntity(nutUserDomain);
		return NutUserDomainMapper.toResponseDomain(userRepository.save(user));
	}

	@Tool(description = "Enregistre de nouveaux utilisateurs dans l'application de suivi nutritionnel MyNut. "
			+ "Retourne les utilisateurs créés avec leurs ids.")
	public List<NutUserResponseDomain> registerNewUsers(List<NutUserDomain> nutUsersDomain) {
		List<NutUser> usersEntities = nutUsersDomain.stream()
				.map(NutUserDomainMapper::toEntity)
				.toList();
		Iterable<NutUser> nutUsers = userRepository.saveAll(usersEntities);
		List<NutUserResponseDomain> nutUserResponsesDomain = new ArrayList<>();
		for (NutUser nutUser : nutUsers) {
			nutUserResponsesDomain.add(NutUserDomainMapper.toResponseDomain(nutUser));
		}
		return nutUserResponsesDomain;
	}

	@Tool(description = "Recherche un utilisateur par son identifiant unique")
	public Optional<NutUserResponseDomain> findUserById(@ToolParam(description = "Identifiant unique de l'utilisateur") Long userId) {
		return userRepository.findById(userId).map(NutUserDomainMapper::toResponseDomain);
	}

	@Tool(description = "Recherche des utilisateurs par leur nom de famille")
	public List<NutUserResponseDomain> findUsersByLastName(
			@ToolParam(description = "Nom de famille du ou des utilisateurs recherchés") String lastName) {
		return userRepository.findByLastname(lastName).stream().map(NutUserDomainMapper::toResponseDomain).toList();
	}

	@Tool(description = "Ajoute une entrée nutritionnelle (repas) pour un utilisateur existant. Retourne l'entrée créée.")
	public NutResponseDomain addNutToUser(
			@ToolParam(description = "Identifiant unique de l'utilisateur pour lequel on veut ajouter l'entrée nutritionnelle") Long userId,
			NutDomain nutDomain) {
		NutUser nutUser = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
		Nut nut = NutDomainMapper.toEntity(nutDomain);
		nut.setNutUser(nutUser);
		return NutDomainMapper.toResponseDomain(nutRepository.save(nut));
	}
}
