package com.zettamine.web.models;

public class Account {
	private Long accountNo;
	private String accountName;
	public Float accountBal;
	
	public Account() {
		super();
		System.out.println("Account || Constructor");
	}

	public Long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public Float getAccountBal() {
		return accountBal;
	}

	public void setAccountBal(Float accountBal) {
		this.accountBal = accountBal;
	}

}
