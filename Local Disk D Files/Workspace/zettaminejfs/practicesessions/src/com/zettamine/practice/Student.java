package com.zettamine.practice;

import java.util.HashSet;
import java.util.Objects;

public class Student {
	
	int id;
	String name;
	int classStudying;
	
	
	public Student(int id, String name, int classStudying) {
		super();
		this.id = id;
		this.name = name;
		this.classStudying = classStudying;
	}


	public static void main(String[] args) {
		HashSet<Student> set = new HashSet<>();
		Student s1 = new Student(1,"ganesh",8);
		Student s2 = new Student(1,"ganesh",8);
		set.add(s1);
		set.add(s2);
		System.out.println("Hash code of s1: "+s1.hashCode());
		System.out.println("Hash code of s2: "+s2.hashCode());
		System.out.println("default equals() check: "+s1.equals(s2));
		System.out.println("Student Objects in set: "+set.size());
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", classStudying=" + classStudying + "]\n";
	}


	@Override
	public int hashCode() {
		if(this.classStudying==8) return 101;
		else if(this.classStudying==9) return 102;
		else return 103;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return classStudying == other.classStudying && 
		id == other.id && Objects.equals(name, other.name);
	}
	
	
	
}
