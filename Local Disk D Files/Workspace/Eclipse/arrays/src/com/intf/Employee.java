package com.intf;

import java.util.Objects;



public class Employee {

	private int eno;
	private String name;
	private int dno;
	private int salary;
	
	public Employee() {}
	public Employee(int eno, String name, int dno, int salary) {
		super();
		this.eno = eno;
		this.name = name;
		this.dno = dno;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [eno=" + eno + ", name=" + name + ", dno=" + dno + ", salary=" + salary + "]";
	}
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDno() {
		return dno;
	}
	public void setDno(int dno) {
		this.dno = dno;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return dno == other.dno && eno == other.eno && name.equals(other.name) && salary == other.salary;
	}
	
	
}


