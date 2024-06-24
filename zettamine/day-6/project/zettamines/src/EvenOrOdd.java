import java.util.Scanner;

public class EvenOrOdd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("enter a number: ");
		int num = sc.nextInt();
		
		int n = num & 1;
		if(n == 1)
			System.out.printf("%d is ODD", num);
		else
			System.out.println(num + " is EVEN");
		
		sc.close();
		
		byte b = (byte)1000;
		System.out.println(b);
		
	}

}
