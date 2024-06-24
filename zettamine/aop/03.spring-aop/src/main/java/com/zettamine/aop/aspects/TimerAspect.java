package com.zettamine.aop.aspects;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class TimerAspect implements MethodInterceptor {

	public Object invoke(MethodInvocation invocation) throws Throwable {
		long startTime = System.currentTimeMillis();
		
		Object returnValue = invocation.proceed();
		
		long endTime = System.currentTimeMillis();

		long timeTake = endTime - startTime;
		
		System.out.println("time taken to execute \"" + invocation.getMethod().getName() + "\" = " + timeTake + " ms , which returns - " + returnValue);
		
		return returnValue;
	}

	
}