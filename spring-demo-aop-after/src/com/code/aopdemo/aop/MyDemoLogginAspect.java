package com.code.aopdemo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.code.aopdemo.Account;

@Aspect
@Component
public class MyDemoLogginAspect extends MyDemoBasicAspect{

	@After("execution(* findAccounts())")
	public void afterReturning(JoinPoint joinpoint) {
		System.out.println("@@After");
		
	}
	
	@Before("AccountPointCut()")
	public void printLogging(JoinPoint joinpoint) {
		System.out.println("This is AspectJ printLogging method.");
		MethodSignature signature = (MethodSignature)joinpoint.getSignature();
		System.out.println("Method Signature: --> "+signature);
		
		Object[] args = joinpoint.getArgs();
		for(Object arg : args) {
			System.out.println("Arguement--> " + arg);
			if(arg instanceof Account)
				System.out.println("Account Level --> "+((Account) arg).getLevel());
		}
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
