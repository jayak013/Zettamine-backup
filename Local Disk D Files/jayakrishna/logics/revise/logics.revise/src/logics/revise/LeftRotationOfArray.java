package logics.revise;

import java.util.Arrays;

public class LeftRotationOfArray {

	public static void main(String[] args) {
//		Integer a[] = {41,73,89,7,10,1,59,58,84,77,77,97,58,1,86,58,26,10,86,51};
//		System.out.println(Arrays.toString(leftRotation(a, 20, 10)));

//		triPytha1(20);
//		Integer[][] a = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
//		spiralForm(a);
		
//		Integer a[] = {1,3,4,5,2,6};
//		halfAscHalfDesc(a);
		
		int a[] = {4,5,1};
		int b[] = {3,4,5};
		System.out.println(Arrays.toString(findArraySum(a, 3, b, 3)));
	}

	public static Integer[] leftRotation(Integer[] array, Integer n, Integer d) {
		Integer[] result = new Integer[array.length];
		int count = 0;
		for (int i = d; i < array.length; i++) {
			result[count++] = array[i];
		}
		for (int j = 0; j < d; j++) {
			result[count++] = array[j];
		}

		return result;
	}

	public static void triPytha(Integer limit) {
		for (int i = 1; i <= limit; i++) {
			for (int j = 1; j <= i; j++) {
				for (int k = 1; k <= j; k++) {
					int a = j * j;
					int b = k * k;
					int c = i * i;

					if ((a + b) == c)
						System.out.println(k + " " + j + " " + i);
				}
			}
		}
	}

	public static void triPytha1(int limit) {
		for (int m = 1; m * m <= limit; m++) {
			for (int n = m + 1; n * n <= limit; n++) {
				int a = n * n - m * m;
				int b = 2 * n * m;
				int c = n * n + m * m;

				if (c > limit)
					break;

				// Generate multiples of the primitive triplet
				for (int k = 1; k * c <= limit; k++) {
					System.out.println((k * a) + " " + (k * b) + " " + (k * c));
				}
			}
		}
	}

	public static void spiralForm(Integer[][] twoDArray) {
		int i=0,j=0;
		char c = 'r';
		while(true) {
			if(c=='r') {
				System.out.print(twoDArray[i][j++]+" ");
				if(j==twoDArray.length-1) c='d';
			}
			else if(c=='d') {
				System.out.print(twoDArray[i++][j]+" ");
				if(i==twoDArray.length-1) c='l';
			}
			else if(c=='l') {
				System.out.print(twoDArray[i][j--]+" ");
				if(j==twoDArray.length-1) c='u';
			}else if(c=='u') {
				System.out.print(twoDArray[i--][j]+" ");
				if(i==twoDArray.length-1) c='r';
			}
		}
	}
	
	public static void halfAscHalfDesc(Integer[] a) {
		for(int i = 0;i<a.length;i++) {
			if(a.length/2<=i) {
				for(int j = 0;j<a.length/2-1;j++) {
					if(a[j]>a[j+1]) {
						int temp = a[j];
						a[j] = a[j+1];
						a[j+1] = temp;
					}
				}
			}else {
				for(int j = a.length/2;j<a.length-1;j++) {
					if(a[j]<a[j+1]) {
						int temp = a[j];
						a[j] = a[j+1];
						a[j+1] = temp;
					}
				}
			}
		}
		System.out.println(Arrays.toString(a));
	}
	
	public static int[] findArraySum(int[] a, int n, int[] b, int m) {
		// Write your code here.
		String num = "";
		for(int i = 0;i<n;i++){
			num+=a[i];
		}
		Integer firstNum = Integer.valueOf(num);
		num = "";
		for(int i = 0;i<m;i++){
			num+=b[i];
		}
		num = Integer.toString(firstNum + Integer.valueOf(num));
		int[] result = new int[num.length()];
		for(int i = 0;i<num.length();i++){
			result[i] = Integer.valueOf(num.charAt(i)-'0');
		}
		return result;
	}
}
