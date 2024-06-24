package com.zettamine.aop.aspects;

import org.aspectj.lang.JoinPoint;

public class LoggingAspect {
	
	public void logBeforeMethodCall(JoinPoint joinPoint) {
		System.out.println("exection started of - "+joinPoint.getSignature().getName()+"() - with "+joinPoint.getArgs().length+" parameters");
	}
	
}
