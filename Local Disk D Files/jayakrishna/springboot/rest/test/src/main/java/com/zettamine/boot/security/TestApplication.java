package com.zettamine.boot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Primary;

import com.zettamine.boot.security.models.Vehicle;

@SpringBootApplication
public class TestApplication implements CommandLineRunner{

	@Autowired
	@Qualifier
	private Vehicle vehicle;
	
	@Autowired
	private Vehicle vehicle1;
	
	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {		
			vehicle.test();
			vehicle1.test();
	}
	
	

}
