package com.zettamine.java.collections.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ProcessingByCount {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("sanjay", "Praveen", "surya", "aravind", "anu", "Bharath", "Aby");
		Stream<String> namesStream = names.stream();
		long noOfParticipants = namesStream.count();
		
		System.out.println("no of participants = " + noOfParticipants);
		
		//no of participants whose name length > 5
		noOfParticipants = names.stream().filter(name -> name.length()>5).count();
		System.out.println("no of participants whose name is > 5 chars = " + noOfParticipants);
	}

}
