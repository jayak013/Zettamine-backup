package test;

public class Test {
	
	public static String extraSpacesRemover(String target) {
		return target.replaceAll("\\s+", " ").trim();
	}
	
	public static void main(String[] args) {
		System.out.println(extraSpacesRemover(" jaya     krishna  "));
	}
	
}