package com.zettamine.mt;

public class GPay extends Thread{
	Account acc;

	public GPay(Account acc) {
		super();
		this.acc = acc;
	}
	
	public void run() {
		acc.deposit(3000);
	}
}