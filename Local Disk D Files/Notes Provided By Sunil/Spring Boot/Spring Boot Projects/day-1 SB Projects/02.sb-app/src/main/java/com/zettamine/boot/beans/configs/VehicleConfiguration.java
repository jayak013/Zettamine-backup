package com.zettamine.boot.beans.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zettamine.boot.utils.PasswordEncoder;

@Configuration
public class VehicleConfiguration {

	public VehicleConfiguration() {
		System.out.println("VehicleConfiguration :: Constructor");
	}
	
	//@Bean
	//@Bean(name = "encoder")
	//@Bean(value = {"encoder","pwdenc"})
	@Bean(value = {"encoder","pwdenc"}, initMethod = "myInit", destroyMethod = "myDestructor")
	public PasswordEncoder getEncoder() {
		return new PasswordEncoder();
	}
}
