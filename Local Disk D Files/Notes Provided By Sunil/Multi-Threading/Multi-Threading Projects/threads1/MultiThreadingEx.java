package com.zettamine.java.threads1;

import java.util.ArrayList;
import java.util.List;

public class MultiThreadingEx {

	public static void main(String[] args) {
		List<Employee> empList = EmployeeDAO.getAllEmployees();
		long startTime = System.currentTimeMillis();
		/*
		 * for (Employee emp : empList) { SalaryCalculation salCalcObj = new
		 * SalaryCalculation(emp); salCalcObj.calculateSalary(); }
		 */

		/*
		 * Thread t1 = new SalaryCalculation(empList.get(0)); t1.start();
		 * 
		 * Thread t2 = new SalaryCalculation(empList.get(1)); t2.start();
		 * 
		 * Thread t3 = new SalaryCalculation(empList.get(2)); t3.start();
		 * 
		 * Thread t4 = new SalaryCalculation(empList.get(3)); t4.start();
		 * 
		 * Thread t5 = new SalaryCalculation(empList.get(4)); 
		 * Thread t6 = new SalaryCalculation(empList.get(5)); 
		 * Thread t7 = new SalaryCalculation(empList.get(6)); 
		 * Thread t8 = new SalaryCalculation(empList.get(7)); 
		 * Thread t9 = new SalaryCalculation(empList.get(8)); 
		 * Thread t10 = new SalaryCalculation(empList.get(9));
		 * 
		 * t5.start(); t6.start(); t7.start(); t8.start(); t9.start(); t10.start(); 
		 * try
		 * { t1.join(); t2.join(); t3.join(); t4.join(); t5.join(); t6.join();
		 * t7.join(); t8.join(); t9.join(); t10.join(); } catch (Exception ex) { }
		 */
		List<Thread> threadList = new ArrayList<Thread>();

		for (Employee emp : empList) {
			Thread t = new SalaryCalculation(emp);
			threadList.add(t);
			t.start();
		}

		for (Thread t : threadList) {
			try {
				t.join();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		long endTime = System.currentTimeMillis();
		System.out.println("time taken = " + (endTime - startTime));
	}

}
