package com.zettamine.spring.core.beans.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.zettamine.spring.utils.DataEncryptorUtil;

@Configuration
@ComponentScan(basePackages = {"com.zettamine.spring.core.beans"})
public class UserConfiguration {

	public UserConfiguration() {
		System.out.println("UserConfiguration :: Constructor");
	}
	
	//@Bean
	@Bean(name = {"security", "encoder"})
	public DataEncryptorUtil getDataUtility() {
		return new DataEncryptorUtil();
	}
}
