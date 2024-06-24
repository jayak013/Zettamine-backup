package logics.revise;

import java.util.Arrays;

public class SortingTechniues {
	
	public static void main(String[] args) {
		int[] a = {4,2,3,1};
//		selectionSort(a);
		insertionSort(a);
		System.out.println(Arrays.toString(a));
	}
	
	public static void selectionSort(int[] a) {
		
		for(int i = 0;i<a.length-1;i++) {
			int index = i;
			for(int j = i+1;j<a.length;j++) {
				if(a[j]<a[index]) index = j;
			}
			if(i!=index) {
				int temp = a[index];
				a[index] = a[i];
				a[i] = temp;
			}
		}
		
	}
	
	public static void insertionSort(int[] a) {
		
		for(int i = 1;i<a.length;i++) {
			int key = a[i];
			int j = i-1;
			while(j>=0 && a[j]>key) {
				a[j+1] = a[j];
				j--;
			}
			a[j+1] = key;
		}
		
	}
	
}
