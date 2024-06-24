package com.zettamine.java.threads1;

public class GooglePay extends Thread {
	private Account acc;

	public GooglePay(Account acc) {
		super();
		this.acc = acc;
	}
	
	public void run() {
		acc.deposit(10000);
	}
}
