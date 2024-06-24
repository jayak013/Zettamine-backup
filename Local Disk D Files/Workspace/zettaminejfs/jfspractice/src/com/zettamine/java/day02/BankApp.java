package com.zettamine.java.day02;

import java.util.Scanner;

public class BankApp {
	static Scanner scn = new Scanner(System.in);
	public static void main(String[] args) {
		
		Account acc = null;
		
		while(true) {
			System.out.print("1. Create Account\n"
					+ "2. Deposit\n"
					+ "3. Withdraw\n"
					+ "4. AccountDetails\n"
					+ "5. Interest Amount\n"
					+ "6. Service Charges\n"
					+ "7. Exit\n"
					+ "Please Enter your input: ");
			int input = scn.nextInt();
			scn.nextLine();
			if(input>=1 && input<=7) {
				
				switch(input) {
					case 1:
						if(acc!=null) {
							System.out.println("You have already Created your Bank Account");
						}
						while(acc==null) {
							System.out.print( "1. Savings Account\n"
											+ "2. Current Account\n"
											+ "Enter your input: ");
							int accType = scn.nextInt();
							scn.nextLine();
							if(accType==1 || accType==2) {
								System.out.print("Enter Account number: ");
								long acNo = scn.nextLong();
								scn.nextLine();
								System.out.print("Enter the Account holder name: ");
								String name = scn.nextLine();
								System.out.print("Enter initial Deposit amount: ");
								double iniDep = scn.nextDouble();
								scn.nextLine();
								acc = createAccount(accType, acNo, name, iniDep);
								System.out.println("---Welcome to our Bank---");
								if(acc!=null) {
									break;
								}
							}else {
								System.out.println("Please enter a valid input");
							}
						} //inner while loop
						break;
					case 2:
						if(acc==null) {
							System.out.println("Please open an Account with us");
						}else {
							System.out.print("Enter the amount to deposit: ");
							double depositedAmount = scn.nextDouble();
							if(depositedAmount<=0) {
								System.out.println("---Not a valid Amount---");
								break;
							}
							double totalAmount = acc.Deposit(depositedAmount);
							System.out.println("DepositedAmount : "+depositedAmount+"/-\nTotal Balance : "+totalAmount+"/-");
							acc.setAmount(totalAmount);
						}
						break;
					case 3:
						if(acc==null) {
							System.out.println("Please open an Account with us");
						}else {
							System.out.print("Enter the amount to withdraw: ");
							double withDrawAmount = scn.nextDouble();
							if(withDrawAmount>acc.getAmount()) {
								System.out.println("Error--> Insufficient Balance");
								break;
							}
							if(withDrawAmount<=0) {
								System.out.println("---Not a valid Amount---");
								break;
							}
							double totalAmount = acc.withdraw(withDrawAmount);
							System.out.println("Withdrawn Amount : "+withDrawAmount+"/-\nTotal Balance : "+totalAmount+"/-");
							acc.setAmount(totalAmount);
						}
						break;
					case 4:
						if(acc==null) {
							System.out.println("Please open an Account with us");
						}else {
							System.out.println(acc.details());;
						}
						break;
					case 5:
						if(acc==null) {
							System.out.println("Please open an Account with us");
						}else {
							if(acc instanceof SavingsAccount) {
								System.out.println("Yearly Based Interest is: "+((SavingsAccount)acc).calculateInterest());
							}
							else {
								System.out.println("This Account does not support this.");
							}
						}
						break;
					case 6:
						if(acc==null) {
							System.out.println("Please open an Account with us");
						}else {
							if(acc instanceof CurrentAccount) {
								System.out.println("Current Account Service "
										+ "Charges: "
										+((CurrentAccount)acc).serviceCharges()+
										"/-");
							}
							else {
								System.out.println("This Account does not support this.");
							}
						}
						break;
					case 7:
						System.out.println("---BYE BYE---");
						System.exit(0);
				}
				
			}else {
				System.err.println("Invalid Operation Please Try Again");
				try {
					Thread.currentThread().sleep(2000);//for better viewing in console
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private static Account createAccount(int input,long acNo,String name,double iniDep) {
		if(input==1) {
			System.out.print("Enter the Rate Of Interest: ");
			int interest = scn.nextInt();
			return new SavingsAccount(acNo, name, iniDep, interest);
		}else {
			return new CurrentAccount(acNo, name, iniDep);
		}
	}
	
	
}
