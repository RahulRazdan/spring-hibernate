package com.practice.config;

import java.util.Optional;

import com.practice.Car;
import com.practice.Insurance;
import com.practice.Person;

public class OptionalConfig {

	public static void main(String[] args) {

		Insurance in = new Insurance("ICICI Lombard");
		Car c = new Car(in);
		Person p = new Person(c,23);
		
		Car c2 = new Car(null);
		Person p2 = new Person(c2,50);
		
		Optional<String> name = Optional.of(p).flatMap(Person::getCar).flatMap(Car::getInsurance).map(Insurance::getName);
		System.out.println(name.get());
		name.ifPresent((String input)-> System.out.println(input.equalsIgnoreCase("ICICI")));
		name.ifPresent((String input)-> System.out.println(input.equalsIgnoreCase("ICICI Lombard")));
		System.out.println(name.orElse("NOTHING...."));
		
		System.out.println(Optional.of(p).filter(m -> m.getAge() >= 20).flatMap(Person::getCar).flatMap(Car::getInsurance).map(Insurance::getName).orElse("ELSE"));
		System.out.println(Optional.of(p2).filter(m -> m.getAge() >= 40).flatMap(Person::getCar).flatMap(Car::getInsurance).map(Insurance::getName).orElse("ELSE"));
		
		Optional<String> name2 = Optional.of(p2).flatMap(Person::getCar).flatMap(Car::getInsurance).map(Insurance::getName);
		System.out.println(name2.isPresent());
		System.out.println(name2.orElse("NOTHING"));
		System.out.println(name2.get());
	}
}
