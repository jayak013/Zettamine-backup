package com.zettamine.java.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(10,20,30,40,50);
		
		System.out.println(nums);
		Enumeration<Integer> en = Collections.enumeration(nums);
		while(en.hasMoreElements()) {
			System.out.print(en.nextElement() + " | ");
		}
		System.out.println("\n");
		
		//nums.forEach(System.out::println);
		nums.forEach(n -> System.out.print(n + " | "));
		
		nums.stream().forEach(System.out::print);
	}

}
