package com.zettamine.java.oops;
class Counter{
	//int n = 10;
	static int n = 10;
	void inc() {
		n++;
	}
	{
		System.out.println("initialization block....");
	}
	static {
		System.out.println("inside static block of Counter");
	}
}
public class StaticTest {

	public static void main(String[] args) {
		System.out.println("inside main method");
		Counter obj1;
		
		obj1 = new Counter();
		Counter obj2 = new Counter();
		Counter obj3 = new Counter();
		
		obj1.inc();
		obj2.inc();
		obj3.inc();
		System.out.println(obj1.n);
		System.out.println(obj2.n);
		System.out.println(obj3.n);
		
	}
	static {
		System.out.println("inside static block of StaticTest");
	}
	static {
		System.out.println("inside static block of StaticTest-1");
	}
}
