package com.practice.config;

import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import com.practice.WordCounter;
import com.practice.impl.WordCounterSpliterator;

public class SpliteratorConfig {

	private static String SENTENCE = "rahul razdan and we all see that dark yellow sunset it feels like time has stopped.. we could not take our eyes off"
			+ "world never felt that beautiful before.. and that is why i love morning so much :) ";
	
	private static int countWords(Stream<Character> stream){
		 return stream.reduce(new WordCounter(0,true),WordCounter::accumulate,WordCounter::combine).getCounter();
	}
	
	public static void main(String[] args) {
		
		Stream<Character> stream = IntStream.rangeClosed(0, SENTENCE.length()-1).mapToObj(SENTENCE::charAt);
		System.out.println("Found " + countWords(stream) + " words" );
		
		stream = IntStream.rangeClosed(0, SENTENCE.length()-1).mapToObj(SENTENCE::charAt);
		System.out.println("Found " + countWords(stream.parallel()) + " words" );
		
		stream = StreamSupport.stream(new WordCounterSpliterator(SENTENCE), true);
		System.out.println("Found " + countWords(stream.parallel()) + " words" );
	}
}
