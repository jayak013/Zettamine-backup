package com.zettamine.java.collections.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProcessingByCollect {

	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(11,12,13,14,15,16,17,18,20);
		System.out.println("original numbers " + nums);
		
		List<Integer> nums1 = nums.stream().collect(Collectors.toList());
		System.out.println(nums1);
		
		//collect even numbers from nums list - traditional approach
		List<Integer> evenNums = new ArrayList<Integer>();
		for(int num : nums) {
			int rem = num % 2;
			if(rem == 0)
				evenNums.add(num);
		}
		System.out.println("even numbers = " + evenNums);
		
		//collect even numbers from nums list - using stream and anonymous class
		Stream<Integer> numsStream = nums.stream();
		
		Stream<Integer> evenNumsStream = numsStream.filter(new Predicate<Integer>() {
			@Override
			public boolean test(Integer t) {
				return t%2==0;
			}			
		});
		
		evenNums = evenNumsStream.collect(Collectors.toList());
		System.out.println("even numbers = " + evenNums);
		
		//collect even numbers from nums list - using stream and lambdas
		numsStream = nums.stream();
		evenNumsStream = numsStream.filter(t -> t%2==0);
				
		evenNums = evenNumsStream.collect(Collectors.toList());
		System.out.println("even numbers = " + evenNums);
		
		evenNums = nums.stream().filter(n -> n%2==0).collect(Collectors.toList());
		System.out.println("even numbers = " + evenNums);
	}

}
