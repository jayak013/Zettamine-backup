package com.zettamine.java.except;

public class Except6 {

	public static void main(String[] args) {
		MyResource1 rs1 = new MyResource1();
		MyResource2 rs2 = new MyResource2();
		
		try(rs1; rs2){
			rs1.logic();
			rs2.logic();
			
		}catch(Exception ex) {}
		System.out.println("*************************");

	}

}
