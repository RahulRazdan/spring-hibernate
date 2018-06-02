package com.code.aopdemo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(21)
public class MyDemoLogginAspect extends MyDemoBasicAspect{

	@Before("AccountPointCut()")
	public void printLogging() {
		System.out.println("This is AspectJ printLogging method.");
	}

	/*@Before("execution(* *(..))")
	public void printLogging() {
		System.out.println("This is AspectJ method.");
	}*/
	
	/*@Before("execution(* add*(com.code.aopdemo.Account))")
	public void printArguement() {
		System.out.println("This is account call with arguement.");
	}
	
	@Before("addAccountPointCut()")
	public void printAnyArguement() {
		System.out.println("This is account call with any arguement.");
	}*/
}
