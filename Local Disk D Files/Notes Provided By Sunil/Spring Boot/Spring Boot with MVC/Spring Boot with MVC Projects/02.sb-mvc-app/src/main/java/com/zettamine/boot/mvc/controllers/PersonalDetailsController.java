package com.zettamine.boot.mvc.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonalDetailsController {
	@GetMapping(path = "/admin/details")
	public String showAdminPersonalDetails(Model model) {
		String name = "Ajay Kumar";
		int age = 29;
		String address = "Bangalore, Karnataka";
		
		/*
		model.addAttribute("admin_name", name);
		model.addAttribute("admin_age", age);
		model.addAttribute("admin_addr", address);
		*/
		
		Map<String, String> data = new HashMap<String, String>();
		data.put("admin_name", name);
		data.put("admin_age", String.valueOf(age));
		data.put("admin_addr", address);
		
		model.addAllAttributes(data);
		
		return "details";	
	}
}
