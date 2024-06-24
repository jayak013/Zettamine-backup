package com.zettamine.java.collections.stream;
class Address{
	String Street;
	String city;
	public Address(String street, String city) {
		super();
		Street = street;
		this.city = city;
	}
	@Override
	public String toString() {
		return "Address [Street=" + Street + ", city=" + city + "]";
	}
	
	
}
class Employee implements Cloneable{
	int empno;
	final String name;
	Address addr;
	
	public Employee(int empno, String name, Address addr) {
		super();
		this.empno = empno;
		this.name = name;
		this.addr = addr;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", name=" + name +", Address = "+addr +"]";
	}
	
}
public class Test {

	public static void main(String[] args) throws CloneNotSupportedException {
		Address addr = new Address("Ameerpet", "Hyderabad");
		Employee emp1 = new Employee(101, "Suraj", addr);
		Employee emp2 = (Employee) emp1.clone();
		emp1.addr.city="Vizag";
		System.out.println(emp1);
		System.out.println(emp2);
	}

}
