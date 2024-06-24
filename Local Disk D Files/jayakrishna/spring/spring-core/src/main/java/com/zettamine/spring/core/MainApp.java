package com.zettamine.spring.core;

import java.util.Arrays;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zettamine.spring.core.beans.User;

public class MainApp {
	public static void main(String[] args) {
//		BeanFactory factory = new ClassPathXmlApplicationContext("user-bean.xml");
		ApplicationContext factory = new ClassPathXmlApplicationContext("user-bean.xml");
		User user1 = (User) factory.getBean("user1");
		User user = (User) factory.getBean("user1");
		User user2 = (User) factory.getBean("user2");
		User user3 = (User) factory.getBean("user3");
		User user4 = (User) factory.getBean("user4");
		
		System.out.println(factory.getBeanDefinitionCount());
		System.out.println(Arrays.toString(factory.getBeanDefinitionNames()));
		
		System.out.println("-".repeat(100));
		System.out.println(user1);
		System.out.println(user);
		System.out.println("-".repeat(100));
		System.out.println(user2);
		System.out.println("-".repeat(100));
		System.out.println(user3);
		System.out.println("-".repeat(100));
		System.out.println(user4);
		System.out.println("-".repeat(100));
	}
}
