package com.zettamine.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.zettamine.boot.beans.Car;
import com.zettamine.boot.beans.Ticket;
import com.zettamine.boot.utils.PasswordEncoder;

@SpringBootApplication
@ComponentScan(basePackages = "com.zettamine")
public class Application {
	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		System.out.println();
		
		int noOfBeans = context.getBeanDefinitionCount();
		LOGGER.info("no of beans = {}", noOfBeans);
	
		LOGGER.info(System.lineSeparator());
		
		//Car car = context.getBean(Car.class);
		//Car car = (Car) context.getBean("car");
		//Car car = context.getBean("car", Car.class);
		Car car = (Car) context.getBean("mycar");
		car.startJourney();
		
		LOGGER.info(System.lineSeparator());
		
		String pass = "admin123#";
		//PasswordEncoder encoder = context.getBean(PasswordEncoder.class);
		//PasswordEncoder encoder = (PasswordEncoder) context.getBean("getEncoder");
		//PasswordEncoder encoder = (PasswordEncoder) context.getBean("encoder");
		PasswordEncoder encoder = (PasswordEncoder) context.getBean("pwdenc");
		String encodedPass = encoder.encodePassword(pass);
		LOGGER.info("encoded pwd = {}", encodedPass);
		
		LOGGER.info(System.lineSeparator());
		
		Ticket tkt = context.getBean(Ticket.class);
		System.out.println(tkt);
		
		LOGGER.info(System.lineSeparator());
		context.close();
	}

}
