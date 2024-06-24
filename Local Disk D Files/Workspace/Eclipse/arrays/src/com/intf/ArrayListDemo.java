package com.intf;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ArrayListDemo {

	public static void main(String[] args) {
		
		List<Integer> list1 = new ArrayList<>();
		list1.add(10);
		list1.add(22);
		list1.add(47);
		list1.add(-5);
		
		System.out.println("List1: " + list1);
		System.out.println("~".repeat(30));
		
		List<Integer> list2 = new ArrayList<>(list1);
		System.out.println("List2: " + list2);
		
		list2.add(2, 33);
		System.out.println("List2: " + list2);
		
		list2.addAll(list1);
		System.out.println("List2: " + list2);
		
		list2.addAll(2, list1);
		System.out.println("List2: " + list2);
		System.out.println("size before using clear: "+list2.size());
		
		list2.set(2,99);
		System.out.println("size before using remove: "+list2.size());
		System.out.println("List2: " + list2);
		
		list2.remove(Integer.valueOf(-5));
		System.out.println("size after using remove: "+list2.size());
		System.out.println("List2: " + list2);
		
		list2.removeIf((e)->(e%2==0)); 
//		ArrayListDemo arrayListDemo = new ArrayListDemo();
//		list2.removeIf(arrayListDemo::isEven);
		System.out.println("After predicate: " + list2);
	}
	public boolean isEven(double i) {
		return i%2==0;
	}

}
