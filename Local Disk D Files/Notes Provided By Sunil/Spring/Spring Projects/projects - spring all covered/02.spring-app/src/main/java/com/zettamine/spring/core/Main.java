package com.zettamine.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zettamine.spring.core.beans.User;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("user-beans.xml");
		System.out.println();
		
		System.out.println("--------------------------------------------------------------");
		User usr1 = (User) context.getBean("user1");
		System.out.println(usr1);
		System.out.println("--------------------------------------------------------------");
		
		User usr2 = (User) context.getBean("user1");
		System.out.println(usr2);
		System.out.println("--------------------------------------------------------------");
		
		User usr3 = context.getBean("user2", User.class);
		System.out.println(usr3);
	}

}
