package com.practice;

public class Dish {
	private final String name;
	private final boolean vegeterian;
	private final Type type;
	private final int calories;

	public enum Type {
		MEAT, FISH, OTHER
	}

	public Dish(String name, boolean vegeterian, Type type, int calories) {
		super();
		this.name = name;
		this.vegeterian = vegeterian;
		this.type = type;
		this.calories = calories;
	}

	public String getName() {
		return name;
	}

	public boolean isVegeterian() {
		return vegeterian;
	}

	public Type getType() {
		return type;
	}

	public int getCalories() {
		return calories;
	}

	@Override
	public String toString() {
		return "Dish [name=" + name + "]";
	}

}
