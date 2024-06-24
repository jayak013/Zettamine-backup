package com.zettamine.boot.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetController {
	//@RequestMapping("/greet")
	//@RequestMapping(path = "/greet")
	//@RequestMapping(value = "/greet")
	//@RequestMapping(value = "/greet", method = RequestMethod.GET)
	//@GetMapping("/greet")
	//@GetMapping(value = "/greet")
	//@GetMapping(path = "/greet")
	@GetMapping(path = {"/greet","/greets","/greetings"})
	public ModelAndView showGreetingMessage() {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("message", "Greetings from Zettamine");
		mav.setViewName("index");
		
		return mav;
	}
}
