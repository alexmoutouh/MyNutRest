package com.alexm.MyNutRest.cucumber.steps;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

import com.alexm.MyNutRest.domain.model.NutUserDomain;
import com.alexm.MyNutRest.domain.model.NutUserResponseDomain;
import com.alexm.MyNutRest.infrastructure.entity.Nut;
import com.alexm.MyNutRest.infrastructure.entity.NutUser;
import com.alexm.MyNutRest.infrastructure.mapper.NutUserDomainMapper;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Et;
import io.cucumber.java.fr.Quand;
import io.cucumber.java.fr.Étantdonné;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class NutUserDomainMapperSteps {

	private String nutUserDomainFirstname;
	private String nutUserDomainLastname;
	private String nutUserDomainGender;
	private String nutUserDomainBirthdate;
	private NutUser nutUserEntity;

	private Long entityId;
	private String entityFirstname;
	private String entityLastname;
	private String entityGender;
	private String entityBirthdate;
	private List<Nut> entityNuts;
	private NutUserResponseDomain nutUserResponseDomain;

	@Étantdonné("un NutUserDomain avec le prénom {string}")
	public void aNutUserDomainWithFirstName(String firstname) {
		nutUserDomainFirstname = firstname;
	}

	@Et("le NutUserDomain ayant aussi le nom {string}")
	public void theNutUserDomainAlsoWithLastName(String lastname) {
		nutUserDomainLastname = lastname;
	}

	@Et("le NutUserDomain ayant aussi le genre {string}")
	public void theNutUserDomainAlsoWithGender(String gender) {
		nutUserDomainGender = gender;
	}

	@Et("le NutUserDomain ayant aussi la date de naissance {string}")
	public void theNutUserDomainAlsoWithBirthdate(String birthdate) {
		nutUserDomainBirthdate = birthdate;
	}

	@Quand("il est convertit en entité NutUser")
	public void itIsConvertedToNutUserEntity() {
		NutUserDomain nutUserDomain = new NutUserDomain(nutUserDomainFirstname, nutUserDomainLastname,
				nutUserDomainGender, nutUserDomainBirthdate);
		nutUserEntity = NutUserDomainMapper.toEntity(nutUserDomain);
	}

	@Alors("l'entité NutUser résultante contient le prénom {string}")
	public void theResultingNutUserEntityContainsFirstName(String firstname) {
		assertThat(nutUserEntity.getFirstname(), is(firstname));
	}

	@Et("l'entité NutUser résultante contient le nom {string}")
	public void theResultingNutUserEntityContainsLastName(String lastname) {
		assertThat(nutUserEntity.getLastname(), is(lastname));
	}

	@Et("l'entité NutUser résultante contient le genre {string}")
	public void theResultingNutUserEntityContainsGender(String gender) {
		assertThat(nutUserEntity.getGender(), is(gender));
	}

	@Et("l'entité NutUser résultante contient la date de naissance {string}")
	public void theResultingNutUserEntityContainsBirthdate(String birthdate) {
		assertThat(nutUserEntity.getBirthdate(), is(Instant.parse(birthdate)));
	}

	@Étantdonné("une entité NutUser avec l'id {long}")
	public void aNutUserEntityWithId(Long id) {
		entityId = id;
	}

	@Et("l'entité NutUser ayant aussi le prénom {string}")
	public void andNutUserEntityAlsoWithFirstName(String firstname) {
		entityFirstname = firstname;
	}

	@Et("l'entité NutUser ayant aussi le nom {string}")
	public void andNutUserEntityAlsoWithLastName(String lastname) {
		entityLastname = lastname;
	}

	@Et("l'entité NutUser ayant aussi le genre {string}")
	public void andNutUserEntityAlsoWithGender(String gender) {
		entityGender = gender;
	}

	@Et("l'entité NutUser ayant aussi la date de naissance {string}")
	public void andNutUserEntityAlsoWithBirthdate(String birthdate) {
		entityBirthdate = birthdate;
	}

	@Et("l'entité NutUser ayant aussi une liste de nuts")
	public void andNutUserEntityAlsoWithAListOfNutsEntities() {
		Nut nut = new Nut();
		nut.setId(1L);
		nut.setInstant(Instant.parse("2024-01-15T12:00:00Z"));
		nut.setKcal(new BigDecimal("500"));
		nut.setFat(new BigDecimal("20.0"));
		nut.setSaturatedFattyAcids(new BigDecimal("5.0"));
		nut.setCarbohydrates(new BigDecimal("60.0"));
		nut.setSugar(new BigDecimal("10.0"));
		nut.setFibers(new BigDecimal("8.0"));
		nut.setProtein(new BigDecimal("25.0"));
		nut.setSodium(new BigDecimal("1.5"));
		entityNuts = List.of(nut);
	}

	@Et("l'entité NutUser ayant aussi des nuts null")
	public void andNutUserEntityAlsoWithANullListOfNutsEntities() {
		entityNuts = null;
	}

	@Quand("elle est convertit en NutUserResponseDomain")
	public void itIsConvertedToNutUserResponseDomain() {
		NutUser nutUser = new NutUser();
		nutUser.setId(entityId);
		nutUser.setFirstname(entityFirstname);
		nutUser.setLastname(entityLastname);
		nutUser.setGender(entityGender);
		nutUser.setBirthdate(Instant.parse(entityBirthdate));
		nutUser.setNuts(entityNuts);
		nutUserResponseDomain = NutUserDomainMapper.toResponseDomain(nutUser);
	}

	@Alors("le NutUserResponseDomain résultant contient l'id {long}")
	public void theResultingNutUserResponseDomainContainsId(Long id) {
		assertThat(nutUserResponseDomain.id(), is(id));
	}

	@Et("le NutUserResponseDomain résultant contient le prénom {string}")
	public void theResultingNutUserResponseDomainContainsFirstName(String firstname) {
		assertThat(nutUserResponseDomain.firstname(), is(firstname));
	}

	@Et("le NutUserResponseDomain résultant contient une liste de nuts non vide")
	public void theResultingNutUserResponseDomainContainsANonEmptyListOfNutsResponseDomain() {
		assertThat(nutUserResponseDomain.nuts(), is(notNullValue()));
		assertThat(nutUserResponseDomain.nuts(), hasSize(1));
	}

	@Alors("le NutUserResponseDomain résultant contient une liste de nuts vide")
	public void theResultingNutUserResponseDomainContainsAnEmptyListOfNutsResponseDomain() {
		assertThat(nutUserResponseDomain.nuts(), is(notNullValue()));
		assertThat(nutUserResponseDomain.nuts(), is(empty()));
	}
}
