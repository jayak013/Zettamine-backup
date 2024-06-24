package com.zettamine.application;

import java.util.Scanner;

import com.zettamine.util.EncoderAndDecoder;

public class EncodeAndDecodeApp {

	public static void main(String[] args) {
		Scanner scn =  new Scanner(System.in);
		EncoderAndDecoder ed = new EncoderAndDecoder();
		String data = scn.nextLine();
		String encodeData = ed.encodeData(data);
		System.out.println("Encoded data of "+data+" is: "+encodeData);
		System.out.println("Decoded data of "+encodeData+" is: "+ed.decodeData(encodeData));
	}

}
