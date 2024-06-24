package com.zettamine.boot;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan
public class LauncherApp {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(LauncherApp.class, args);
		System.out.println();
		
		int noOfBeans = context.getBeanDefinitionCount();
		System.out.println("no of beans = " + noOfBeans);
		
		String[] beanNames = context.getBeanDefinitionNames();
		
		Arrays.stream(beanNames).forEach(System.out::println);
		context.close();
	}
}
