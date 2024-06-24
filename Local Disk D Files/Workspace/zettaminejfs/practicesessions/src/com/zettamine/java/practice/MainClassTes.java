package com.zettamine.java.practice;

import java.util.HashSet;

public class MainClassTes {
	public static void main(String[] args) {
		Student s1 = new Student(1, "jaya");
		Student s2 = new Student(1, "jaya");
		System.out.println(s1.equals(s2));
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
//		System.out.println(s1.hashCode()+", "+s2.hashCode());
//		boolean equals = s1.equals(s2);
//		System.out.println(equals);
//		"jaya".equals(s2);
		
//		String s = new String("jaya");
//		String s = new String("jaya");
//		System.out.println(s==s1);
//		System.out.println(s.equals(s1));
		
		new HashSet<>();
	}
}
