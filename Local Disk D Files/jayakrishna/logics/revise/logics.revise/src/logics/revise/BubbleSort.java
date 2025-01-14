package logics.revise;

import java.util.Arrays;

public class BubbleSort {
	
	public static Integer[] sort(Integer[] array) {
		for(int i = 0;i<array.length-1;i++) {
			for(int j=0;j<array.length-i-1;j++) {
				if(array[j+1]<array[j]) {
					Integer temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
		return array;
	}
	
	public static void main(String[] args) {
		Integer[] array = {64, 34, 25, 12, 22, 11, 90};
		System.out.println(Arrays.toString(sort(array)));
	}
	
}
