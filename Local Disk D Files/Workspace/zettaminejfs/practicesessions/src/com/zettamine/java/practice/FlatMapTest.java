package com.zettamine.java.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FlatMapTest {
	static FlatMapTest f;
	public static void main(String[] args) {
		List<Book> list = Arrays.asList(new Book(5,"java"),new Book(1,"java"),new Book(2,"python"),new Book(3,"mysql"));
		List<Book> list1 = Arrays.asList(new Book(1,"copyOfJava"),new Book(1,"java"),new Book(2,"python"),new Book(3,"mysql"));
		List<Book> list2 = Arrays.asList(new Book(1,"copyOfJava"),new Book(1,"java"),new Book(2,"python"),new Book(3,"mysql"));
		List<List<Book>> listOfLists = List.of(list,list1,list2);
		List<String> collect2 = listOfLists.stream().flatMap(e->e.stream().map(j->j.getBookName())).collect(Collectors.toList());
		//FlatMap transformation and flatteringl
		System.out.println(collect2);
		int id = 1;
//		Optional<Book> or = list.stream().filter(e->e.getBookId()==id).skip(6)
//				.findFirst().or(FlatMapTest.f::anEmptyBook );
		Map<String, Long> collect = list.stream().collect(Collectors.groupingBy(e->e.getBookName(),Collectors.counting()));
		System.out.println(collect);
		
		IntSummaryStatistics summaryStatistics = IntStream.range(1, 20).summaryStatistics();
		//summaryStatistics for mathematical calculation predefined
		System.out.println(summaryStatistics.getAverage());
		System.out.println(summaryStatistics.getCount());
		System.out.println(summaryStatistics.getSum());
		System.out.println(summaryStatistics.getMin());
		
		List<Integer> nums = Arrays.asList(11,12,13,14,15,16,17,18,19,20);
		double asDouble = nums.stream().mapToInt(Integer::intValue).average().getAsDouble();
		System.out.println(asDouble);
		
		
		
//		if(or.isPresent()) {
//			System.out.println(or.get());
//		}
	}
	public Optional<Book> anEmptyBook(){
		return Optional.of(new Book());
	}
	public static Optional<Book> anEmptyBook1(){
		return Optional.of(new Book());
	}
}
