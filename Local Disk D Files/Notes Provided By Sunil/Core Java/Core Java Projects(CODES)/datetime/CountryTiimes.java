package com.zettamine.java.datetime;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class CountryTiimes {

	public static void main(String[] args) {
		//ZoneId zone = ZoneId.of("America/New_York");
		//ZoneId zone = ZoneId.of("America/Los_Angeles");
		//ZoneId zone = ZoneId.of("America/Chicago");
		//ZoneId zone = ZoneId.of("Europe/Berlin");
		ZoneId zone = ZoneId.of("Europe/London");
		ZonedDateTime zdt = ZonedDateTime.now(zone);
		System.out.println(zdt);
	}

}
