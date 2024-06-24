package com.zettamine.testing.services;

import java.time.LocalDateTime;

public class StringUtility {
	public String getMirrorImage(final String inputImage) throws NullPointerException {
		final String METHOD_NAME = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.println("Method Invoked : " + getClass().getName() + ": " + METHOD_NAME + ": input - " + inputImage
				+ " | " + LocalDateTime.now());

		if (inputImage == null) {
			throw new NullPointerException("please pass a non-null input image");
		} else if (inputImage.isEmpty()) {
			throw new RuntimeException("Please provide a non-empty string");
		}
		String outputImage = "";
		outputImage = inputImage.concat(" || ").concat(new StringBuilder(inputImage).reverse().toString());
		System.out.println("Method Returns : " + getClass().getName() + ": " + METHOD_NAME + ": output - " + outputImage
				+ " | " + LocalDateTime.now());

		return outputImage;
	}
}
