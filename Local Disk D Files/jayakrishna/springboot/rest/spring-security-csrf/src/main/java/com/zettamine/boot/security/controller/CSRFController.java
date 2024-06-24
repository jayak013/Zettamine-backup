package com.zettamine.boot.security.controller;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CSRFController {
	
	@GetMapping("/csrf-token")
	public CsrfToken getCSRFToken(CsrfToken csrfToken) {
		return csrfToken;
	}
	
}
