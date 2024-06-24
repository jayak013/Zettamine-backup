package arrays;

public class LogicalOperators {

	public static void main(String[] args) {
		if(isEven(22) & isEven(44)) System.out.println("Both values are even");
		else System.out.println("condition not satisfied");
	}
	public static boolean isEven(int val) {
		return val%2 == 0;
	}
}
