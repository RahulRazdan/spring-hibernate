package com.pratice.api;

public interface B extends A{

	default public void hello(){
		System.out.println("Hi I'm class B");
	}
}
