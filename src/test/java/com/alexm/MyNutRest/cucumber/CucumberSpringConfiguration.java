package com.alexm.MyNutRest.cucumber;

import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.alexm.MyNutRest.domain.service.MyFitServiceImpl;
import com.alexm.MyNutRest.domain.service.MyNutScanServiceImpl;
import com.alexm.MyNutRest.domain.service.MyNutServiceImpl;
import com.alexm.MyNutRest.presentation.controller.MyFitController;
import com.alexm.MyNutRest.presentation.controller.MyNutController;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@WebMvcTest({MyNutController.class, MyFitController.class})
@ActiveProfiles("test")
@ComponentScan("com.alexm.MyNutRest.cucumber")
public class CucumberSpringConfiguration {

	@MockitoBean
	MyNutServiceImpl myNutServiceImpl;

	@MockitoBean
	MyFitServiceImpl myFitServiceImpl;

	@MockitoBean
	MyNutScanServiceImpl myNutScanServiceImpl;

	@MockitoBean
	ToolCallbackProvider myNutTools;

	@MockitoBean
	ToolCallbackProvider myFitTools;
}
