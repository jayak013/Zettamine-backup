package com.zettamine.utils;

public class StringUtility {
	public String getMirrorImage(String inputImage) {
		if (inputImage == null)
			throw new NullPointerException("please pass a non-null image");
		if (inputImage.length() <= 0)
			throw new RuntimeException("please pass a noon-empty string image");
		if (inputImage.isBlank())
			throw new RuntimeException("please pass a noon-empty string image");

		String outputImage = null;
		outputImage = inputImage.concat(" || ").concat(new StringBuilder(inputImage).reverse().toString());
		return outputImage;
	}
}
