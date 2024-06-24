package com.zettamine.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

public class LoggingAspect {
	public void logBeforeMethodCall(JoinPoint joinPoint) {
		System.out.println("Starting Execution of  - \"" + joinPoint.getSignature().getName() + "()\" - with " + joinPoint.getArgs().length + " parameters");
	}
}
