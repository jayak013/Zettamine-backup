package arrays;

import java.util.Arrays;
import java.util.Random;

public class ArrayWithRandomValues {
	
	private static Random random = new Random();
	
	private static int[] getRandomIntArray(int arrayLength, int maxValue) {
		int[] retArr = new int[arrayLength];
		for(int i = 0;i < arrayLength;i++) {
			retArr[i] = random.nextInt(maxValue+1);
		}
		return retArr;
	}
	
	private static int[] getRandomArrayInRange(int arrayLength, int minValue, int maxValue) {
		int[] retArr = new int[arrayLength];
		for(int i = 0;i < arrayLength;i++) {
			retArr[i] = random.nextInt(maxValue + 1 - minValue)+minValue;
		}
		return retArr;
	}
	
	public static void main(String[] args) {
  		int[] arr1 = getRandomIntArray(10, 100);
		System.out.println(Arrays.toString(arr1));
//		Arrays.sort(arr1);
//		System.out.println("After sorting"+ Arrays.toString(arr1));
		
//		int[] arr2 = arr1.clone();
//		arr2[0] = 100;
//		System.out.println(Arrays.toString(arr2));
		
		int[] arr3 = Arrays.copyOf(arr1, arr1.length);//Remeber
		Arrays.sort(arr3);
		System.out.println("After sorting"+ Arrays.toString(arr3));
		System.out.println("!".repeat(20));
		int[] sal = getRandomArrayInRange(10, 10001, 20000);
		System.out.println(Arrays.toString(sal));
	}
	
}
