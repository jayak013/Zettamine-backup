import java.util.Scanner;

public class NumberToWord {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("enter a number: ");
		int num = sc.nextInt();
		String numToWord = "";
		int temp = num;
		
		while(num > 0) {
			int rem = num % 10;
			String word = digitToWord(rem);
			numToWord=word + numToWord;
			num = num / 10;
		}
		System.out.println(temp + " in words ----> " + numToWord);
		sc.close();
	}

	private static String digitToWord(int rem) {
		switch(rem) {
		case 0:
			return "ZERO ";
		case 1:
			return "ONE ";
		case 2:
			return "TWO ";	
		case 3:
			return "THREE ";
		case 4:
			return "FOUR ";
		case 5:
			return "FIVE ";	
		case 6:
			return "SIX ";
		case 7:
			return "SEVEN ";
		case 8:
			return "EIGHT ";
		case 9:
			return "NINE ";	
		}
		return "";
	}

}
