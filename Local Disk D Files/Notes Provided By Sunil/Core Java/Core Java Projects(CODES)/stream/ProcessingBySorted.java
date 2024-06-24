package com.zettamine.java.collections.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProcessingBySorted {

	public static void main(String[] args) {
		List<Integer> marks = Arrays.asList(65, 82, 76, 60, 92, 81, 50, 50);
		System.out.println(marks);
		
		List<Integer> marksAsc = marks.stream().sorted().collect(Collectors.toList());
		System.out.println(marksAsc);
		
		List<Integer> marksDesc = marks.stream().sorted((newNum, exNum) -> (exNum - newNum)).collect(Collectors.toList());
		System.out.println(marksDesc);
		
		marksDesc = marks.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(marksDesc);
		
		List<String> names = Arrays.asList("sanjay", "Praveen", "surya", "aravind", "anu", "Bharath", "Aby");
		
		List<String> namesAsc = names.stream().sorted().collect(Collectors.toList());
		System.out.println(namesAsc);
		
		List<String> namesAsc1 = names.stream().sorted((name1, name2) -> name1.compareToIgnoreCase(name2)).collect(Collectors.toList());
		System.out.println(namesAsc1);
	}

}
