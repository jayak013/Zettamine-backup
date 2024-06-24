package com.zettamine.aop.services;


import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

@Service
public class ReportGenerator {
	public void generateExcelReport() {		
		try {
			TimeUnit.SECONDS.sleep(3);
		}catch(Exception ex) {}
		
		System.out.println("\033[32mlogic to generate excel report!!! \033[0m");
	}
	
	public void generatePdfReport() {
		System.out.println("\033[32mlogic to generate pdf report!!\033[0m");
	}
}
