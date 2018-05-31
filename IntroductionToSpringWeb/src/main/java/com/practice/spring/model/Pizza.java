package com.practice.spring.model;

import java.io.Serializable;

/**
 * The Class Pizza.
 */
public class Pizza implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6602019789597421567L;

	/** The size. */
	private String size;
	
	/** The topping. */
	private String topping;
	
	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	public String getSize() {
		return size;
	}
	
	/**
	 * Sets the size.
	 *
	 * @param size the new size
	 */
	public void setSize(String size) {
		this.size = size;
	}
	
	/**
	 * Gets the topping.
	 *
	 * @return the topping
	 */
	public String getTopping() {
		return topping;
	}
	
	/**
	 * Sets the topping.
	 *
	 * @param topping the new topping
	 */
	public void setTopping(String topping) {
		this.topping = topping;
	}
	
}
