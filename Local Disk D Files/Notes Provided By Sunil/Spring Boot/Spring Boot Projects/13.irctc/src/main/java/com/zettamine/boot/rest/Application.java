package com.zettamine.boot.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")

@OpenAPIDefinition(info = @Info(title = "IRCTC TICKET APP", 
description = "Ticket Booking Application",
version = "v2", 

contact = @Contact(
		   	name = "Sunil Joseph", 
		   	email = "sunil.j@zetamine.com",
		   	url = "https://www.zettamine.com"),
license = @License(
			name = "Zetta 2.0",
			url = "https://www.zettamine.com")),

externalDocs = @ExternalDocumentation(
description =  "Train Ticket Booking REST API Documentation",
url = "https://www.zettamine.com/swagger-ui.html"))

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
