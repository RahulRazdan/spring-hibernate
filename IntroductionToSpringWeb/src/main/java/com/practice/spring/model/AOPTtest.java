package com.practice.spring.model;

import java.io.PrintStream;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AOPTtest {

	private PrintStream stream;
	
	public AOPTtest(PrintStream stream) {
		this.stream = stream;
	}
	
	@Pointcut("execution(* *.getType(..))")
	public void performance(){}
	
	@Pointcut("execution(* *.getArguementType(..)) && args(parameter)")
	public void arguementAOP(int parameter){}
	
	@Before("performance()")
	public void startAOPConfig(){
		stream.println("startAOPCOnfig");
	}
	
	@After("performance()")
	public void endAOPConfig(){
		stream.println("endAOPConfig");
	}
	
	@Before("arguementAOP(parameter)")
	public void startParameterConfig(int parameter){
		System.out.println("AOP Agrument parameter : " + parameter);
	}
	/*@Around("performance()")
	public void commonAOPConfig(ProceedingJoinPoint jp){
		try{
		stream.println("startAOPCOnfig");
		jp.proceed();
		stream.println("endAOPConfig");
		}catch(Throwable e){
			System.out.println("Exception : " + e);
		}
	}*/
	
}
