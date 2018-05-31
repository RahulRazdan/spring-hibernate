package com.practice;

import java.util.Optional;

public class Car {

	private Optional<Insurance> insurance;

	public Car(Insurance insurance) {
		super();
		this.insurance = Optional.ofNullable(insurance);
	}

	public Optional<Insurance> getInsurance() {
		return insurance;
	}
}
