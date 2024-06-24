package com.zettamine.boot.security.inmemory.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	
	@GetMapping("/welcome")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String welcomeText() {
		return "Welcome to the USER-JAMS";
	}
	
}
