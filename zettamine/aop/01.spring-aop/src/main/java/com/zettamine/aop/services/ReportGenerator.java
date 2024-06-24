package com.zettamine.aop.services;

import java.util.Random;

public class ReportGenerator {
	public void generateExcelReport() {		
		System.out.println("logic to generate excel report!!!");
	}
	
	public void generateExcelReport(String fileName, String fileType) {		
		System.out.println("logic to generate excel report with custom file type and name!!!");
	}
	
	public boolean generateExcelReport(String fileName) {		
		System.out.println("logic to generate excel report with custom file name!!!");
		return new Random().nextBoolean();
	}	
}
