package com.zettamine.java.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class FITest {
	public static void main(String[] args) {
		
		Test t = (a,b)->a+b;
		
		List<String> asList = Arrays.asList("jaya","krishna","hari","prasad","seethagari");
		System.out.println(asList);
		System.out.println(asList.hashCode());
		
		StringBuffer s = new StringBuffer("jaya");
		
		System.out.println(s.hashCode());
		StringBuffer s1 = s.reverse();
		System.out.println(s1.hashCode());
		
		Collections.sort(asList,(e1,e2)->e1.compareToIgnoreCase(e2));
//		System.out.println(asList.hashCode());
		
	}
}
