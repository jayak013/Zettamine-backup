package com.zettamine.java.collections.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProcessingByCollect1 {

	public static void main(String[] args) {
		//to create a new List with all the course names in uppercase
		List<String> courseNames = Arrays.asList("Core Java", "Advanced Java",
										"Spring", "Spring Boot", "Microservices");
		
		Stream<String> cnStream = courseNames.stream();
		//Stream<String> cnStreamUpper = cnStream.map(cn -> {return cn.toUpperCase();});
		//Stream<String> cnStreamUpper = cnStream.map(cn -> cn.toUpperCase());
		//Stream<String> cnStreamUpper = cnStream.map(cn -> cn.toUpperCase()+" - " + cn.length());
		Stream<String> cnStreamUpper = cnStream.map(cn -> String.format("%-18s - %d", cn.toUpperCase(), cn.length()));

		List<String> courseNamesInUpper = cnStreamUpper.collect(Collectors.toList());
		System.out.println(courseNamesInUpper);
		for(String name : courseNamesInUpper) {
			System.out.println(name);
		}
	}

}
