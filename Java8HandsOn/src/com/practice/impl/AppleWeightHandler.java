package com.practice.impl;

import com.practice.Apple;
import com.pratice.api.AppleHandler;

public class AppleWeightHandler implements AppleHandler {

	@Override
	public void testApple(Apple apple) {
		
		if(apple.getWeight() >= 150)
			System.out.println("This apple is heavy");
		else
			System.out.println("This apple is light");
	}

}
