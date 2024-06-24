
public class FormattedOutput {

	public static void main(String[] args) {
		float sal = 7500.98745f;
		System.out.println(sal);
		System.out.printf("%f\n", sal);
		System.out.printf("%.0f\n", sal);
		System.out.printf("%.1f\n", sal);
		System.out.printf("%.2f\n", sal);
		System.out.printf("%.3f\n", sal);
		System.out.printf("%.4f\n", sal);
		
		int total = 564;
		float avg = ((float)total) / 7;
		System.out.printf("%.2f",avg);
		
		System.out.println("\u001B[34m Zetta Mine Private Limited\u001B[0m");
		System.out.println("\u001B[35m\u001B[40mBegumpet, Hyderabad");
	}

}
