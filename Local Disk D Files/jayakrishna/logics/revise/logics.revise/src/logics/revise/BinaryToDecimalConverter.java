package logics.revise;

public class BinaryToDecimalConverter {
	
	public static Integer binToDec(Integer number) {
		Integer decimal = 0;
		Integer inc = 0;
		while(number>0) {
			Integer rem = number%10;
			if(rem==1) {
				decimal = decimal + (int)Math.pow(2, inc);
			}
			inc++;
			number /= 10;
		}
		return decimal;
	}
	
	public static void main(String[] args) {
		System.out.println(binToDec(1000));
	}
}
