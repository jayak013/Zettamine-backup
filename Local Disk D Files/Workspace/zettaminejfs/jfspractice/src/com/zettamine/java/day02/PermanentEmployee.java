package com.zettamine.java.day02;

public class PermanentEmployee extends Employee {
	
	private double basicPay;
	
	public PermanentEmployee(int employeeId, String employeeName,double basicPay) {
		super(employeeId, employeeName);
		this.basicPay = basicPay;
	}


	public void calculateSalary() {
		double pFAmount = getBasicPay()*0.12;
		salary = getBasicPay()-pFAmount;
		setSalary(salary);
	}

	public double getBasicPay() {
		return basicPay;
	}

	public void setBasicSalary(double basicPay) {
		this.basicPay = basicPay;
	}
	
}
