package com.zettamine.java.datetime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class LocalDateTest {

	public static void main(String[] args) {
		LocalDate dt = LocalDate.now(); //Obtains the current date from the system clock in the default time-zone.
		System.out.println(dt);
		
		dt = LocalDate.of(2012, 12, 31);
		System.out.println(dt);
		
		/*
		Date d = new Date();
		System.out.println(d);
		System.out.println(d.getMonth());
		*/
		
		LocalTime time = LocalTime.now();
		System.out.println(time);
	}
}
