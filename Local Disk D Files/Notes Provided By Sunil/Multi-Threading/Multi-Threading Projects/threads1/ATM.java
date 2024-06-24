package com.zettamine.java.threads1;

public class ATM extends Thread {
	private Account acc;

	public ATM(Account acc) {
		super();
		this.acc = acc;
	}
	
	public void run() {
		acc.withdraw(3000);
	}
}
