package com.code.aopdemo.aop;

import org.aspectj.lang.annotation.Pointcut;

public class MyDemoBasicAspect {

	@Pointcut("execution(* add*(..))")
	public void addAccountPointCut() {}
	
	@Pointcut("execution(* get*(..))")
	public void getAccountPointCut() {}
	
	@Pointcut("execution(* set*(..))")
	public void setAccountPointCut() {}
	
	@Pointcut("addAccountPointCut() && !(getAccountPointCut() || setAccountPointCut())")
	public void AccountPointCut() {}
}
