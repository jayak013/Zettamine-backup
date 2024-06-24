package com.zettamine.boot.security.configs;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

@Configuration
public class AppConfig {
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		//PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		
		Map<String, PasswordEncoder> encoders = new HashMap<>();
		encoders.put("noop", NoOpPasswordEncoder.getInstance());
		encoders.put("scrypt", SCryptPasswordEncoder.defaultsForSpringSecurity_v4_1());
		encoders.put("scrypt@SpringSecurity_v5_8", SCryptPasswordEncoder.defaultsForSpringSecurity_v5_8());
		
		//PasswordEncoder encoder = new DelegatingPasswordEncoder("scrypt", encoders);
		PasswordEncoder encoder = new DelegatingPasswordEncoder("scrypt", encoders);
		return encoder;
	}
}
