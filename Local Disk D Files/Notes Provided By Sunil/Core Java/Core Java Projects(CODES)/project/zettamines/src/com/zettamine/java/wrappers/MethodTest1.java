package com.zettamine.java.wrappers;

class MethodTest1
{
 static void method(Number I)
 {
  System.out.println("Integer Wrapper Type");
 }
 
 static void method(Long l) 
 {
  System.out.println("long primitive type");
 }

 
  static void m(int... i){
     System.out.println("Integer...");
  }  
 public static void main(String[] args)
 {
   int n = 12;
   method(n); 
   short s1=30,s2=40;  
   m(s1,s2);
 } 
}