package com.practice;

import java.util.concurrent.RecursiveTask;

/**
 * The Class ForkJoinExample.
 */
public class ForkJoinExample extends RecursiveTask<Long> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8090069062475900027L;

	/** The numbers. */
	private final long[] numbers;
	
	/** The start. */
	private final int start;
	
	/** The end. */
	private final int end;

	/** The Constant THRESHOLD. */
	public static final long THRESHOLD = 10_000;
	
	/**
	 * Instantiates a new fork join example.
	 *
	 * @param numbers the numbers
	 */
	public ForkJoinExample(long[] numbers) {
		this(numbers,0,numbers.length);
	}

	/**
	 * Instantiates a new fork join example.
	 *
	 * @param numbers the numbers
	 * @param start the start
	 * @param end the end
	 */
	public ForkJoinExample(long[] numbers, int start, int end) {
		super();
		this.numbers = numbers;
		this.start = start;
		this.end = end;
	}

	/**
	 * Gets the numbers.
	 *
	 * @return the numbers
	 */
	public long[] getNumbers() {
		return numbers;
	}

	/**
	 * Gets the start.
	 *
	 * @return the start
	 */
	public int getStart() {
		return start;
	}

	/**
	 * Gets the end.
	 *
	 * @return the end
	 */
	public int getEnd() {
		return end;
	}

	/* (non-Javadoc)
	 * @see java.util.concurrent.RecursiveTask#compute()
	 */
	@Override
	protected Long compute() {
		
		int length = end-start;
		
		if(length <=THRESHOLD)
			return computeSequentially();
		
		ForkJoinExample leftTask = new ForkJoinExample(numbers, start, start + length/2);
		leftTask.fork();
		
		ForkJoinExample rightTask = new ForkJoinExample(numbers, start + length/2, end);
		
		long rightResult = rightTask.compute();
		long leftResult = leftTask.join();
		
		return leftResult + rightResult; 
		
	}

	/**
	 * Compute sequentially.
	 *
	 * @return the long
	 */
	private long computeSequentially(){
		long sum=0;
		for(int i= start;i<end;i++){
			sum+=numbers[i];
		}
		return sum;
	}
}
