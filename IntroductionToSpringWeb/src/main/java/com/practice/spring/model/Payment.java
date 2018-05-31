package com.practice.spring.model;

import java.io.Serializable;

/**
 * The Class Payment.
 */
public class Payment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8837979150737882155L;
	/** The payment type. */
	private String paymentType;

	/**
	 * Gets the payment type.
	 *
	 * @return the payment type
	 */
	public String getPaymentType() {
		return paymentType;
	}

	/**
	 * Sets the payment type.
	 *
	 * @param paymenType the new payment type
	 */
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	
}
