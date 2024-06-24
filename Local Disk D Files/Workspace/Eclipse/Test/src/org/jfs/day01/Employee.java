package org.jfs.day01;

import java.util.Objects;

public class Employee implements Cloneable{
	private int eno;
	private String name;
	private int deptno;
	private Designation desg;
	
	
	public Employee(int eno, String name, int deptno,Designation desg) {
		super();
		this.eno = eno;
		this.name = name;
		this.deptno = deptno;
		this.desg = desg;
	}
	
	//copy constructor
	public Employee(Employee otherObj) {
		this.eno = otherObj.eno;
		this.name = otherObj.name;
		this.deptno = otherObj.deptno;
		this.desg = otherObj.desg;
	}
	

	@Override
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}

	
	@Override
	public String toString() {
		return "Employee [eno=" + eno + ", name=" + name + ", deptno=" + deptno +", desg="+desg+ "]";
	}
	public int geteno() {
		return eno;
	}
	public void seteno(int eno) {
		this.eno = eno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	
	public Designation getDesg() {
		return desg;
	}

	public void setDesg(Designation desg) {
		this.desg = desg;
	}

	@Override
	public int hashCode() {
//		return Objects.hash(deptno, desg, eno, name);
//		return 35;
//		return this.deptno;
//		return this.desg.hashCode();
		if(this.deptno == 10) return -1;
		else if(this.deptno == 20 || this.deptno == 30) return 0;
		else return 1;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass()) {
			return false;
		}
			
		Employee other = (Employee) obj;
		System.out.println("Checking equals for: "+this.eno + " with "+other.eno);
		return deptno == other.deptno && Objects.equals(desg, other.desg) && eno == other.eno && Objects.equals(name, other.name);
	}
	
	
	
}
