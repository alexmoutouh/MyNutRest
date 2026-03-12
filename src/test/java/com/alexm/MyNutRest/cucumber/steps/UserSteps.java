package com.alexm.MyNutRest.cucumber.steps;

import java.time.Instant;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.alexm.MyNutRest.domain.model.NutUserDomain;
import com.alexm.MyNutRest.domain.model.NutUserResponseDomain;
import com.alexm.MyNutRest.domain.service.MyNutServiceImpl;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Et;
import io.cucumber.java.fr.Quand;
import io.cucumber.java.fr.Étantdonné;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

public class UserSteps {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private MyNutServiceImpl myNutServiceImpl;

	private final ScenarioContext context;

	private String currentFirstname;
	private String currentLastname;
	private String currentGender;
	private String currentBirthdate;

	public UserSteps(ScenarioContext context) {
		this.context = context;
	}

	@Et("le prénom {string}")
	public void theFirstName(String firstname) {
		this.currentFirstname = firstname;
	}

	@Et("le nom {string}")
	public void theLastName(String lastname) {
		this.currentLastname = lastname;
	}

	@Et("le genre {string}")
	public void theGender(String gender) {
		this.currentGender = gender;
	}

	@Et("la date de naissance {string}")
	public void theBirthDate(String birthdate) {
		this.currentBirthdate = birthdate;
		Long userId = context.getCurrentUserId();
		if (userId != null && currentFirstname != null) {
			NutUserResponseDomain response = new NutUserResponseDomain(userId, currentFirstname, currentLastname, currentGender,
					Instant.parse(currentBirthdate), Collections.emptyList());
			when(myNutServiceImpl.findUserById(userId)).thenReturn(response);
		}
	}

	@Étantdonné("aucun utilisateur avec l'id {long}")
	public void noUserWithId(Long id) {
		when(myNutServiceImpl.findUserById(id)).thenReturn(null);
	}

	@Étantdonné("des utilisateurs avec le nom de famille {string}")
	public void usersWithLastName(String lastname) {
		NutUserResponseDomain user1 = new NutUserResponseDomain(1L, "Alice", lastname, "F", Instant.parse("1990-05-15T00:00:00Z"),
				Collections.emptyList());
		NutUserResponseDomain user2 = new NutUserResponseDomain(2L, "Bob", lastname, "M", Instant.parse("1985-03-20T00:00:00Z"),
				Collections.emptyList());
		when(myNutServiceImpl.findUsersByLastName(lastname)).thenReturn(List.of(user1, user2));
	}

	@Étantdonné("aucun utilisateur avec le nom de famille {string}")
	public void noUserWithLastName(String lastname) {
		when(myNutServiceImpl.findUsersByLastName(lastname)).thenReturn(Collections.emptyList());
	}

	@Étantdonné("un nouvel utilisateur avec le prénom {string}")
	public void aNewUser(String firstname) {
		this.currentFirstname = firstname;
	}

	@Étantdonné("une liste de {int} nouveaux utilisateurs")
	public void aListOfNewUsers(int count) {
		List<NutUserResponseDomain> responses = List.of(
				new NutUserResponseDomain(1L, "Alice", "Dupont", "F", Instant.parse("1990-05-15T00:00:00Z"), Collections.emptyList()),
				new NutUserResponseDomain(2L, "Bob", "Martin", "M", Instant.parse("1985-03-20T00:00:00Z"), Collections.emptyList()));
		when(myNutServiceImpl.registerNewUsers(any())).thenReturn(responses);
	}

	@Quand("je recherche l'utilisateur avec l'id {long}")
	public void iSearchForUserWithId(Long id) throws Exception {
		context.setLastResult(mockMvc.perform(get("/my-nut/api/v1/user/id/{user-id}", id)
				.accept(MediaType.APPLICATION_JSON)));
	}

	@Quand("je recherche les utilisateurs avec le nom {string}")
	public void iSearchForUsersWithLastName(String lastname) throws Exception {
		context.setLastResult(mockMvc.perform(get("/my-nut/api/v1/user/lastname/{user-lastname}", lastname)
				.accept(MediaType.APPLICATION_JSON)));
	}

	@Quand("j'enregistre cet utilisateur")
	public void iRegisterThisUser() throws Exception {
		NutUserResponseDomain response = new NutUserResponseDomain(1L, currentFirstname, currentLastname, currentGender,
				Instant.parse(currentBirthdate), Collections.emptyList());
		when(myNutServiceImpl.registerNewUser(any(NutUserDomain.class))).thenReturn(response);

		String json = String.format("""
				{"firstname":"%s","lastname":"%s","gender":"%s","birthdate":"%s"}
				""", currentFirstname, currentLastname, currentGender, currentBirthdate);
		context.setLastResult(mockMvc.perform(post("/my-nut/api/v1/user")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json)
				.accept(MediaType.APPLICATION_JSON)));
	}

	@Quand("j'enregistre ces utilisateurs")
	public void iRegisterTheseUsers() throws Exception {
		String json = """
				[
					{"firstname":"Alice","lastname":"Dupont","gender":"F","birthdate":"1990-05-15T00:00:00Z"},
					{"firstname":"Bob","lastname":"Martin","gender":"M","birthdate":"1985-03-20T00:00:00Z"}
				]
				""";
		context.setLastResult(mockMvc.perform(post("/my-nut/api/v1/users")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json)
				.accept(MediaType.APPLICATION_JSON)));
	}

	@Alors("la réponse contient le prénom {string}")
	public void theResponseContainsFirstName(String firstname) throws Exception {
		context.getLastResult().andExpect(jsonPath("$.firstname", is(firstname)));
	}

	@Et("la réponse contient le nom {string}")
	public void theResponseContainsLastName(String lastname) throws Exception {
		context.getLastResult().andExpect(jsonPath("$.lastname", is(lastname)));
	}

	@Alors("la réponse est vide")
	public void theResponseIsEmpty() throws Exception {
		context.getLastResult().andExpect(content().string("null"));
	}

	@Alors("la réponse contient une liste de {int} utilisateurs")
	public void theResponseContainsAListOfUsers(int count) throws Exception {
		context.getLastResult().andExpect(jsonPath("$", hasSize(count)));
	}

	@Alors("la réponse contient une liste vide")
	public void theResponseContainsAnEmptyList() throws Exception {
		context.getLastResult().andExpect(jsonPath("$", empty()));
	}
}
