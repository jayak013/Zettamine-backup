package com.zettamine.java.wrappers;

public class WrapperTest1 {

	public static void main(String[] args) {
		Integer i1 = new Integer(25);
		Integer i2 = new Integer("25");
		
		Integer i3 = Integer.valueOf(25);
		Integer i4 = Integer.valueOf("25");
		System.out.println(i1 + " | " + i2 + " | " + i3 + " | " + i4);
		
		Character c1 = new Character('A');
		Character c2 = Character.valueOf('A');
		System.out.println(c1 + " | " + c2);
		
		//Integer i5 = new Integer(127);
		//Integer i6 = new Integer(127);
		Integer i5 = Integer.valueOf(128);//127
		Integer i6 = Integer.valueOf(128);//127
		System.out.println(i5 == i6);
		
		//boolean b2 = Boolean.parseBoolean("abc");
		//boolean b2 = Boolean.parseBoolean("1");
		boolean b2 = Boolean.parseBoolean("TrUe");
		System.out.println(b2);
	}

}
