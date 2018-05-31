package com.practice.config;

import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;
import com.practice.Dish;

public class StreamConfig {

	public static void main(String[] args) {
		List<Dish> menu = Arrays.asList(new Dish("pork", false, Dish.Type.MEAT, 800),
				new Dish("beef", false, Dish.Type.MEAT, 700), new Dish("chicken", false, Dish.Type.MEAT, 400),
				new Dish("french fries", true, Dish.Type.OTHER, 530), new Dish("rice", true, Dish.Type.OTHER, 350),
				new Dish("season", true, Dish.Type.OTHER, 120), new Dish("pizza", true, Dish.Type.OTHER, 550),
				new Dish("prawns", false, Dish.Type.FISH, 300), new Dish("salmon", false, Dish.Type.FISH, 450));

		System.out.println(
				menu.stream().filter((m) -> m.getCalories() > 300).map(Dish::getName).limit(5).collect(toList()));

		System.out.println(menu.stream().filter((m) -> {
			System.out.println("filtering ," + m.getName());
			return m.getCalories() > 300;
		}).map(m -> {
			System.out.println("mapping ," + m.getName());
			return m.getName();
		}).limit(5).collect(toList()));

		menu.stream().forEach(System.out::println);
	}
}
