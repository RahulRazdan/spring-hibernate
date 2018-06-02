package com.code.aopdemo.aop;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.code.aopdemo.Account;

@Aspect
@Component
@Order(21)
public class MyDemoLogginAspect extends MyDemoBasicAspect{

	@AfterReturning(pointcut="execution(* findAccounts())",returning="results")
	public void afterReturning(JoinPoint joinpoint,List<Account> results) {
		System.out.println("After Returning");
		System.out.println("results --> " + results);
		if(results!=null) {
			Account account = results.get(0);
			account.setName("ChangedName");
		}
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
