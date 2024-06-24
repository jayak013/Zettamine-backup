package com.intf;

public class ArithmeticOperations {
	
	public static void main(String...args) {
		int a, b, c, res; 	//commandLine Arguments can be used 
							//by running run configuration in options
		a = Integer.parseInt(args[0]);
		b = Integer.parseInt(args[1]);
		c = Integer.parseInt(args[2]);
		
		System.out.println(a + " " + b + " " + c);
		
		CommutativeArithmetic ca = new CommutativeArithmetic();
		
		res = ca.sum(a, b);
		System.out.println("sum of 2 values: "+res);
		
		res = ca.sum(a, b, c);
		System.out.println("sum of 3 values: "+res);
		
		res = ca.product(a, b);
		System.out.println("product of 2 values: "+res);
		
		res = ca.product(a, b, c);
		System.out.println("product of 3 values: "+res);
		
		Multiplication mp = new CommutativeArithmetic();
		res = mp.product(a, b);
		System.out.println(res);
		res = mp.product(a, b, c);
		System.out.println(res);
		boolean value1 = mp.isCommutative();
		System.out.println(value1);
		
		Addition ad = new CommutativeArithmetic();
		res = ad.sum(a, b);
		System.out.println(res);
		res = ad.sum(a, b, c);
		System.out.println(res);
		boolean value2 = ad.isCommutative();
		System.out.println(value2);
	}
}
