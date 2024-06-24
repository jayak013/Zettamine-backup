package com.zettamine.java.day02;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SavingsAccount extends Account{
	private int interest;

	public SavingsAccount(long acNo, String name, double amount, int interest) {
		super(acNo,name,amount);
		this.interest = interest;
	}

	public double calculateInterest() {
		return getAmount()*12*interest*0.001;
	}

}
