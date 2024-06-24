package com.zettamine.aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TimerAspect {
	@Around("execution(* com.zettamine.aop.services.ReportGenerator.*(..))")
	public Object findTimeForExecution(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();
		
		Object returnValue = joinPoint.proceed();
		
		long endTime = System.currentTimeMillis();

		long timeTake = endTime - startTime;
		
		System.out.println("time taken to execute \"" + joinPoint.getSignature().getName() + "\" = " + timeTake + " ms ");
		
		return returnValue;
	}

	
}