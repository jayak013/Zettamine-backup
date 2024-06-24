package com.zettamine.java.inner;

class Outer1
{
 int count;
 class Inner1
 {
  public void show()
  {
   System.out.println("Inside inner "+(++count));
  } 
 }
}

class InnerClassTest2
{
 public static void main(String[] args)
 {
  Outer1 ot=new Outer1();//enclosing class object
  Outer1.Inner1 in = ot.new Inner1();
  in.show();
 }
}