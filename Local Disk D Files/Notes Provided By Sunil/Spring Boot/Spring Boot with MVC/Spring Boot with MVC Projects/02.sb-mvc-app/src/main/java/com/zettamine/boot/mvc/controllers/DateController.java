package com.zettamine.boot.mvc.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DateController {
	@GetMapping(path = {"/date", "/today"})
	public ModelAndView getTodaysDate() {
		ModelAndView mav = new ModelAndView();
		
		LocalDateTime dt = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy HH:mm:ss");
		String now = dt.format(formatter);
		
		mav.addObject("date", now);
		mav.setViewName("index");
		
		return mav;
	}
}
