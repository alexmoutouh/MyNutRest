package com.alexm.MyNutRest.cucumber.steps;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

import com.alexm.MyNutRest.domain.model.NutResponseDomain;
import com.alexm.MyNutRest.domain.model.NutUserDomain;
import com.alexm.MyNutRest.domain.model.NutUserResponseDomain;
import com.alexm.MyNutRest.presentation.dto.request.UserDTO;
import com.alexm.MyNutRest.presentation.dto.response.NutUserResponseDTO;
import com.alexm.MyNutRest.presentation.mapper.NutUserDTOMapper;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Et;
import io.cucumber.java.fr.Quand;
import io.cucumber.java.fr.Étantdonné;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class NutUserDTOMapperSteps {

	private String userDTOFirstname;
	private String userDTOLastname;
	private String userDTOGender;
	private String userDTOBirthdate;

	private Long nutUserResponseDomainId;
	private String nutUserResponseDomainFirstname;
	private String nutUserResponseDomainLastname;
	private String nutUserResponseDomainGender;
	private String nutUserResponseDomainBirthdate;

	private NutUserDomain nutUserDomain;
	private NutUserResponseDTO nutUserResponseDTO;
	private List<NutResponseDomain> nutsResponseDomain;

	@Étantdonné("un UserDTO avec le prénom {string}")
	public void aUserDTOWithFirstName(String firstname) {
		userDTOFirstname = firstname;
	}

	@Et("le UserDTO ayant aussi le nom {string}")
	public void theUserDTOAlsoWithLastName(String lastname) {
		userDTOLastname = lastname;
	}

	@Et("le UserDTO ayant aussi le genre {string}")
	public void theUserDTOAlsoWithGender(String gender) {
		userDTOGender = gender;
	}

	@Et("le UserDTO ayant aussi la date de naissance {string}")
	public void theUserDTOAlsoWithBirthdate(String birthdate) {
		userDTOBirthdate = birthdate;
	}

	@Quand("il est convertit en NutUserDomain")
	public void itIsConvertedToNutUserDomain() {
		UserDTO userDTO = new UserDTO(userDTOFirstname, userDTOLastname, userDTOGender, userDTOBirthdate);
		nutUserDomain = NutUserDTOMapper.toDomain(userDTO);
	}

	@Alors("le NutUserDomain résultant contient le prénom {string}")
	public void theResultingNutUserDomainContainsFirstName(String firstname) {
		assertThat(nutUserDomain.firstname(), is(firstname));
	}

	@Et("le NutUserDomain résultant contient le nom {string}")
	public void theResultingNutUserDomainContainsLastName(String lastname) {
		assertThat(nutUserDomain.lastname(), is(lastname));
	}

	@Et("le NutUserDomain résultant contient le genre {string}")
	public void theResultingNutUserDomainContainsGender(String gender) {
		assertThat(nutUserDomain.gender(), is(gender));
	}

	@Et("le NutUserDomain résultant contient la date de naissance {string}")
	public void theResultingNutUserDomainContainsBirthDate(String birthdate) {
		assertThat(nutUserDomain.birthdate(), is(birthdate));
	}

	@Étantdonné("un NutUserResponseDomain avec l'id {long}")
	public void aNutUserResponseDomainWithId(Long id) {
		nutUserResponseDomainId = id;
	}

	@Et("le NutUserResponseDomain ayant aussi le prénom {string}")
	public void andNutUserResponseDomainAlsoWithFirstName(String firstname) {
		nutUserResponseDomainFirstname = firstname;
	}

	@Et("le NutUserResponseDomain ayant aussi le nom {string}")
	public void andNutUserResponseDomainAlsoWithLastName(String lastname) {
		nutUserResponseDomainLastname = lastname;
	}

	@Et("le NutUserResponseDomain ayant aussi le genre {string}")
	public void andNutUserResponseDomainAlsoWithGender(String gender) {
		nutUserResponseDomainGender = gender;
	}

	@Et("le NutUserResponseDomain ayant aussi la date de naissance {string}")
	public void andNutUserResponseDomainAlsoWithBirthdate(String birthdate) {
		nutUserResponseDomainBirthdate = birthdate;
	}

	@Et("le NutUserResponseDomain ayant aussi une liste de nuts")
	public void andNutUserResponseDomainAlsoWithAListOfNutsResponseDomain() {
		NutResponseDomain nut = new NutResponseDomain(1L, Instant.parse("2024-01-15T12:00:00Z"),
				new BigDecimal("500"), new BigDecimal("20.0"), new BigDecimal("5.0"),
				new BigDecimal("60.0"), new BigDecimal("10.0"), new BigDecimal("8.0"),
				new BigDecimal("25.0"), new BigDecimal("1.5"));
		nutsResponseDomain = List.of(nut);
	}

	@Quand("il est convertit en NutUserResponseDTO")
	public void itIsConvertedToNutUserResponseDTO() {
		NutUserResponseDomain nutUserResponseDomain = new NutUserResponseDomain(nutUserResponseDomainId,
				nutUserResponseDomainFirstname, nutUserResponseDomainLastname, nutUserResponseDomainGender,
				Instant.parse(nutUserResponseDomainBirthdate), nutsResponseDomain);
		nutUserResponseDTO = NutUserDTOMapper.toResponseDTO(nutUserResponseDomain);
	}

	@Alors("le NutUserResponseDTO résultant contient l'id {long}")
	public void theResultingNutUserResponseDTOContainsId(Long id) {
		assertThat(nutUserResponseDTO.id(), is(id));
	}

	@Et("le NutUserResponseDTO résultant contient le prénom {string}")
	public void theResultingNutUserResponseDTOContainsFirstName(String firstname) {
		assertThat(nutUserResponseDTO.firstname(), is(firstname));
	}

	@Et("le NutUserResponseDTO résultant contient le nom {string}")
	public void theResultingNutUserResponseDTOContainsLastName(String lastname) {
		assertThat(nutUserResponseDTO.lastname(), is(lastname));
	}

	@Et("le NutUserResponseDTO résultant contient le genre {string}")
	public void theResultingNutUserResponseDTOContainsGender(String gender) {
		assertThat(nutUserResponseDTO.gender(), is(gender));
	}

	@Et("le NutUserResponseDTO résultant contient la date de naissance {string}")
	public void theResultingNutUserResponseDTOContainsBirthdate(String birthdate) {
		assertThat(nutUserResponseDTO.birthdate(), is(Instant.parse(birthdate)));
	}

	@Et("le NutUserResponseDTO résultant contient une liste de nuts")
	public void theResultingNutUserResponseDTOContainsAlistOfNutsResponseDomain() {
		assertThat(nutUserResponseDTO.nuts(), is(notNullValue()));
		assertThat(nutUserResponseDTO.nuts(), hasSize(1));
	}
}
