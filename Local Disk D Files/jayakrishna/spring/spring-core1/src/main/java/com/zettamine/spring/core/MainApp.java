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
		System.out.println("=".repeat(70));
		
		User user1 = (User) factory.getBean("user1");
		User user11 = (User) factory.getBean("user1");
		User user2 = (User) factory.getBean("user2");
		User user22 = (User) factory.getBean("user2");
		
		System.out.println(factory.getBeanDefinitionCount());
		System.out.println(Arrays.toString(factory.getBeanDefinitionNames()));
		
		System.out.println("-".repeat(100));
		System.out.println(user1);
		System.out.println(user11);
		System.out.println("-".repeat(100));
		System.out.println(user2);
		System.out.println(user22);
		System.out.println("-".repeat(100));
	}
}
