package com.practice.impl;

import com.practice.Apple;
import com.pratice.api.AppleHandler;

public class AppleColorHandler implements AppleHandler {

	@Override
	public void testApple(Apple apple) {
		
		if(apple.getColor().equals(Apple.COLOR.GREEN))
			System.out.println("This is GREEN apple");
		else
			System.out.println("This is RED apple");
	}

}
