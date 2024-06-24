package com.zettamine.boot.mvc.controller;

import org.springframework.ui.Model;

public class SecondController {
	public String view(Model model) {
		model.addAttribute("message", "Jaya Krishna Seethagari");
		return "empty";
	}
}
