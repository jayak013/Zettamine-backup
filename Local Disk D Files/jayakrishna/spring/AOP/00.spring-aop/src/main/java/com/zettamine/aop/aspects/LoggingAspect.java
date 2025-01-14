package com.zettamine.aop.aspects;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

public class LoggingAspect implements MethodBeforeAdvice, AfterReturningAdvice, ThrowsAdvice, MethodInterceptor {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("Execution Started " + method.getName() + " with " + args.length + " arguments,target = "
				+ target.getClass().getSimpleName());
	}

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("Execution Ended " + method.getName() + " with " + args.length + " arguments and returns - "
				+ returnValue);
	}

	public void afterThrowing(Exception ex) {
		System.out.println("exception fired---> " + ex.toString() + " occured");
	}

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		long startTime = System.currentTimeMillis();
		try {
			Thread.currentThread().sleep(2000);
		} catch (Exception ex) {

		}
		Object returnValue = invocation.proceed();
		long endTime = System.currentTimeMillis();
		long time = endTime - startTime;
		System.out.println("time taken to execute method name " + invocation.getMethod().getName() + " is " + time
				+ " ,return value is " + returnValue);
		return returnValue;
	}
}
