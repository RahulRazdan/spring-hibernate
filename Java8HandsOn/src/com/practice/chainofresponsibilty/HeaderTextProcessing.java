package com.practice.chainofresponsibilty;

public class HeaderTextProcessing extends ProcessingObject<String> {

	@Override
	protected String handleWork(String input) {
		return input + " labda labda";
	}

}
