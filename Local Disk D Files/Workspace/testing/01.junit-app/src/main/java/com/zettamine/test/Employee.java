package com.zettamine.test;

import java.util.Objects;

public class Employee {

	private String name;
	private String dept;
	public Employee(String name, String dept) {
		super();
		this.name = name;
		this.dept = dept;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	@Override
	public int hashCode() {
		return Objects.hash(dept,name);
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
		return Objects.equals(dept, other.dept) && Objects.equals(name, other.name);
	}
	/*
	 * @Override public String toString() { return "Employee [name=" + name +
	 * ", dept=" + dept + "]"; }
	 */
	
	
	

}
