package com.zettamine.spring.core;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zettamine.spring.core.beans.Customer;

@Configuration
@ComponentScan
public class Main {

	public static void main(String[] args) {
		try(ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("customer-car-beans.xml"))
		{
			
		 Customer cust = (Customer) context.getBean("sanjay");
		
		 System.out.println(cust.getCustomerName()+" owns a " + cust.getCar().getModel()+" car , "
		 		+ " which costs Rs." + cust.getCar().getCost());
		}
	}

}
