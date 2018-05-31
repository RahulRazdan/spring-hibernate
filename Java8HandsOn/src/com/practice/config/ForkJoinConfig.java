package com.practice.config;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

import com.practice.ForkJoinExample;

public class ForkJoinConfig {

	public static long forkJoinSum(long n) {
		long[] numbers = LongStream.rangeClosed(1, n).toArray();
		ForkJoinTask<Long> task = new ForkJoinExample(numbers);
		return new ForkJoinPool().invoke(task);
	}
	
	public static void main(String[] args) {
		System.out.println(forkJoinSum(6_000_000_0));
	}
}
