package com.practice.chainofresponsibilty;

import java.util.function.UnaryOperator;

public class TestConfig {

	public static void usingLambda(){
		UnaryOperator<String> headerProcessing = (String text) -> text + " labda labda";
		UnaryOperator<String> spellCheckProcessing = (String text) -> text.replaceAll("labda", "rahul");
		
		System.out.println(headerProcessing.andThen(spellCheckProcessing).apply("Aren't labdas really awesome labdas ? !!"));
	}
	
	public static void main(String[] args) {
		ProcessingObject<String> p1 = new HeaderTextProcessing();
		ProcessingObject<String> p2 = new SpellCheckerProcessing();
		
		p1.setSuccessor(p2);
		
		System.out.println(p1.handle("Aren't labdas really awesome labdas ? !!"));
		
		usingLambda();
		
	}
}
