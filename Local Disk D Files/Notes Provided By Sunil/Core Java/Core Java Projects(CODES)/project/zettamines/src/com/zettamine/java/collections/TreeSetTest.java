package com.zettamine.java.collections;

import java.util.HashSet;
import java.util.Set;

public class TreeSetTest {

	public static void main(String[] args) {
		Set<StringBuffer> set = new HashSet<StringBuffer>();
		set.add(new StringBuffer("ABC"));
		set.add(new StringBuffer("ABC"));
		set.add(new StringBuffer("PQR"));
		set.add(new StringBuffer("XYZ"));
		System.out.println(set);
	}

}
