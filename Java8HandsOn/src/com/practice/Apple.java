package com.practice;

import com.pratice.api.Fruit;

public class Apple implements Fruit{

	public enum COLOR {
		GREEN,
		RED
	};
	
	private final Integer weight;
	private COLOR color;
	private float price;
	
	public Apple(Integer weight, COLOR color, float price) {
		super();
		this.weight = weight;
		this.color = color;
		this.price = price;
	}
	
	public Apple(Integer weight) {
		super();
		this.weight = weight;
	}

	public Integer getWeight() {
		return weight;
	}
	public COLOR getColor() {
		return color;
	}
	public float getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Apple [weight=" + weight + ", color=" + color + ", price=" + price + "]";
	}
	
}
