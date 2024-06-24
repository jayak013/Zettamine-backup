package customgenerics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.Stack;

public class TestCAL {
	
	public static void main(String[] args) {
//		CustomArrayList list = new CustomArrayList();
//		list.add(10);
//		list.add(20);
//		list.add(30);
//		list.add(40);
//		list.add(50);
//		list.add(60);
//		list.add(70);
//		list.add(80);
//		list.add(90);
//		list.add(100);
//		
//		System.out.println(list.size());
//		System.out.println(list);
//		System.out.println("index of 50 is "+list.indexOf(50));
//		System.out.println("~".repeat(30));
//		list.remove(40);
//		System.out.println(list.size());
//		System.out.println(list);
//		System.out.println("~".repeat(30));
//		list.removeAt(2);
//		System.out.println(list.size());
//		System.out.println(list);
//		System.out.println("~".repeat(30));
		
		List<Student> sList = new ArrayList<>();
		Student s1 = new Student(1, "Jaya", 23);
		Student s2 = new Student(2, "Krishna", 22);
		Student s3 = new Student(3, "Seetha", 23);
		Student s4 = new Student(4, "Hari", 20);
		Student s5 = new Student(5, "Priya", 22);
		Student s6 = new Student(6, "Lakshmi", 38);
		
		sList.add(s1);
		sList.add(s2);
		sList.add(s3);
		sList.add(s4);
		sList.add(s5);
		sList.add(s6);
		
		Student[] students = sList.toArray(new Student[0]);
//		for(Student s:students) System.out.println(s);
		LinkedList<Object> linkedList = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		System.out.println(stack.search(2));
		ListIterator<Integer> listIterator = stack.listIterator();
		while(listIterator.hasNext()) System.out.println(listIterator.next());
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		Collection<Integer> values = hashMap.values();
		hashMap.hashCode();
	}
	
}
