package com.zettamine.web;

public class Account {
	int accountNo;
	String name;
	String mobile;
	
	public Account(){}
	
	public Account(int accountNo, String name, String mobile) {
		super();
		this.accountNo = accountNo;
		this.name = name;
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", name=" + name + ", mobile=" + mobile + "]";
	}
	
	
	
}