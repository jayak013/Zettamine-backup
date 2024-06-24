package com.zettamine.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zettamine.aop.services.ReportGenerator;

public class LauncherApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("aop-beans.xml");
		
		ReportGenerator repGen = (ReportGenerator) context.getBean("proxy");
		
		repGen.generateExcelReport();
		System.out.println();
		repGen.generateExcelReport("zettamineHibBatch", "pdf");
		
		System.out.println();
		repGen.generateExcelReport("zettamineSpringBatch.xlsx");
		
		((AbstractApplicationContext)context).close();
	}
}
