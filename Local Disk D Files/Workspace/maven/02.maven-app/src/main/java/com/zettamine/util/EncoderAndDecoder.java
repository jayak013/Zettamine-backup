package com.zettamine.util;

import java.util.Base64;

public class EncoderAndDecoder {
	
	public String encodeData(String data) {
		Base64.Encoder e = Base64.getEncoder();
		byte[] b = data.getBytes();
		return e.encodeToString(b);
	}
	
	public String decodeData(String encodedData) {
		Base64.Decoder d = Base64.getDecoder();
		byte[] decodedData = d.decode(encodedData);
		return new String(decodedData);
	}
	
}
