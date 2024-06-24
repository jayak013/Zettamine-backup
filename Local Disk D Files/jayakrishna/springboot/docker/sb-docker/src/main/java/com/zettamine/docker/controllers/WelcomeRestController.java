package com.zettamine.docker.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeRestController {
	
	@GetMapping(path = "/welcome")
	public String welcome() {
		return "Spring Boot Dockerization Test";
	}
	
}
