package com.zettamine.java.threads;

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
