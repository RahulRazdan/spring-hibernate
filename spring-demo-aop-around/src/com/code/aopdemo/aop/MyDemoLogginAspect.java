package com.code.aopdemo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLogginAspect extends MyDemoBasicAspect{

	@Around("execution(* findAccounts())")
	public Object afterReturning(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("@@After");
		long start = System.currentTimeMillis();
		Object result = joinPoint.proceed();
		long end = System.currentTimeMillis();
		System.out.println("@After end in "+ (end-start));
		return result;
	}	
	
	
}
