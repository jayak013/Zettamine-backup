package com.zettamine.spring.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AppConfig {
	
	public AppConfig() {
		System.out.println("AppConfig :: Consturctor");
	}
	
}
