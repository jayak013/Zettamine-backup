package com.zettamine.java.day03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.zettamine.java.day02.NotAValidInput;
import com.zettamine.java.day02.ValidateEmail;

public class CreateListOfStudents {
	
	public static void main(String[] args) {
		List<Student> listOfStuds = new ArrayList();
		Scanner scn = new Scanner(System.in);
		int i = 1;
		String namePattern = "[A-Za-z\\s]+";
		char confirm = 'Y';
		do {
			if(confirm=='Y'||confirm=='y') {
				Student s = new Student();
				System.out.println("Enter student "+ i++ +" name and email: ");
				String studentName = scn.nextLine();
				while(!Pattern.matches(namePattern, studentName)) {
					System.out.print("Please Enter a Valid Name: ");
					studentName = scn.nextLine();
				}
				String studentMail = scn.nextLine();
				while(!ValidateEmail.validateEmail(studentMail)) {
					System.out.print("Please Enter a Valid Email: ");
					studentMail = scn.nextLine();
				}
				listOfStuds.add(Student.addStudent(studentName,studentMail));
				System.out.println("student is added");
				System.out.print("Do you want to add Student(Y/N): ");
				confirm = scn.next().charAt(0);
				scn.nextLine();
			}else {
				System.out.println("STUD_ID     | STUDENT NAME          | STUDENT EMAIL           | COLLEGE NAME  " );				
				for(Student a:listOfStuds) {
					System.out.println(a);
				}
				return;
			}
		}while(true);
		
	}
	
}
