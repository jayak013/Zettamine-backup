package com.zettamine.java.oops.bank;

public class SavingsAccount extends Account {
	private float roi;

	public SavingsAccount(Long accountNo, String accountName, Float balance, float roi) {
		super(accountNo, accountName, balance);
		this.roi = roi;
	}
	
	public void calculateInterest() {
		float interest = (this.getBalance() * this.roi)/100;
		this.deposit(interest);
	}
}
