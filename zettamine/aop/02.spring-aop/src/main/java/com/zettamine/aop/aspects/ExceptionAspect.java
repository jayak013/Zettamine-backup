package com.zettamine.aop.aspects;

import org.springframework.aop.ThrowsAdvice;

public class ExceptionAspect implements ThrowsAdvice {

	public void afterThrowing(Exception ex) {
		System.out.println("exception fired ---> " + ex.toString()+" occured");
	}
}