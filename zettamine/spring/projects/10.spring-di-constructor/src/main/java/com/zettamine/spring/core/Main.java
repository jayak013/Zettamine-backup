package com.zettamine.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zettamine.spring.core.beans.Customer;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("customer-car-beans.xml");
		
		//Customer cust = (Customer)context.getBean("sanjay");
		Customer cust = (Customer)context.getBean("praveen");
		System.out.println(cust.getCustomerName()+" owns a " + cust.getCar().getModel()+" car , which costs Rs." + cust.getCar().getCost());
	}

}
