package com.zettamine.boot.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {
	@RequestMapping("/welcome")
	public ModelAndView welome() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", "Welcome to Zettamine Labs Private Limited");
		mav.setViewName("welcome");
		return mav;
	}
}
