package com.api.component;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2

public class ComponentsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComponentsServiceApplication.class, args);
	}
	
	@Bean
	public Docket api()
	{
	return new Docket(DocumentationType.SWAGGER_2)	;
	}
}
