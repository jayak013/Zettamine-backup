package com.zettamine.aop.services;

import java.util.Random;

import org.springframework.stereotype.Service;

public class ReportGenerator {
	public void generateExcelReport() {		
		System.out.println("\033[32mlogic to generate excel report!!! \033[0m");

	}

	public boolean generateExcelReport(String fileName) {		
		System.out.println("\033[32mlogic to generate excel report with custom file name!!!\033[0m");
		return new Random().nextBoolean();
	}
	
	public void generateExcelReport(String fileName, String fileType) {		
		System.out.println("\033[32mlogic to generate excel report with custom file type and name!!!\033[0m");
	}
	
	public void generatePdfReport() {
		System.out.println("\033[32mlogic to generate pdf report!!\033[0m");
	}
}
