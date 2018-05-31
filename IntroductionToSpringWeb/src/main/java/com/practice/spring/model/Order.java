package com.practice.spring.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The Class Order.
 */
public class Order implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8043622082302906058L;

	/** The customer. */
	private Customer customer;
	
	/** The pizzas. */
	private List<Pizza> pizzas;
	
	/** The payment. */
	private Payment payment;
	
	/**
	 * Instantiates a new order.
	 */
	public Order(){
		pizzas = new ArrayList<>();
		customer = new Customer();
	}
	
	/**
	 * Gets the customer.
	 *
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}
	
	/**
	 * Sets the customer.
	 *
	 * @param customer the new customer
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	/**
	 * Gets the pizzas.
	 *
	 * @return the pizzas
	 */
	public List<Pizza> getPizzas() {
		return pizzas;
	}
	
	/**
	 * Adds the pizza.
	 *
	 * @param pizza the pizza
	 */
	public void addPizza(Pizza pizza){
		pizzas.add(pizza);
	}
	
	/**
	 * Gets the total.
	 *
	 * @return the total
	 */
	public float getTotal(){
		return 0.0f;
	}
	
	/**
	 * Sets the pizzas.
	 *
	 * @param pizzas the new pizzas
	 */
	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}
	
	/**
	 * Gets the payment.
	 *
	 * @return the payment
	 */
	public Payment getPayment() {
		return payment;
	}
	
	/**
	 * Sets the payment.
	 *
	 * @param payment the new payment
	 */
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	
}
