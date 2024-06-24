package com.zettamine.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zettamine.spring.core.beans.User;
import com.zettamine.spring.core.configs.AppConfig;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println("spring container initialized*****");
		
		System.out.println("--------------------------------------------------------------");
		User usr1 = (User) context.getBean("sunil");
		System.out.println(usr1);
		System.out.println("--------------------------------------------------------------");
		
		User usr2 = (User) context.getBean("sunil");
		System.out.println(usr2);
		System.out.println("--------------------------------------------------------------");
		

	}

}
