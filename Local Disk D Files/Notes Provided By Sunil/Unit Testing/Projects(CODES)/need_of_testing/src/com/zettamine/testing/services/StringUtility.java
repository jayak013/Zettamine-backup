package com.zettamine.testing.services;

import java.time.LocalDateTime;

public class StringUtility {
	public String getMirrorImage(final String inputImage) throws NullPointerException {
		final String METHOD_NAME = "getMirrorImage()";
		System.out.println("Method Invoked : " + getClass().getName() + ": " + METHOD_NAME + ": input - " + inputImage
				+ " | " + LocalDateTime.now());
		if (inputImage == null)
			throw new NullPointerException("input string shuld not be null");
		else if (inputImage.trim().length() <= 0)
			throw new RuntimeException("empty image is passed");

		String inputImage1 = inputImage.trim();
		String outputImage = "";
		outputImage = inputImage1.concat(" || ").concat(new StringBuilder(inputImage1).reverse().toString());
		System.out.println("Method Returns : " + getClass().getName() + ": " + METHOD_NAME + ": output - " + outputImage
				+ " | " + LocalDateTime.now());
		System.out.println("method name - " + new Object() {
		}.getClass().getEnclosingMethod().getName());
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		return outputImage;
	}
}
