package com.zettamine.testing;

import com.zettamine.testing.services.StringUtility;

public class MirrorImageTest {

	public static void main(String[] args) {
		StringUtility strUtil = new StringUtility();
		// String str = null;
		// String str = "";
		// String str = " ";
		String str = "ZETTA";
		String strImage = strUtil.getMirrorImage(str);
		System.out.println(strImage);

	}

}
