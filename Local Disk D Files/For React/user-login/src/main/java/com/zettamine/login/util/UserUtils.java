package com.zettamine.login.util;

import java.util.Random;

public class UserUtils {
	
	public static Integer createOTP() {
		String digits = "0123456789";
        int otpLength = 6;

        StringBuilder otp = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < otpLength; i++) {
            int index = random.nextInt(digits.length());
            otp.append(digits.charAt(index));
        }

        return Integer.valueOf(otp.toString());
	}
}
