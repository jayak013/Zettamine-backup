package arrays;

public class VariableArguments {

	public static void main(String...args) {
		display();
		display("Thursday");
		display("Thursday","Friday","Saturday","Sunday");
		
		String[] daysOfweek = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};

		display(daysOfweek);
	}
	
	private static void display(String...values) {
		for(String str:values) {
			System.out.println(str);
		}
		
		System.out.println("~".repeat(20));
	}
	
	private static void display(int i,String...values) {
		for(String str:values) {
			System.out.println(str);
		}
		
		System.out.println("~".repeat(20));
	}

}
