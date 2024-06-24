package practice.java.jay;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("jaya");
		list.add("krishna");
		String collect = list.stream().collect(Collectors.joining(","));
		System.out.println(collect);
		
	}
	
}
