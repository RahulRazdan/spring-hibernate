package com.code.aopdemo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyDemoCloudAspect extends MyDemoBasicAspect{

	@Before("AccountPointCut()")
	public void printCloudLogging() {
		System.out.println("This is AspectJ printCloudLogging method.");
	}
}
