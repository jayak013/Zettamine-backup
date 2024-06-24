package com.zettamine.mt;

public class SalaryCalculation extends Thread{
	private Employee emp;
	
	public SalaryCalculation(Employee emp) {
		this.emp = emp;
	}
	
	@Override
	public void run() {
		calcualteSalary();
	}
	
	private void calcualteSalary() {
		try {
			Thread.currentThread().sleep(1000);
		}catch(Exception e) {
			
		}
		emp.setSalary(emp.getNoOfDays()*emp.getWagesPerDay());
		System.out.println(emp);
	}
	
}
