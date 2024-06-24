package com.zettamine.java.threads;

public class SalaryCalculation extends Thread{
	private Employee emp;

	public SalaryCalculation(Employee emp) {
		super();
		this.emp = emp;
	}
	
	public void run() {
		calculateSalary();
	}

	private void calculateSalary() {
		double sal = emp.getPayPerDay() * emp.getNoOfDays();
		emp.setSalary(sal);
	}
}
