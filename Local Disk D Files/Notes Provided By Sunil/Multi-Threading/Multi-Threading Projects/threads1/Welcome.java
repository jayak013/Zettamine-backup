package com.zettamine.java.threads1;

public class Welcome {
	public static void main(String[] args) {
		System.out.println("main method starts");
		String inputImage = "Zetta";
		String outputImage = new Welcome().textImage(inputImage);
		System.out.println("output text = " + outputImage);
		System.out.println("main method returns");
	}

	private String textImage(String inputImage) {
		final String METHOD_NAME = "textImage";
		System.out.println(
				"inside class: " + this.getClass().getName() + ": " + METHOD_NAME + " : input - " + inputImage);
		String outputImage = "";
		outputImage = new StringBuilder(inputImage).reverse().toString();
		return outputImage;
	}

}
