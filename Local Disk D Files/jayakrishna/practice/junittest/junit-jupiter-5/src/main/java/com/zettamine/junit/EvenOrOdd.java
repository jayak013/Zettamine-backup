package com.zettamine.junit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class EvenOrOdd {
	
	public String evenOrOdd(Integer num) {
		if(num%2==0) return "even";
		return "odd";
	}
	
	public static void main(String[] args) {		
		
		List<Student> students = new ArrayList<>();
		students.add(new Student("jaya","mech"));
		students.add(new Student("krishna","mech"));
		students.add(new Student("hari","home"));
		students.add(new Student("prasad","home"));
		students.add(new Student("laxmi","home"));
		students.add(new Student("srinu","home"));
		
		System.out.println(students.stream().collect(Collectors.groupingBy(s->s.getDept(),Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).get());
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		for(Entry<Integer,String> s:map.entrySet()) {
			
		}
		Set<Entry<Integer, String>> entrySet = map.entrySet();
	}
	
}
class Student{
	
	private String name;
	private String dept;
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
	public Student(String name, String dept) {
		super();
		this.name = name;
		this.dept = dept;
	}
	
	
}
