package com.zettamine.java.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsAPI {
	public static void main(String[] args) {
		List<Integer> listNum = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
//		System.out.println(list);
//		List<Integer> evenNums = list.stream().filter(e->e%2==0).collect(Collectors.toList());
//		List<Integer> multipledNums = list.stream().map(e->e*2).collect(Collectors.toList());
//		long count = list.stream().map(e->e*2).count();
//		long count1 = list.stream().filter(e->e%2==0).count();
//		System.out.println(evenNums);
//		System.out.println(multipledNums);
//		List<String> strList = Arrays.asList("Core Java","Advanced Java",
//				"Spring","Spring Boot","Microservices");
		
//		strList.stream().map(e->
//			String.format("%-15s - %d", e.toString(),e.length())).collect(Collectors.toList()).forEach(System.out::println);
//		long a = 8473927392783L;
//		System.out.printf("%d%n",a);

		List<String> strList = Arrays.asList("Core Java","Advanced Java",
				"Spring","Spring Boot","Microservices");
	}

//from 10 to 20 (20-10)+10
	public static void supplyNums() {
		System.out.println(new Random().nextInt(999999-100000)+100000); 
	}
}
