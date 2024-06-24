package arrays;

import java.util.Random;

public class RandomEx {


	public static void main(String[] args) { 
		Random random = new Random();
		int value = random.nextInt();
		System.out.println("random.nextInt() :"+value);
		System.out.println("~".repeat(20));
		
		for(int i = 1;i<=10;i++) {
			value = random.nextInt(7);
			System.out.println("random.nextInt(6): "+value);
		}
		
		System.out.println("~".repeat(20));
		
		int minValue = 31;
		int maxValue = 60;
		for(int i = 1;i<=10;i++) {
			value = random.nextInt(maxValue + 1 - minValue)+minValue;
			System.out.println("random.nextInt(6): "+value);
		}
		
		System.out.println("~".repeat(20));
	}

}
