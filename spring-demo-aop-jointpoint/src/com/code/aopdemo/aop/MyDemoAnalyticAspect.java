package com.code.aopdemo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(101)
public class MyDemoAnalyticAspect extends MyDemoBasicAspect {

	@Before("AccountPointCut()")
	public void printAnalyticLogging() {
		System.out.println("This is AspectJ printAnalyticLogging method.");
	}
	
}
