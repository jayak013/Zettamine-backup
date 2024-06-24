package com.zettamine.java.inner;
class Outer
{
	static int n = 12;
  static class Inner
  {
	  //static int n = 13;
    public static void area(int x)  
    {
      System.out.println("Area is " + (Math.round(3.14*x*x)));
      System.out.println(n);
    }
  }
}

public class StaticInnerClass {

	public static void main(String[] args) {
		Outer.Inner.area(5);
	}

}
