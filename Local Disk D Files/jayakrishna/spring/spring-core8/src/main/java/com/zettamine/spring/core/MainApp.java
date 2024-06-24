package com.zettamine.spring.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zettamine.spring.core.beans.BusinessService;

public class MainApp {
	

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		BusinessService b = context.getBean(BusinessService.class);
		System.out.println(b);
	}
	
}
