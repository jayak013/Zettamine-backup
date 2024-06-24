package com.example.ageeligibility.controllers;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personal")
public class PersonController {
	
	@GetMapping({"/age","/age/{name}/{bornYear}","/age/{name}"})
	public String ageEligiblity(@PathVariable(required = false) String name,@PathVariable(required = false) Integer bornYear) {
		if(name==null) return "Please provide the name and age";
		if(bornYear==null) return "Hi "+name+", please provide the required inputs of Age.";
		int currentYear = LocalDate.now().getYear();
		if(bornYear <currentYear) {
			return "Hi "+name+" ,you are "+(currentYear - bornYear)+" years of age and eligible for Insurance.";
		}
			return "Hi "+name+" ,you are not eligible for Insurance.";
	}
	
}
