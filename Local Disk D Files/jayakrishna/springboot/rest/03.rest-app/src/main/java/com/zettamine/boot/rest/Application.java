package com.zettamine.boot.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "TRAIN TICKET BOOKING APPLICATION", description = "Ticket Booking Application", 
version = "2.0", contact = @Contact(name = "Jaya Krishna", email = "seethagarijayakrishna@gmail.com")))
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
