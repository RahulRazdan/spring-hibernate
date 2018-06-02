package com.code.aopdemo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLogginAspect {

	@Before("execution(public void addAccount())")
	public void printLogging() {
		System.out.println("This is AspectJ method.");
	}
	
	@Before("execution(* add*(com.code.aopdemo.Account))")
	public void printArguement() {
		System.out.println("This is account call with arguement.");
	}
	
	@Before("execution(* add*(..))")
	public void printAnyArguement() {
		System.out.println("This is account call with any arguement.");
	}
}
