package com.zettamine.java.practice;

import java.util.function.BiPredicate;

public class ConsumerTest {
	
	public static void main(String[] args) {
		BiPredicate<Integer,String> bP = (e1,e2)-> {
			return e1==e2.length();
		};
	}
	
}
