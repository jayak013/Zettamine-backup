package com.zettamine.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zettamine.aop.services.PasswordValidator;
import com.zettamine.aop.services.ReportGenerator;

public class AppLauncher {
	public static void main(String[] args) {
		try(var context = new ClassPathXmlApplicationContext("beans-aop.xml")){
			//Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			
			ReportGenerator repGen = context.getBean(ReportGenerator.class);
			
			repGen.generateExcelReport();
			System.out.println();
			
			repGen.generateExcelReport("zettamine");
			System.out.println();
			
			repGen.generateExcelReport("zetta","txt");
			System.out.println();
			
			
			
			PasswordValidator pwdVal = context.getBean(PasswordValidator.class);
			//String pwd = "123456";
			String pwd = "1234";
			
			try {
				System.out.println("\033[32mis Password Validated = " + pwdVal.validatePassword(pwd) + "\033[0m");
			}catch(Exception ex) {
				System.out.println("\033[31mAuthentication Failed\033[0m");
			}
		}
	}
}
