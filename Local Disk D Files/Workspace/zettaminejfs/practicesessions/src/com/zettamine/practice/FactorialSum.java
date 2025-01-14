package com.zettamine.practice;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FactorialSum {
	
	public static void main(String[] args) {
		
		List<Integer> listOfNums = Arrays.asList(4,3,2,13,11,21,4,4,4,2,2,6);
		
		ArrayList<Integer> aL1 = new ArrayList<Integer>() {
			{
				{
					add(1);
					add(2);
					add(3);
					add(4);
				}
			}
			
		};
		
		ArrayList<Integer> aL2 = new ArrayList<Integer>() {
			{
				add(10);
				add(20);
				add(30);
				add(40);
			}
			
		};
		ArrayList<Integer> aL3 = new ArrayList<Integer>() {
			{
				{
					add(100);
					add(200);
					add(300);
					add(400);
				}
			}
			
		};
		
		List<ArrayList<Integer>> of = List.of(aL1, aL2, aL3);
		
		int sum = listOfNums.stream().distinct().
		filter(e->e%2==0).map(Factorial::factorial).reduce(0, (x,n)->x+n);
		
		System.out.println(of);
		List<Integer> collect = of.stream().flatMap(list->list.stream().map(s->s+1)).collect(Collectors.toList());
		
		System.out.println(collect);
		System.out.println(sum);
		
		
	}
	
}
class Factorial{
	public static int factorial(Integer n) {
		if(n==0) return 1;
		return n*factorial(n-1);
	}
	public static int test() {
		return 1;
	}
}
