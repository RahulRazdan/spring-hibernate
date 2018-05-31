package com.practice.impl;

import com.pratice.api.B;
import com.pratice.api.C;

public class DefaultClassTest implements B,C{
	
	@Override
	public void hello() {
		System.out.println("Hi, I'm class DefaultClassTest");
	}
	public static void main(String[] args) {
		new DefaultClassTest().hello();
		
	}
}
