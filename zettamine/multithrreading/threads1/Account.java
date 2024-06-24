package com.zettamine.java.threads1;

public class Account {
	private Integer bal;

	public Account(Integer bal) {
		super();
		this.bal = bal;
	}
	
	synchronized public void withdraw(int amt) {
		this.bal -= amt;
		System.out.println("Rs."+amt+" Debited | Balance: " + this.bal);
	}
	
	synchronized public void deposit(int amt) {
		this.bal += amt;
		System.out.println("Rs."+amt+" Credited | Balance: " + this.bal);
	}
}
