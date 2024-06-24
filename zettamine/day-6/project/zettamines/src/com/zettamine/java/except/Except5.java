package com.zettamine.java.except;

import java.io.Closeable;
import java.io.IOException;

class MyResource1 implements Closeable{
	public MyResource1() {
		System.out.println("MyResource1 constructor");
	}
	@Override
	public void close() throws IOException {
		System.out.println("MyResource1 closing....");
	}
	
	public void logic() {
		System.out.println("MyResource1 logic");
	}
}

class MyResource2 implements AutoCloseable{
	public MyResource2() {
		System.out.println("MyResource2 constructor");
	}
	@Override
	public void close() throws IOException {
		System.out.println("MyResource2 closing....");
	}
	public void logic() {
		System.out.println("MyResource2 logic");
	}	
}
public class Except5 {

	public static void main(String[] args)throws Exception  {
		try(MyResource1 rs1 = new MyResource1(); MyResource2 rs2 = new MyResource2()){
			rs1.logic();
			rs2.logic();
		}
		System.out.println("*************************");
	}

}
