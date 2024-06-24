package com.zettamine.boot.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		//BCryptPasswordEncoder encoder = context.getBean(BCryptPasswordEncoder.class);
		
		//String pass = "1234";
		//String encodedPassword = encoder.encode(pass);
		//System.out.println(encodedPassword);		
	}

}
