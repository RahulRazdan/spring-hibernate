package com.code.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CRMLoggingAspect {

	@Pointcut("execution(* com.code.springdemo.controller.*.*(..))")
	private void pointCut() {}
	
	@Pointcut("execution(* com.code.springdemo.service.*.*(..))")
	private void pointCutService() {}
	
	@Pointcut("execution(* com.code.springdemo.dao.*.*(..))")
	private void pointCutDAO() {}

	@Pointcut("pointCut() || pointCutService() || pointCutDAO()")
	private void appFlow() {}
	
	@Before("appFlow()")
	public void before(JoinPoint joinPoint) {
		System.out.println("Method called : " + joinPoint.getSignature());
		Object args[] = joinPoint.getArgs();
		
		if(args!=null) {
			for(Object arg:args) {
				System.out.println("Arguemnt : " + arg);
			}
		}
	}
	
	@AfterReturning(pointcut="appFlow()",returning="results")
	public void afterReturning(JoinPoint joinPoint,Object results) {
		System.out.println("Method called @AfterReturning: " + joinPoint.getSignature());
		System.out.println("Data Returned: @AfterReturning "+results);
	}
}




