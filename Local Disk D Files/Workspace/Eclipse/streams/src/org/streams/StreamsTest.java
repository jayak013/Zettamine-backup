package org.streams;

import java.util.ArrayList;
import java.util.List;

public class StreamsTest {
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(20);
		list.add(40);
		list.add(50);
		list.add(33);
		list.add(53);
		list.add(37);
		long count = list.stream().filter(e->e%2==0).count();
		System.out.println(count);
	}
	
}
