package colllections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class SetDemo {
	
	public static void main(String[] args) {
		
		HashSet<Integer> hSet = new HashSet<>();
		LinkedHashSet<Integer> lHSet = new LinkedHashSet<>();
		TreeSet<Integer> tSet = new TreeSet<>();
		
		hSet.add(45);
		hSet.add(21);
		hSet.add(-4);
		hSet.add(0);
		hSet.add(78);
		hSet.add(99);
		
		lHSet.add(45);
		lHSet.add(21);
		lHSet.add(-4);
		lHSet.add(0);
		lHSet.add(78);
		lHSet.add(99);
		
		tSet.add(45);
		tSet.add(21);
		tSet.add(-4);
		tSet.add(0);
		tSet.add(78);
		tSet.add(99);
		
		System.out.println("HashSet : " + hSet + " -> (Unpredicatable order)");
		System.out.println("LinkedHashSet : " + lHSet + " -> (Insertion order is preserved)");
		System.out.println("TreeSet : " + tSet + " -> (Natural Sorted order)");
		
		SortedSet<Integer> sortedSet = tSet.tailSet(45);
		System.out.println(sortedSet);
		
		NavigableSet<Integer> navigableSet = tSet.tailSet(45, false);
		System.out.println(navigableSet);
		
		
	}
	
}
