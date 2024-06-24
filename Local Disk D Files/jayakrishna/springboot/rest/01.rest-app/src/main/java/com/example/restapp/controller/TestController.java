package com.example.restapp.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@GetMapping("/test")
	public String get() {
		return "GET TYPE REQUEST TRIGGERED";
	}
	@PostMapping("/test")
	public String post() {
		return "POST TYPE REQUEST TRIGGERED";
	}
	@PutMapping("/test")
	public String update() {
		return "PUT TYPE REQUEST TRIGGERED";
	}
	@DeleteMapping("/test")
	public String delete() {
		return "DELETE TYPE REQUEST TRIGGERED";
	}
	
	@GetMapping("/test/resp-entity")
	public ResponseEntity<String> getOfRespEntity() {
		LocalDateTime now = LocalDateTime.now();
		String date = now.toString();
		HttpHeaders header = new HttpHeaders();
		header.add("Date", date);
		ResponseEntity<String> responseEntity = new ResponseEntity<String>("The Today's date is : " + date,header,HttpStatus.OK);
		return responseEntity;
	}
	
}
