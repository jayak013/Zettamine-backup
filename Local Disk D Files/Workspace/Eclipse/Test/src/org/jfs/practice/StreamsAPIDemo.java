package org.jfs.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsAPIDemo {
	
	public static void main(String[] args) {
		Map<Integer,String> m = new HashMap<>() {
			{
				put(1,"jaya");
				put(2,"hari");
				put(3,"vishnu");
			}
		};
		
		m.entrySet().stream().filter(e->e.getKey()%2!=0).forEach(e->System.out.println(e));
		
		ArrayList<String> list = new ArrayList<String>() {
			{
				add("jaya");
				add("jaya");
				add("siva");
				add("jaya");
				add("siva");
				add("hari");
				add("kittu");
			}
		};
		
		Map<String, Long> collect = list.stream().collect(Collectors.groupingBy(e->e,Collectors.counting()));
		System.out.println(collect);
		
		Optional<Integer> of = Stream.of(1,2,3,4,5,6).reduce((x,y)-> x+y);
		System.out.println(of.get());
	}
}	
