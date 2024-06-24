package com.zettamine.java.practice;

public class Outer {
	static int x = 10;
	void display() {
		System.out.println("Outer class display()");
	}
	static class Inner{
		static class InnerInner{
			void innerInner() {
				System.out.println("Inner Inner");
			}
		}
		static void display() {
			System.out.println("Inner class display()");
		}
	}
	public static void main(String[] args) {
//		Outer.Inner.display();
//		new Outer().new Inner().display();
//		new Outer.Inner.InnerInner().innerInner();
		var i = new Car("red", "Hyundai", new Engine(20));
		System.out.println(i.getClass().getSimpleName());
		float f = 23.94875f;
		double ab =123;
		System.out.printf("float value: %.1f.%.2f\n",ab,f);
	}
	public static void localClass() {
		class A{
			public void test() {
				System.out.println("localClass");
				
			}
		}
	}
}
