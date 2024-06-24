package com.zettamine.utils;

public class EvenOrOdd {
	
	public String checkEvenOrOdd(Integer num) {
		if(num==null) throw new NullPointerException();
		if(num%2==0) return "EVEN";
		return "ODD";
	}
	
}
