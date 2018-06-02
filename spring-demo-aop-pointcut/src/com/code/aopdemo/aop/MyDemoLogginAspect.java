package com.code.aopdemo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLogginAspect {

	@Pointcut("execution(* add*(..))")
	private void addAccountPointCut() {}
	
	@Pointcut("execution(* get*(..))")
	private void getAccountPointCut() {}
	
	@Pointcut("execution(* set*(..))")
	private void setAccountPointCut() {}
	
	@Pointcut("addAccountPointCut() && !(getAccountPointCut() || setAccountPointCut())")
	private void AccountPointCut() {}
	
	@Before("AccountPointCut()")
	public void printLogging() {
		System.out.println("This is AspectJ method.");
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
