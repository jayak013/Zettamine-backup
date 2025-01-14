package com.zettamine.java.practice;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class ZonedTimeAndDateDemo {
	
	public static void main(String[] args) {
//		ZoneId.getAvailableZoneIds().forEach(System.out::println);
		ZoneId currZone = ZoneId.systemDefault();
		ZoneId customZone = ZoneId.of("Europe/Budapest");
		ZonedDateTime budapestTime = ZonedDateTime.now(customZone);
		DateTimeFormatter pattern = DateTimeFormatter.ofPattern("d/M/y h:m:s.ns");
		String format = pattern.format(budapestTime);
		System.out.println("Custom Date&Time format: "+format);
		System.out.println("Default  Date&Time format: "+budapestTime);
		
		
		LocalDate birthDate = LocalDate.of(2000, 8, 25);
		Period period = Period.between(birthDate, LocalDate.now());
		int years = period.getYears();
		int months = period.getMonths();
		int days = period.getDays();
		System.out.printf("Age : %d years %d months %d days\n",years,months,days);
		System.out.println(period.toTotalMonths()+" Months");
	}
	
	
	
}
