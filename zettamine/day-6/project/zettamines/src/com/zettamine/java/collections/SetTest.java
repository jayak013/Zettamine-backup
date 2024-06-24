package com.zettamine.java.collections;

import java.util.HashSet;
import java.util.Set;

public class SetTest {

	public static void main(String[] args) {
		Set<String> names = new HashSet<String>() {{
			add("Praveen");
			add("Sanjay");
			add("Arun");
		}};
		System.out.println(names);
	}

}
