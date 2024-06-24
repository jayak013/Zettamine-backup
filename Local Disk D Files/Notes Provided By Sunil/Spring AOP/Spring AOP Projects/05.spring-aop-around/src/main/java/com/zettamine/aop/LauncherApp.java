package com.zettamine.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.zettamine.aop.services.ReportGenerator;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class LauncherApp {

	public static void main(String[] args) {
		try(var context = new AnnotationConfigApplicationContext(LauncherApp.class)){			
			
			ReportGenerator repGen = context.getBean(ReportGenerator.class);
			
			repGen.generateExcelReport();
			System.out.println();			
		}
	}
}