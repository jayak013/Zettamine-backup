package customgenerics;

import java.util.ArrayList;

public class GenericsCheck {

	public static void main(String[] args) {
		GenericsDemo<Integer> a = 
				new GenericsDemo<Integer>();
		System.out.println(a.get(20));
		Integer set = a.set(30);
		System.out.println(set);
		
		ArrayList<Integer> list = 
				new ArrayList<Integer>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		
		Object[] test = a.test(list);
		for (Object integer : test) {
			System.out.println(integer);
		}
	}
	
}
