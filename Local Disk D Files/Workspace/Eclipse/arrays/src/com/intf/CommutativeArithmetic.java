package com.intf;

import javax.print.MultiDoc;

public class CommutativeArithmetic implements Addition, Multiplication{

	@Override
	public int product(int arg1, int arg2) {
		return arg1 * arg2;
	}

	@Override
	public int product(int arg1, int arg2, int arg3) {
		return arg1 * arg2 * arg3;
	}

	@Override
	public int sum(int arg1, int arg2) {
		return arg1 + arg2;
	}

	@Override
	public int sum(int arg1, int arg2, int arg3) {
		return arg1 + arg2 + arg3;
	}

}
