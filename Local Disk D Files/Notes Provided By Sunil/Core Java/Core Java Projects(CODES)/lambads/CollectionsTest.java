package com.zettamine.java.lambads;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsTest {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("Praveen", "Sanjay", "Arun", "Deepak", "Srinivas", "Bharath", "Praveen");
		System.out.println(names);
		/*
		Collections.sort(names, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				int n = o1.compareTo(o2);
				if(n >= 0)
					return 1;
				else
					return -1;
			}
			
		});
		*/
		
		/*
		Comparator<String> namesComparator = (o1, o2) -> {
			int n = o1.compareTo(o2);
			if(n >= 0)
				return -1;
			else
				return 1;
		};
		*/
		Comparator<String> namesComparator = (o1, o2) -> o2.compareTo(o1);
		
		//Collections.sort(names, namesComparator);
		Collections.sort(names, (o1, o2) -> o2.compareTo(o1));
		System.out.println(names);
	}

}
