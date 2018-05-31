package com.practice;

import java.util.Optional;

public class Person {

	private Optional<Car> car;
	private int age;
	
	public Person(Car car,int age) {
		super();
		this.car = Optional.ofNullable(car);
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public Optional<Car> getCar() {
		return car;
	}
}
