package algorithms;

import java.util.ArrayList;
import java.util.List;

public class SimpleSlidingWindow {
	public static List<Integer> simpleSlidingWindow(int k,int[] a) {
		List<Integer> list = new ArrayList<Integer>();
		int value = 0;
		for(int i = 0;i<a.length;i++) {
			if(i<k)
				value+=a[i];
			else if(i>=k) {
				value -= a[i-k];
				value+=a[i];
			}
			if(i>=k-1) list.add(value);
		}
		return list;
	}
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6};
		System.out.println(simpleSlidingWindow(4, a));
	}
}
