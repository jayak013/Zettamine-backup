package com.zettamine.java.oops;
class Student{
	private Integer studentId;
	private String studentName;
	public Student(Integer studentId, String studentName) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
	}
	@Override
	protected void finalize() throws Throwable {
		System.out.println("finalize method...");
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + "]";
	}
	
	
}
public class GCTest {

	public static void main(String[] args) {
		Student st1 = new Student(101, "Ajay");
		Student st2 = new Student(102, "Praveen");
		
		System.out.println(st1);
		System.out.println(st2);
		/*
		st1 = null;
		st2 = null;
		*/
		
		st2 = st1;
		System.out.println(new Student(103, "Ajay"));
		System.gc();
		
	}

}
