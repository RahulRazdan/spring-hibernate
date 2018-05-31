package com.practice;

/**
 * The Class WordCounter.
 */
public class WordCounter {

	/** The counter. */
	private final int counter;
	
	/** The last space. */
	private final boolean lastSpace;
	
	/**
	 * Instantiates a new word counter.
	 *
	 * @param counter the counter
	 * @param lastSpace the last space
	 */
	public WordCounter(int counter, boolean lastSpace) {
		super();
		this.counter = counter;
		this.lastSpace = lastSpace;
	}

	/**
	 * Accumulate.
	 *
	 * @param c the c
	 * @return the word counter
	 */
	public WordCounter accumulate(Character c){
		if(Character.isWhitespace(c)){
			return lastSpace ? this : new WordCounter(counter,true);
		}else {
			return lastSpace ? new WordCounter(counter+1,false) : this;
		}
	}
	
	/**
	 * Combine.
	 *
	 * @param wordCounter the word counter
	 * @return the word counter
	 */
	public WordCounter combine(WordCounter wordCounter) {
		return new WordCounter(counter + wordCounter.counter,wordCounter.lastSpace);
	}
	
	/**
	 * Gets the counter.
	 *
	 * @return the counter
	 */
	public int getCounter() {
		return counter;
	}
	
}
