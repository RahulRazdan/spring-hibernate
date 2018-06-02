package com.code.springdemo.dao;

import java.util.List;

import com.code.springdemo.entity.Customer;

/**
 * The Interface CustomerDAO.
 */
public interface CustomerDAO {

	/**
	 * Gets the customers.
	 *
	 * @return the customers
	 */
	public List<Customer> getCustomers();
	
	public void saveCustomer(Customer customer);
	
	public Customer getCustomer(int id);

	public void deleteCustomer(Customer customer);

	void deleteCustomerById(int id);
}
