package com.zettamine.services;

import com.zettamine.exceptions.EmptyArrayException;

public class Largest {
	public int findLargest(int[] data) {
		// int lar = 0;
		if (data == null)
			throw new NullPointerException("please pass a non-null array");
		if (data.length == 0)
			throw new EmptyArrayException("please provide an array with content");

		int lar = data[0];
		for (int x : data) {
			if (x > lar) {
				lar = x;
			}
		}
		return lar;
	}
}
