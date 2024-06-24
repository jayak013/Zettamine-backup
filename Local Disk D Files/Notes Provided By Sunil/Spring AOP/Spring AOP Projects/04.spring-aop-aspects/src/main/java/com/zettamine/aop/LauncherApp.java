package com.zettamine.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.zettamine.aop.services.PasswordValidator;
import com.zettamine.aop.services.ReportGenerator;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class LauncherApp {

	public static void main(String[] args) {
		try(var context = new AnnotationConfigApplicationContext(LauncherApp.class)){
			//Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			
			ReportGenerator repGen = context.getBean(ReportGenerator.class);
			
			repGen.generateExcelReport();
			System.out.println();
			
			repGen.generateExcelReport("zettamine");
			System.out.println();
			
			repGen.generateExcelReport("zetta","txt");
			System.out.println();
			
			repGen.generatePdfReport();
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