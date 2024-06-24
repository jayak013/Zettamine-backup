package com.zettamine.spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.zettamine.spring.core.utils.PasswordEncoderDecoder;

@Configuration
@ComponentScan("com.zettamine.spring")
public class AppConfig {
	public AppConfig() {
		System.out.println("AppConfig::constructor");
	}
	
	@Bean(name = "passwordEncoder")
	public PasswordEncoderDecoder getEncoderDecoder() {
		return new PasswordEncoderDecoder();
	}
}
