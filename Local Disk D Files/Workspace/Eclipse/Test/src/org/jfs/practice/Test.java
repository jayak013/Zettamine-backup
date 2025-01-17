package org.jfs.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Test {
	String ns = "jay";
	public static <T> void main(String[] args) {
		
		int a = 100;
		Function<String, Integer> function = new Function<String, Integer>() {
			int a = 10;

			@Override
			public Integer apply(String t) {
				this.a = 43;
				int a = 4;
				return t.length();
			}
			
		};
		System.out.println(function.apply("jaya krishna"));
		
		Function<String,Integer> f = e->{
			String ns = "jd";
			System.out.println("ns length "+ns.length());
			return a*e.length();
		};
		System.out.println(f.apply("jaya krishna"));
		
		   Predicate<String> p = new Predicate<>() {

			@Override
			public boolean test(String t) {
				
				return t.length()%2 == 0;
				
				
			}
			   
			   
		};
		System.out.println(p.test("mallesh"));
		
		Predicate<String> p1 = n-> n.length()%2 == 0;
		System.out.println(p1.test("mallesh"));
		
		
		BiConsumer<Integer, String> biConsumer = new BiConsumer<Integer, String>() {

			@Override
			public void accept(Integer t, String u) {
				System.out.println(t.intValue());
				System.out.println(u.length());
			}
			
		};
		
		
		biConsumer.accept(23, "Jaya");
		
		BiConsumer<Integer, String> b = (s,n)-> System.out.println(s + n.length());
		b.accept(20, "malleh");
		
		List<Integer> l = Arrays.asList(12,13,14,70,1);
		
		Optional<Integer> min = l.stream().max((o1, o2) -> o2 - o1);
		System.out.println(min.get());
						
		
						
						
		
	}
	
	

	
}
