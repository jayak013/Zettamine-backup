package com.intf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ArrayListDemo2 {
	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<>();
		
		list1.add(10);
		list1.add(20);
		list1.add(30);
		list1.add(50);
		list1.add(70);
		
//		List<Integer> list2 = new ArrayList<>();
//		
//		list2.add(70);
//		list2.add(50);
//		list2.add(98);
//		
//		list1.retainAll(list2);
//		System.out.println("After using retainAll(): " + list1);
		
		for(int i = 0;i < list1.size();i++) {
			System.out.println(list1.get(i));
		}
		
		System.out.println("~".repeat(30));
		for(Integer i:list1) {
			System.out.println(i);
		}
		
		System.out.println("~".repeat(30));
		Iterator<Integer> iterator = list1.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println("~".repeat(30));
		ListIterator<Integer> listIterator = list1.listIterator();
		while(listIterator.hasNext()) {
			System.out.println(listIterator.next());
		}
		System.out.println("~".repeat(30)+"hds");
		while(listIterator.hasPrevious()) {
			System.out.println(listIterator.previous());
		}
	}
}
