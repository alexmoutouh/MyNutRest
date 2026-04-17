package com.alexm.MyNutRest.cucumber.steps;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.ResultActions;

@Component
@Scope("cucumber-glue")
public class ScenarioContext {

	private ResultActions lastResult;
	private Long currentUserId;

	public ResultActions getLastResult() {
		return lastResult;
	}

	public void setLastResult(ResultActions lastResult) {
		this.lastResult = lastResult;
	}

	public Long getCurrentUserId() {
		return currentUserId;
	}

	public void setCurrentUserId(Long currentUserId) {
		this.currentUserId = currentUserId;
	}
}
