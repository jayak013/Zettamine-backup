package com.zettamine.spring.core;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zettamine.spring.core.beans.Customer;

public class MainApp {
	
	private static final String Car = null;

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("user-bean.xml");
		
		System.out.println(context.getBeanDefinitionCount());
		System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
		
		Customer cust = (Customer)context.getBean("cust");
		System.out.println(cust);
	}
	
}
