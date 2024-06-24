package com.zettamine.sb.app;

import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class FirstProjectApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(FirstProjectApplication.class, args);
		
		int countOfBeans = context.getBeanDefinitionCount();
		System.out.println("Number of beans created by spring boot application: "+ countOfBeans);
		
		String[] beanNames = context.getBeanDefinitionNames();
		System.out.println("Name of the beans that are created in the container:---->");
		Stream.of(beanNames).forEach(System.out::println);
	}

}
