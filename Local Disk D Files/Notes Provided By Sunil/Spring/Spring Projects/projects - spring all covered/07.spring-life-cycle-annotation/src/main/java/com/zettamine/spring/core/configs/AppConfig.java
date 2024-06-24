package com.zettamine.spring.core.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"com.zettamine.spring.core"})
public class AppConfig {

	public AppConfig() {
		System.out.println("AppConfig :: Constructor");
	}

}
