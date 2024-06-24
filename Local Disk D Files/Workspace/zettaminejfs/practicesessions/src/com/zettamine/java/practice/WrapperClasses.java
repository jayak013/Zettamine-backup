package com.zettamine.java.practice;

public class WrapperClasses {
	
	interface Inner{
		class InnerInterface{
			
		}
	}
	
	public static void main(String[] args) {
		new WrapperClasses.Inner.InnerInterface();
		int i = 10;
		String str = "4980099";
		i = Integer.parseInt(str);
		Integer intObj = Integer.valueOf(i);
		Integer intObj1 = Integer.valueOf(str);
		byte by = intObj.byteValue();
		System.out.println("byte: "+by);
		short sh = intObj.shortValue();
		System.out.println("short: "+sh);
		int in = intObj.intValue();
		System.out.println("int: "+in);
		long lo = intObj.longValue();
		System.out.println("long: "+lo);
		float fl = intObj.floatValue();
		System.out.println("float: "+fl);
		double dou = intObj.doubleValue();
		System.out.println("double: "+dou);
		varArgs();
		varArgs1(new String[1]);
	}
	
	public static void varArgs(String...strings) {
		//requires minimum 0 args
	}
	public static void varArgs1(String[] strings) {
		//requires atleast one arg
	}
	
}
