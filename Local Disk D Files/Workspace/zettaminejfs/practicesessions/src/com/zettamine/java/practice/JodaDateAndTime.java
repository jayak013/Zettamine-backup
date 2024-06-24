package com.zettamine.java.practice;

import java.text.Format;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;

public class JodaDateAndTime {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println("System Default: "+date);
		LocalDate currDate = LocalDate.now();
		LocalTime currTime = LocalTime.now();
		LocalDateTime currDateTime = LocalDateTime.now();
		System.out.println("Default date and time format: "+currDateTime);
		
		LocalDate customDate = LocalDate.of(2012, 1, 23);
		System.out.println("Printing custome date: "+customDate);
		
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("h:m:s a");
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d.M.y");
		DateTimeFormatter dateAndTimeFormatter = DateTimeFormatter.ofPattern("d.M.y h:m:s.ns a");
		
		LocalDateTime currDateAndTime = LocalDateTime.of(currDate, currTime);
		
		String dateFormat = currDate.format(dateFormatter);
		String timeFormat = currTime.format(timeFormatter);
		String dateAndTimeFormat = currDateAndTime.format(dateAndTimeFormatter);
		System.out.println("custom time format: "+timeFormat);
		System.out.println("custom date format: "+dateFormat);
		System.out.println("custom date&time format: "+dateAndTimeFormat);
		
		LocalDate plus = currDate.plus(100, ChronoUnit.DAYS);
		System.out.println(plus);
		
	}
}
