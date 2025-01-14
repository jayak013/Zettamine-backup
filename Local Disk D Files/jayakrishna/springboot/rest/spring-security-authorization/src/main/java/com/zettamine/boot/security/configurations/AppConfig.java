package com.zettamine.boot.security.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AppConfig {
	
	@Bean
	public PasswordEncoder getPasswordEcoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
}
