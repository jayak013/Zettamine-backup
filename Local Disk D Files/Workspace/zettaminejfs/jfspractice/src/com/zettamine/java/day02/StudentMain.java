package com.zettamine.java.day02;

import java.util.Scanner;

public class StudentMain {
	
	static Scanner scn = new Scanner(System.in);
	static Student student;
	public static void main(String[] args) {
		System.out.print("Enter Student's Id: ");
		int studentId = scn.nextInt();
		scn.nextLine();
		System.out.print("Enter Student's name: ");
		String studentName = scn.nextLine();
		System.out.print("Enter Student's address: ");
		String studentAddress = scn.nextLine();
		while(true) {
		System.out.print("Whether the Student is from NIT(Yes/No): ");
		String NITconfirm = scn.nextLine();
			if(NITconfirm.equals("No") || NITconfirm.equals("NO")) {
				System.out.print("Enter the college name: ");
				String collegeName = scn.nextLine();
				student = new Student(studentId, studentName,
						studentAddress,collegeName);
				printStudent(student);
				break;
			}else if(NITconfirm.equals("Yes") || NITconfirm.equals("YES")) {
				student = new Student(studentId, studentName, studentAddress,"NIT");
				printStudent(student);
				break;
			}else {
				System.out.println("Wrong Input");
			}
		}
	}
	private static void printStudent(Student s) {
		System.out.println("~".repeat(30));
		System.out.println("Student Id: "+s.getStudentId()
		+"\nStudent Name: "+s.getStudentName()+"\nAddress: "+s.getStudentAddress()
		+"\nCollege Name: "+s.getCollegeName());
		System.out.println("~".repeat(30));
	}
	
}
