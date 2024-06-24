package com.zettamine.java.datetime;

import java.time.LocalDate;
import java.time.Month;

public class LocalDateMethods {

	public static void main(String[] args) {
		LocalDate dt = LocalDate.now();
		
		System.out.println(dt.getDayOfMonth());
		System.out.println(dt.getMonthValue());
		System.out.println(dt.getDayOfMonth());
		System.out.println(dt.getMonth());//DECEMBER
		System.out.println(dt.getYear());
		System.out.println(dt.getDayOfYear());		
		
		//printing current month name
		Month month = dt.getMonth();
		System.out.println("current month = " + month); //MARCH
		System.out.println(month.getValue());
		//practice rest of the methods
	}

}
