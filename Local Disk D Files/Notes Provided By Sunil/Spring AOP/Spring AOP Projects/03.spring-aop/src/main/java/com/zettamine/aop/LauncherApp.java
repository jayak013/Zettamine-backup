package com.zettamine.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zettamine.aop.services.PasswordValidator;

public class LauncherApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("aop-beans.xml");

		PasswordValidator validator = (PasswordValidator) context.getBean("proxy");

		String pwd = "1234";
		//String pwd = "123456";
		
		if (validator.validatePassword(pwd))
			System.out.println("AUTHENTICATED USER");
		else
			System.err.println("AUTHENTICATION FAILED");

		((AbstractApplicationContext) context).close();
	}
}
