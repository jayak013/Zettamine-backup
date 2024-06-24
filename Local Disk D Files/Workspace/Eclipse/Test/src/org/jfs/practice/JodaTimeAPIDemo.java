package org.jfs.practice;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.Period;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.chrono.IsoEra;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Date;

public class JodaTimeAPIDemo {
	
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
//		Year year = Year.of(2012);
//		Year now = Year.now();
//		System.out.println(now);
//		MonthDay now2 = MonthDay.now();
//		YearMonth now3 = YearMonth.now();
//		Month[] values = Month.values();
//		System.out.println(now3);
		
		LocalDate currDate = LocalDate.now();
		System.out.println(currDate);
		
		System.out.println(LocalDate.of(2021, 010, 28));
		
		
		ZoneId of = ZoneId.of("Europe/Rome");
		System.out.println(LocalTime.now(Clock.system(of)));
		
//		ZoneId.getAvailableZoneIds().forEach(System.out::println);
		
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("d/M/y");
		System.out.println(now.format(ofPattern));
		System.out.println(now);
		
		Period p = Period.between(LocalDate.of(2000, 8, 25), currDate);
		System.out.printf("Age: %d years %d months %d days\n",p.getYears(),p.getMonths(),p.getDays());
		
		LocalDate plus = LocalDate.of(2000, 8, 25).plus(2, ChronoUnit.CENTURIES);
		System.out.println(plus.format(ofPattern));
		
	}
	
}
