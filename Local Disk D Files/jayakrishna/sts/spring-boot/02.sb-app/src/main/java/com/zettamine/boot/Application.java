package com.zettamine.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zettamine.boot.beans.Ticket;
import com.zettamine.boot.utils.PasswordEncoder;

@SpringBootApplication
public class Application {
	
	private static final Logger LOGGER =  LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		int beanCount = context.getBeanDefinitionCount();
		LOGGER.info(System.lineSeparator());
		LOGGER.info("no of beans = {}",beanCount);
		
		LOGGER.info(System.lineSeparator());
		
		String pass = "admin123#";
		PasswordEncoder encoder = (PasswordEncoder)context.getBean("pwdenc");
		
		String encodePassword = encoder.encodePassword(pass);
		
		LOGGER.info("encoded password = {}",encodePassword);
		
		Ticket tkt = context.getBean(Ticket.class);
		LOGGER.info(System.lineSeparator());
		System.out.println(tkt);
		
		LOGGER.info(System.lineSeparator());
		context.close();
		
	}

}
