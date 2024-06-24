package com.wipro.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.wipro.spring.services.DataService;

@Configuration
@ComponentScan
public class DataLauncherApp {
	public static void main(String[] args) {
		try(var context = new AnnotationConfigApplicationContext(DataLauncherApp.class)){
			DataService service = context.getBean(DataService.class);
			System.out.println("max value = " + service.findMax());
		}
	}
}
