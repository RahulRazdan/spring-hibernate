package com.practice;

public class Transaction {

	private final Trader trader;
	private final int year;
	private final int value;
	private final boolean success;
	
	public Transaction(Trader trader, int year, int value,boolean success) {
		super();
		this.trader = trader;
		this.year = year;
		this.value = value;
		this.success = success;
	}

	public boolean isSuccess() {
		return success;
	}
	public Trader getTrader() {
		return trader;
	}
	public int getYear() {
		return year;
	}
	public int getValue() {
		return value;
	}
	@Override
	public String toString() {
		return "Transaction [trader=" + trader + ", year=" + year + ", value=" + value + "]";
	}
	
}
