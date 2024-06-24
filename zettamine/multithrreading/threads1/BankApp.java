package com.zettamine.java.threads1;

public class BankApp {

	public static void main(String[] args) {
		Account surajAcc = new Account(7000);
		
		Thread atmThread = new ATM(surajAcc);
		Thread gpThread = new GooglePay(surajAcc);
		
		atmThread.setName("ATM");
		gpThread.setName("G P");
		
		atmThread.start();
		gpThread.start();
	}
}
