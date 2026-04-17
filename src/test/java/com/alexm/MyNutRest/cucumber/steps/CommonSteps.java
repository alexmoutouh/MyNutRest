package com.alexm.MyNutRest.cucumber.steps;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Étantdonné;

public class CommonSteps {

	private final ScenarioContext context;

	public CommonSteps(ScenarioContext context) {
		this.context = context;
	}

	@Étantdonné("un utilisateur existant avec l'id {long}")
	public void anExistingUserWithId(Long id) {
		context.setCurrentUserId(id);
	}

	@Alors("la réponse HTTP est {int}")
	public void theHTTPResponseIs(int statusCode) throws Exception {
		context.getLastResult().andExpect(status().is(statusCode));
	}
}
