package com.zettamine.java.oops.bank;

public class Account {
	private Long accountNo;
	private String accountName;
	private Float balance;

	public Account(Long accountNo, String accountName, Float balance) {
		super();
		this.accountNo = accountNo;
		this.accountName = accountName;
		this.balance = balance;
	}

	public Long getAccountNo() {
		return accountNo;
	}

	public String getAccountName() {
		return accountName;
	}

	public Float getBalance() {
		return balance;
	}

	public void deposit(float amt) {
		this.balance += amt;
		System.out.printf("Rs.%.2f Credited | Balance: %.2f\n", amt, this.balance);
	}

	public void withdraw(float amt) {
		if (this.balance >= amt) {
			this.balance -= amt;
			System.out.printf("%.2f Debited | Balance: %.2f\n", amt, this.balance);
		}else {
			System.err.println("ERROR ---> Insufficient Balance");
		}
	}

	public void getDetails() {
		System.out.printf("A/C NO: %d | NAME: %s | BALANCE: %.2f\n", this.accountNo, this.accountName, this.balance);
	}
}
