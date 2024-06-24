package com.zettamine.aop.aspects;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

public class LoggingAspect implements MethodBeforeAdvice, AfterReturningAdvice {

	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("Starting Execution of \"" + method.getName() + "()\" with " + args.length + " arguments");		
	}

	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("Execution Completed for \""+method.getName() + "()\" with "+ args.length + " arguments and returns - "+ returnValue);		
	}	
}