package com.zettamine.testing.services;

public class Largest {
	public int findLargest(int[] data) {
		int lar = 0;
		for (int x : data) {
			if (x > lar) {
				lar = x;
			}
		}
		return lar;
	}
}
