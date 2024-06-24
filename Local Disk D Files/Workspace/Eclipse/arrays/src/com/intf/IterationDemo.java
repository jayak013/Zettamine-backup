package com.intf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IterationDemo {
	
	public static void main(String...args) {
		List<String> daysOfWeek = new ArrayList<>();
		daysOfWeek.add("Monday");
		daysOfWeek.add("Tuesday");
		daysOfWeek.add("Wednesday");
		daysOfWeek.add("Thursday");
		daysOfWeek.add("January");
		daysOfWeek.add("Feb");
		daysOfWeek.add("Friday");
		daysOfWeek.add("Saturday");
		daysOfWeek.add("Sunday");
		
		System.out.println(daysOfWeek);
		
		for(int i = 0;i < daysOfWeek.size(); i++ ) {
			if(daysOfWeek.get(i).equals("January")||daysOfWeek.get(i).equals("Feb"))
				daysOfWeek.remove(i);
		}
//		
//		System.out.println(daysOfWeek);
		
//		for(String day : daysOfWeek) {
//			if(day.equals("January"))
//			//daysOfWeek.add("January");
//				daysOfWeek.remove("January");
//			return;
//		}
		
		System.out.println(daysOfWeek);
		
//		Iterator<String> dayIt = daysOfWeek.iterator();
//		
//		while(dayIt.hasNext())
//			if(dayIt.next().equals("January"))
//				dayIt.remove();
//		System.out.println(daysOfWeek);
	}
	
	
}
