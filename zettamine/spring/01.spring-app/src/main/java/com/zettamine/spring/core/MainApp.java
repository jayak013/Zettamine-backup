package com.zettamine.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		//initialize spring container / IoC
		//BeanFactory factory = new ClassPathXmlApplicationContext("user-beans.xml");
		ApplicationContext context = new ClassPathXmlApplicationContext("user-beans.xml");
		
		System.out.println("---------------------------------------------------------");
		
		int noOfBeans = context.getBeanDefinitionCount();
		System.out.println("no of beans configured = " + noOfBeans);
		System.out.println();
		
		System.out.println("------------ BEAN NAMES ---------------");
		String[] beanNames = context.getBeanDefinitionNames();
		for(String beanName : beanNames) {
			System.out.println("----> " + beanName);
		}
	}

}
