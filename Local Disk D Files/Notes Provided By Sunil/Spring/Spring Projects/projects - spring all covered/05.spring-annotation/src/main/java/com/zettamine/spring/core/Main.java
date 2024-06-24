package com.zettamine.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zettamine.spring.core.beans.configs.UserConfiguration;
import com.zettamine.spring.utils.DataEncryptorUtil;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(UserConfiguration.class);
		
		System.out.println("no of beans = " + context.getBeanDefinitionCount());
		
		String[] beanNames = context.getBeanDefinitionNames();
		
		for(String bName : beanNames) {
			System.out.println(bName);
		}
		System.out.println();

		//DataEncryptorUtil dUtil = context.getBean(DataEncryptorUtil.class);
		//DataEncryptorUtil dUtil = (DataEncryptorUtil) context.getBean("security");
		DataEncryptorUtil dUtil = (DataEncryptorUtil) context.getBean("encoder");
		
		String pwd = "zetta#1";
		String encodedPwd = dUtil.encodeData(pwd);
		System.out.println("encoded data = " + encodedPwd);
	}

}
