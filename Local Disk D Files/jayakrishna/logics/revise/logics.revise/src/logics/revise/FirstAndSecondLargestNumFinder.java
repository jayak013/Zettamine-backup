package logics.revise;

import java.util.Arrays;

public class FirstAndSecondLargestNumFinder {
	
	public static void main(String[] args) {
//		int[] a = {7,-2,3,4,9,-1,10,11};
//		findFirstAndSecondLargest(a);
		
//		int a[] = {5,3};
//		System.out.println(findWinner(2, a));
	
//		reverseNum(1400);
		
//		int[] a = {1,3,4,7};
//		int[] b = {5,6};
//		System.out.println(Arrays.toString(sumArray(a, b)));
				
	}
	
	public static void findFirstAndSecondLargest(int[] number) {
		
		int firstLargestNumIndex = number[0];
		int secondLargestNumIndex = number[1];
		for(int i = 0;i<number.length;i++) {
			if(firstLargestNumIndex<number[i]) {
				secondLargestNumIndex = firstLargestNumIndex;
				firstLargestNumIndex = number[i];
			}
			else if(secondLargestNumIndex<number[i] && number[i]<firstLargestNumIndex) {
				secondLargestNumIndex = number[i];
			}
		}
		
		System.out.println(firstLargestNumIndex);
		System.out.println(secondLargestNumIndex);
		
		
		for(int i = 0;i<number.length;i++) {
			if(!(number[i]== firstLargestNumIndex || number[i]== secondLargestNumIndex))
				System.out.print(number[i]+" ");
		}
		
	}
	
	public static String findWinner(int n, int[] arr) {
        int maxElem = Integer.MIN_VALUE;
        int minElem = Integer.MAX_VALUE;
        
        // Find the maximum and minimum elements in the array
        for (int i = 0; i < n; i++) {
            if (arr[i] > maxElem) {
                maxElem = arr[i];
            }
            if (arr[i] < minElem) {
                minElem = arr[i];
            }
        }
        
        // Calculate the difference between the maximum and minimum elements
        int difference = maxElem - minElem;
        
        // Determine the winner based on the parity of the difference
        if (difference % 2 == 0) {
            return "Alice";
        } else {
            return "Bob";
        }
    }
	
	public static void reverseNum(Integer num) {
//		int result = 0;
//		int m = 1;
//		while(num>0) {
//			int rem = num%10;
//			result = (result*10)+rem;
//			num/=10;
//		}
//		System.out.println(result);
		
		String str = Integer.toString(num);
		str = new StringBuilder(str).reverse().toString();
		System.out.println(Integer.parseInt(str));
	}
	
	public static int[] sumArray(int a[],int b[]) {
		String s1 = "";
		String s2 = "";
		for(int i =0;i<=a.length || i<=b.length;i++) {
			if(i<a.length) {
				s1+=a[i];
			}
			if(i<b.length) {
				s2+=b[i];
			}
		}
		Integer sum = Integer.valueOf(s1)+Integer.valueOf(s2);
		char[] c = sum.toString().toCharArray();
		int[] result =  new int[sum.toString().length()];
		for(int i= 0;i<c.length;i++) {
			result[i] = c[i]-'0';
		}
		return result;
	}
	
}
