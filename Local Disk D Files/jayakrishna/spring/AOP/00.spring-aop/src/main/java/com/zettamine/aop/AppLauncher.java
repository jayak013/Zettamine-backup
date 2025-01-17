package com.zettamine.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zettamine.aop.services.ReportGenerator;

public class AppLauncher {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans-aop.xml");
		ReportGenerator repGen = (ReportGenerator)context.getBean("proxy");
		repGen.generateExcelReport();
		System.out.println();
//		repGen.generateExcelReport("Test-File");
//		System.out.println();
//		repGen.generateExcelReport("Test-File", "Test-Type");
//		System.out.println();
		try {
			if(repGen.validatePassword("1234")) {
				System.out.println("AUTHENTICATION SUCCESS");
			}else {
				System.err.println("AUTHENTICATION FAILED");
			}
		}catch(Exception ex) {
			System.out.println("...try again...");
		}
	}
}
