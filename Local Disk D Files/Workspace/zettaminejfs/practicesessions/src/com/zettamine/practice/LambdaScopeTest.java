package com.zettamine.practice;

import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.function.Predicate;

public class LambdaScopeTest {
	
	public static void main(String[] args) {
		
		
		String s1 = "METRO";
		String s2 = "ORTEM";
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
 		int a = 100;
		Predicate<Integer> p = e->{
			//int a = 5;//Lamda Expression does not create any new scope
			return e%a==0;
		};
		
		Predicate<Integer> predicate = new Predicate<Integer>() {

			@Override
			public boolean test(Integer t) {
				int a = 5;
				//creates a new scope for the variable
				return false;
			}
			
		};
		
	}
	
}
