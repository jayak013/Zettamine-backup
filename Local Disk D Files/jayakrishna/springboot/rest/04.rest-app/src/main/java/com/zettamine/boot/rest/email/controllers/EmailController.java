package com.zettamine.boot.rest.email.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zettamine.boot.rest.email.models.Email;
import com.zettamine.boot.rest.email.services.EmailService;



@RestController
@RequestMapping("/email")
public class EmailController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmailController.class);
	
	private EmailService emailService;
	
	public EmailController(EmailService emailService) {
		this.emailService = emailService;
	}

	@PostMapping(path = "/send-email",consumes = {"application/json","application/xml"})
	public ResponseEntity<?> sendEmail(@RequestBody Email email){
		LOGGER.info(email.toString());
		Boolean sendEmail = emailService.sendEmail(email);
		LOGGER.info(sendEmail.toString());
		if(sendEmail)
		return new ResponseEntity<String>(email+"\nsuccessfully sent",HttpStatus.OK);
		return new ResponseEntity<String>("send failed",HttpStatus.BAD_REQUEST);
	}
	
}
