package com.code.springdemo.service;

import java.util.List;

import com.code.springdemo.entity.Customer;

public interface CustomerService {

	/**
	 * Gets the customers.
	 *
	 * @return the customers
	 */
	public List<Customer> getCustomers();
	
	/**
	 * Save customer.
	 *
	 * @param customer the customer
	 * @return the int
	 */
	public void saveCustomer(Customer customer);
	
	/**
	 * Gets the customer.
	 *
	 * @param id the id
	 * @return the customer
	 */
	public Customer getCustomer(int id);

	public void deleteCustomer(int id);

	void deleteCustomer(Customer customer);
}
