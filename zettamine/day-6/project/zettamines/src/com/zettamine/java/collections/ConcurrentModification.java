package com.zettamine.java.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

public class ConcurrentModification {

	public static void main(String[] args) {
		//List<Integer> nums = new ArrayList<>(Arrays.asList(10,12,14,16,18));
		List<Integer> nums = new CopyOnWriteArrayList<>(Arrays.asList(10,12,14,16,18));
		Iterator<Integer> it = nums.iterator();
		while(it.hasNext()) {
			Integer n = it.next();
			System.out.println(n);
			nums.add(99);
			try {
				TimeUnit.SECONDS.sleep(3);
			}catch(Exception ex) {
				System.out.println(ex);
			}
		}
	}

}
