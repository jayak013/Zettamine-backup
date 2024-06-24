package com.zettamine.java.oops.bank;

import java.util.Scanner;

public class BankApp {
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		Account acc = null;
		float amt;
		
		while(true) {
			System.out.println("1. Create Account");
			System.out.println("2. Deposit");
			System.out.println("3. Withdraw");
			System.out.println("4. Balance");
			System.out.println("5. Interest Calculation");
			System.out.println("6. Service Charge");
			System.out.println("7. Exit");
			
			System.out.print("\nenter an option: ");
			int opt = sc.nextInt();
			
			switch(opt) {
			case 1:
				if(acc == null) {
					System.out.print("enter a/c type [1.Savings | 2. Current]: ");
					int accType = sc.nextInt();
					
					System.out.print("enter a/c no: ");
					long acno = sc.nextLong();
					sc.nextLine();
					
					System.out.print("enter name: ");
					String name = sc.nextLine();
					
					System.out.print("enter initial deposit: ");
					amt = sc.nextFloat();
					
					if(accType == 1) {
						System.out.print("enter rate of interest: ");
						float roi = sc.nextFloat();
						acc = new SavingsAccount(acno, name, amt, roi);
					}else {
					    acc = new CurrentAccount(acno, name, amt);
					}
					System.out.println("###--- Welcome to State Bank of India ---###");
				}else {
					System.out.println("A/C is already with Us!!!!");
				}
				break;
			case 2:
				if(acc != null) {
					System.out.print("enter an amount to deposit: ");
					amt = sc.nextFloat();
					acc.deposit(amt);
				}else {
					System.err.println("###--- Please open an A/C with us!! ---###");
				}
				break;
			case 3:
				if(acc != null) {
					System.out.print("enter an amount to withdraw: ");
					amt = sc.nextFloat();
					acc.withdraw(amt);
				}else {
					System.err.println("###--- Please open an A/C with us!! ---###");
				}				
				break;
			case 4:
				if(acc != null) {
					acc.getDetails();
				}else {
					System.err.println("###--- Please open an A/C with us!! ---###");
				}				
				break;
			case 5:
				if(acc != null) {
					if(acc instanceof SavingsAccount)
						((SavingsAccount)acc).calculateInterest();
					else
						System.err.println("ERROR----> This A/C is not providing this facility");
				}else {
					System.err.println("###--- Please open an A/C with us!! ---###");
				}				
				break;	
			case 6:
				if(acc != null) {
					if(acc instanceof CurrentAccount)
						((CurrentAccount)acc).serviceCharge();
					else
						System.err.println("ERROR----> This A/C is not providing this facility");
				}else {
					System.err.println("###--- Please open an A/C with us!! ---###");
				}				
				break;							
			case 7:
				System.out.println("Application Designed & Developed by ");
				System.out.println("\t team@zettamine");
				System.exit(0);
				break;
			default:
				System.err.println("@@@--- INVALID OPERATION --- TRY AGAIN ---@@@");
				break;				
			}
			System.out.println();
		} //while
	}

}
