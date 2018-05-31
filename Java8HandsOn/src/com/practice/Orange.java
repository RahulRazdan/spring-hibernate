package com.practice;

import com.pratice.api.Fruit;

public class Orange implements Fruit{

	private final int weight;

	public Orange(int weight) {
		super();
		this.weight = weight;
	}

	public int getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return "Orange [weight=" + weight + "]";
	}
	
}
