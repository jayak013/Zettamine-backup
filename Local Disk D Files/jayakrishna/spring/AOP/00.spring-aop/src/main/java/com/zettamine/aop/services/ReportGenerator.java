package com.zettamine.aop.services;

import java.util.Random;

public class ReportGenerator {
	
	public String generateExcelReport() {
		System.out.println("logic to generate excel report.....");
		return "ZAIBA KHAN";
	}
//	
//	public void generateExcelReport(String fileName,String fileType) {
//		System.out.println("logic to generate excel report with file-name and file-type.....");
//	}
//	
//	public boolean generateExcelReport(String fileName) {
//		System.out.println("logic to generate excel report with file name.....");
//		return new Random().nextBoolean();
//	}
//
	public boolean validatePassword(String pass) {
		int password = pass.trim().length();
		if(password>=5) return true;
		else throw new RuntimeException("Password should be atleast a length of 5");
	}
	
}
