package com.alexm.MyNutRest.domain.service;

import java.util.List;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;

import com.alexm.MyNutRest.domain.model.NutDomain;
import com.alexm.MyNutRest.domain.model.NutResponseDomain;
import com.alexm.MyNutRest.domain.model.NutUserDomain;
import com.alexm.MyNutRest.domain.model.NutUserResponseDomain;

public interface MyNutService {

	@Tool(description = "Enregistre un nouvel utilisateur dans l'application de suivi nutritionnel MyNut. "
			+ "Retourne l'utilisateur créé avec son id.")
	NutUserResponseDomain registerNewUser(NutUserDomain nutUserDomain);

	@Tool(description = "Enregistre de nouveaux utilisateurs dans l'application de suivi nutritionnel MyNut. "
			+ "Retourne les utilisateurs créés avec leurs ids.")
	List<NutUserResponseDomain> registerNewUsers(List<NutUserDomain> nutUsersDomain);

	@Tool(description = "Recherche un utilisateur par son identifiant unique. "
			+ "Toutes les dates retournées sont des timestamp UNIX en secondes. Retourne les informations de date au format humain.")
	NutUserResponseDomain findUserById(@ToolParam(description = "Identifiant unique de l'utilisateur") Long userId);

	@Tool(description = "Recherche des utilisateurs par leur nom de famille")
	List<NutUserResponseDomain> findUsersByLastName(
			@ToolParam(description = "Nom de famille du ou des utilisateurs recherchés") String lastName);

	@Tool(description = "Ajoute une entrée nutritionnelle (repas) pour un utilisateur existant. Retourne l'entrée créée.")
	NutResponseDomain addNutToUser(
			@ToolParam(description = "Identifiant unique de l'utilisateur pour lequel on veut ajouter l'entrée nutritionnelle") Long userId,
			NutDomain nutDomain);
}
