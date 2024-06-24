package com.zettamine.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zettamine.spring.core.beans.User;
import com.zettamine.spring.core.utils.PasswordEncoderDecoder;

public class MainApp {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//		
//		
//		User user =  (User) context.getBean("newUser");
//		
//		((AbstractApplicationContext)context).registerShutdownHook();
		

		ApplicationContext context = new ClassPathXmlApplicationContext("user-beans.xml");
		User user1 = (User) context.getBean("user1");
		User user2 = (User) context.getBean("user2");
		System.out.println(user1);
		System.out.println(user2);
	}
}
