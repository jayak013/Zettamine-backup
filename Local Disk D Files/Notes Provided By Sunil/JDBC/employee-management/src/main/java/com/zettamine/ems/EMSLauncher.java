package com.zettamine.ems;

import java.util.Scanner;

public class EMSLauncher {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while(true) {
			System.out.println("1. New Employee");
			System.out.println("2. Search Employee");
			System.out.println("3. Update Employee");
			System.out.println("4. Delete Employee");
			System.out.println("5. All Employees");
			System.out.println("6. Exit");
			
			System.out.print("enter an option: ");
			int opt = sc.nextInt();
			
			switch(opt) {
			 case 1:
				 
			}
		} //while
	}
}
