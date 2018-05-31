package com.practice.spring.model;

import java.util.Arrays;
import java.util.List;
import static org.apache.commons.lang.WordUtils.*;

public enum Toppings {

	PANEER,ONION,CORN;
	public static List<Toppings> asList(){
		Toppings[] all = Toppings.values();
		return Arrays.asList(all);
	}
	
	@Override
	public String toString(){
		return capitalizeFully(name().replace('_', ' '));
	}
}
