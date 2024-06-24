package com.zettamine.web.dto;

import java.math.BigDecimal;

public class Employee {
	public int empno;
	public String ename;
	public Double sal;
	
	public Employee(int empno, String ename, Double sal) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.sal = sal;
	}
	
	public Employee() {}
}
