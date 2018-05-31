package com.practice.spring.util;

import com.practice.spring.model.Customer;
import com.practice.spring.model.Order;
import com.practice.spring.model.Payment;

public class PizzaFlowActions {

	public Customer lookupCustomer(String phoneNumber) throws Exception{
		
		if(phoneNumber.equalsIgnoreCase("1234"))
			throw new Exception("Customer do not exist");
		
		Customer c = new Customer();
		c.setAddress("Local");
		c.setCity("city");
		c.setName("Rahul");
		c.setPhoneNumber(phoneNumber);
		c.setState("state");
		c.setZipCode("123123");
		
		return c;
	}
	
	public Payment verifyPayment(Payment paymentDetails){
		return paymentDetails;
	}
	
	public boolean checkDeliveryArea(String zipCode){
		if(zipCode.equalsIgnoreCase("123456"))
			return false;
		else
			return true;
	}
	public void saveOrder(Order order){
		
	}
}
