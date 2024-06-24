package com.zettamine.spring;

import java.util.Arrays;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.zettamine.spring.beans.BusinessService;

@Configuration
@ComponentScan
public class Main {
	public static void main(String[] args) {
		try(ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(Main.class)){
			System.out.println("no of beans = " + context.getBeanDefinitionCount());
			
			Arrays.stream(context.getBeanDefinitionNames()).forEach(bn -> System.out.println("----> " + bn));
			
			System.out.println();
			
			BusinessService busSer = context.getBean(BusinessService.class);
			System.out.println(busSer);
		}
		
	}
}
