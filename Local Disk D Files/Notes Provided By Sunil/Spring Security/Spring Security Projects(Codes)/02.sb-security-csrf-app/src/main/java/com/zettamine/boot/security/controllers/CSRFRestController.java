package com.zettamine.boot.security.controllers;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class CSRFRestController {
	/*
	@GetMapping(path = "/csrf-token")
	public CsrfToken retrieveCsrfToken(HttpServletRequest request) {
		return (CsrfToken) request.getAttribute("_csrf");
	}
	*/
	@GetMapping(path = "/csrf-token")
	public CsrfToken retrieveCsrfToken(CsrfToken token) {
		return token;
	}	
}
