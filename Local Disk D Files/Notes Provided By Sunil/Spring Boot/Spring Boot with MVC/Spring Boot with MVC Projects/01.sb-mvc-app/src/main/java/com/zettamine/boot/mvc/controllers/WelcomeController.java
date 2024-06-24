package com.zettamine.boot.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {
	@RequestMapping("/welcome")
	public ModelAndView showWelcomeMessage() {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("message", "Welcome to Zettamine");
		mav.setViewName("index");
		
		return mav;
	}
}
