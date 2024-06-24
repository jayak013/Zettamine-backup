package org.jfs.util;

public class ExceptionHandling {
	public static void main(String...ZettaMine) {
		Object[] objArray = { 1, "Five", Integer.valueOf("9") };

		try {
			int val = Integer.valueOf(objArray[1].toString());
			System.out.println(val);
		} catch (Exception e) {
			System.out.println(ZettaMine.length);
		}
	}
}
