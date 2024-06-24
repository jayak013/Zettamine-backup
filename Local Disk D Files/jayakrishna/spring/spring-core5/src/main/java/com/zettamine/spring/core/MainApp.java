package com.zettamine.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zettamine.spring.core.beans.User;
import com.zettamine.spring.core.utils.PasswordEncoderDecoder;

public class MainApp {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		ApplicationContext c = new ClassPathXmlApplicationContext("user-beans.xml");
		
//		PasswordEncoderDecoder p =  (PasswordEncoderDecoder) context.getBean("passwordEncoderDecoder");
//		PasswordEncoderDecoder p =  (PasswordEncoderDecoder) context.getBean("passwordEncoder");
		User user1 =  (User) c.getBean("user1");
		User user2 =  (User) c.getBean("user2");
		
		((ConfigurableApplicationContext)c).close();
		
//		System.out.println("The Enocoded String is : " + p.getEncoderString());
//		System.out.println("The Enocoded String is : " + p.getEncoderString());
		
	}
}
