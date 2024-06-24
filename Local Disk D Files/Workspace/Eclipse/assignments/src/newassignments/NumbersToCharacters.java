package newassignments;

import java.util.Scanner;

public class NumbersToCharacters {
	
	static Scanner scn = new Scanner(System.in);
	
	public static void main(String[] args) {
		numToChar();
	}
	
	private static void numToChar() {
		System.out.print("Enter the first number: ");
		int firstNum = scn.nextInt();
		System.out.print("Enter the second number: ");
		int secondNum = scn.nextInt();
		System.out.print("Enter the third number: ");
		int thirdNum = scn.nextInt();
		System.out.print("Enter the fourth number: ");
		int fourthNum = scn.nextInt();
		System.out.println(firstNum + "-" + (char)firstNum);
		System.out.println(secondNum + "-" + (char)secondNum);
		System.out.println(thirdNum + "-" + (char)thirdNum);
		System.out.println(fourthNum + "-" + (char)fourthNum);
	}
	
}
