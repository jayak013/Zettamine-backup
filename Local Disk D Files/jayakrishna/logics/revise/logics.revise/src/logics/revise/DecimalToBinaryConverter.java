package logics.revise;

public class DecimalToBinaryConverter {
	
	public static Integer decToBin(Integer number){
		String binary = "";
		while(number>0) {
			Integer rem = number%2;
			binary = rem+binary;
			number = number/2;
		}
		return Integer.valueOf(binary);
	}
	
	public static void main(String[] args) {
		System.out.println(decToBin(8));
	}
	
}
