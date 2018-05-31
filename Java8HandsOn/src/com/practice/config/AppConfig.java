package com.practice.config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

import com.practice.Apple;
import com.practice.Orange;
import com.practice.SuppliedTestClass;
import com.practice.impl.AppleColorHandler;
import com.practice.impl.AppleWeightHandler;
import com.pratice.api.AppleHandler;
import com.pratice.api.BufferReaderHandler;
import com.pratice.api.Fruit;

public class AppConfig {

	static Map<String,Function<Integer,Fruit>> map = new HashMap<>();
	
	static {
		map.put("apple", Apple::new);
		map.put("orange", Orange::new);
	}
	
	public static Fruit giveMeFruit(String fruit,Integer weight){
		return map.get(fruit.toLowerCase()).apply(weight);
	}
	
	public void test(List<Apple> inventory,AppleHandler appleHandler){
		Supplier<SuppliedTestClass> c1 = SuppliedTestClass::new;
		SuppliedTestClass c2 = c1.get();
		c2.setLastName("testing");
		System.out.println(c2);
		
		for(Apple apple:inventory){
			appleHandler.testApple(apple);
		}
	}
	
	public static String process(BufferReaderHandler reader) throws IOException{
		try(BufferedReader br = new BufferedReader(new FileReader("C:/Users/rahulrazdan/Documents/SDG/401.txt"))){
			return reader.processFile(br);
		}
	}
	public static <T,R> List<R> map(List<T> list,Function<T,R> f){
		List<R> result = new ArrayList<>();
		for(T s : list){
			result.add(f.apply(s));
		}
		return result;
	}
	public static void main(String[] args) throws IOException {
		
		Comparator<Apple> byWeight = (Apple a1,Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
		
		List<Apple> inventory = new ArrayList<>();
		inventory.add(new Apple(100,Apple.COLOR.GREEN,100f));
		inventory.add(new Apple(200,Apple.COLOR.RED,200f));
		inventory.add(new Apple(10,Apple.COLOR.RED,10f));
		inventory.add(new Apple(150,Apple.COLOR.GREEN,150f));
		
		System.out.println(inventory);
		inventory.sort(byWeight);
		System.out.println(inventory);
		
		new AppConfig().test(inventory, new AppleWeightHandler());
		new AppConfig().test(inventory, new AppleColorHandler());
		System.out.println(new AppleColorHandler().filter(inventory, (Apple apple) -> Apple.COLOR.RED.equals(apple.getColor())));
		
		System.out.println(process((BufferedReader br) -> br.readLine()));
		System.out.println(process((BufferedReader br) -> br.readLine() + br.readLine()));
		List<Integer> l = map(Arrays.asList("rahul","razdan","whaaat"),(String s) -> s.length());
		List<Boolean> l2 = map(Arrays.asList("rahul","","whaaat"),String :: isEmpty);
		List<Integer> l3 = map(Arrays.asList("rahul","razdan","whaaat"),String :: length);
		System.out.println(l);
		System.out.println(l2);
		System.out.println(l3);
		
		System.out.println(giveMeFruit("APPLE", 150));
	}
}
