package logics.revise;

public class SimpleNumericalLogicalPrograms {
	
	public static void main(String[] args) {
		System.out.println(factorial(4));
	}
	
	public static Integer factorial(Integer number) {
		Integer factorialOfNum = 1;
		while(number>0) {
			factorialOfNum*=number-=1;
			number-=1;
		}
		return factorialOfNum;
	}
	
}
