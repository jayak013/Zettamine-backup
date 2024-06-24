package com.zettamine.java.oops;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CMSApp {
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		List<Student> students = new ArrayList<Student>();
		
		do {
			System.out.println("enter student name and email: ");
			String name = sc.nextLine();
			String email = sc.nextLine();
			
			Student st = new Student(name, email);
			students.add(st);
			
			System.out.print("do you want to add more students?[Y/N] : ");
		}while(sc.nextLine().equalsIgnoreCase("Y"));
		System.out.println("=".repeat(75));
		System.out.println("  STUD_ID   |     STUDENT NAME      |     STUDENT EMAIL       |  COLLEGE NAME" );
		System.out.println("=".repeat(75));
		for(Student st : students) {
			System.out.println(st);
			System.out.println("-".repeat(75));
		}
		System.out.println("=".repeat(75));		
	}

}
