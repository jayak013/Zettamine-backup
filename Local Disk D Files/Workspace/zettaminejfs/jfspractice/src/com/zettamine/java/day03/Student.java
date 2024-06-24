package com.zettamine.java.day03;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Student {
	private String studentId;
	private String studentName;
	private String studentEmail;
	private static String collegeName = "Zettamine";
	private static int count = 100;

	public Student() {}
	
	public Student(String studentId,String studentName,String studentEmail){
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentEmail = studentEmail;
	}
	
	public static Student addStudent(String studentName,String studentEmail) {
		Scanner scn = new Scanner(System.in);
		String emailPattern = "[A-Za-z0-9.]*@[A-Za-z]+[.][A-Za-z]+";
		while(!Pattern.matches(emailPattern, studentEmail)) {
			System.out.println("Please enter a valid mail as example123@domain.com");
			studentEmail = scn.nextLine();
		};
		return new Student("ZETTA_"+ ++count,studentName,studentEmail);
	}
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentEmail() {
		return studentEmail;
	}
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	public String getStudentId() {
		return studentId;
	}
	public static String getCollegeName() {
		return collegeName;
	}

	@Override
	public String toString() {
		return String.format("%-11s | %-21s | %-23s | %-10s", studentId, studentName, studentEmail, collegeName );

	}
	
	
	
	
}
