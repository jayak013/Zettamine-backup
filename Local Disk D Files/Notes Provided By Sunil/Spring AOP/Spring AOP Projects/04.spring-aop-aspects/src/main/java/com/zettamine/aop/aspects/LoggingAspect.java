package com.zettamine.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {
	//WHEN - what type of method calls to be intercepted - through pointcut expression
	//@Before("execution(boolean com.zettamine.aop.services.*.*(..))")
	//@Before("execution(* com.zettamine.aop.services.*.*())") //methods without params
	@Before("execution(* com.zettamine.aop.services.*.*(..))") 
	//@Before("execution(* com.zettamine.aop.services.*.generatePdf*(..))")
	public void logBeforeMethodCall(JoinPoint joinPoint) {
		//WHAT -- logic
		System.out.println("Starting Execution of  - \"" + joinPoint.getSignature().getName() + "()\" - with " + joinPoint.getArgs().length + " parameters");
	}
	
	@AfterReturning(pointcut = "execution(* com.zettamine.aop.services.*.*(..))", returning = "returnValue") 
	//@AfterReturning(pointcut = "execution(* com.zettamine.aop.services.*.*Pdf*(..))", returning = "returnValue") 
	public void logAfterSuccessfulMethodCall(JoinPoint joinPoint, Object returnValue) {
		System.out.println("Execution Completed for \"" + joinPoint.getSignature().getName() + "()\" with "+ joinPoint.getArgs().length + " arguments and returns - "+ returnValue);
	}
	
	@After("execution(* com.zettamine.aop.services.*.*(..))")
	public void logAfterMethodCall(JoinPoint joinPoint) {
		System.out.println("After Aspect - \"" + joinPoint.getSignature().getName() +"()\" has executed");
	}	
	
	@AfterThrowing(pointcut = "execution(* com.zettamine.aop.services.*.*(..))", throwing = "ex" )
	public void logMethodCallAfterException(JoinPoint joinPoint, Exception ex) {
		System.out.println(joinPoint.getSignature().getName()+"() fired an exception -> " + ex.toString());
	}
}
