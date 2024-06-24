package com.zettamine.boot.security.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class WelcomeControllers {
	
	@GetMapping("/user")
	public String user() {
		return "Accessing USER HTTP";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "Accessing ADMIN HTTP";
	}
	
	@GetMapping("/manager")
	public String manager() {
		return "Accessing MANAGER HTTP";
	}
	
	
}
