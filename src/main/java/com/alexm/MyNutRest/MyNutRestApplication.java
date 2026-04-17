package com.alexm.MyNutRest;

import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.alexm.MyNutRest.domain.service.MyNutService;

@SpringBootApplication
public class MyNutRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyNutRestApplication.class, args);
	}

	@Bean
	public ToolCallbackProvider myNutTools(MyNutService myNutService) {
		return MethodToolCallbackProvider.builder().toolObjects(myNutService).build();
	}
}
