package com.zettamine.boot.beans.services;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.zettamine.boot.utils.PasswordEncoder;

@Service
public class VehicleServices {

	public VehicleServices() {
		System.out.println("VehicleServices :: Constructor");
	}
	
	@Bean(value = {"encoder","pwdenc"},initMethod = "myInit",destroyMethod = "myDestructor")
	public PasswordEncoder getEncoder() {
		return new PasswordEncoder();
	}
	
}
