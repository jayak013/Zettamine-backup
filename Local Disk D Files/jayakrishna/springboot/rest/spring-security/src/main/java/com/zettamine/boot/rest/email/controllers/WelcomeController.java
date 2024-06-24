package com.zettamine.boot.rest.email.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	
	@GetMapping("/welcome")
	public ResponseEntity<String> getMessage(){
		return new ResponseEntity<String>("Welcome Jaya Krishna Seethagari",HttpStatus.OK);
	}
	
}
