package com.luv2code.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	@Autowired
	CustomerService service;
	
	@RequestMapping("/customers")
	public List<Customer> getCustomers(){
		return service.getCustomers();
	}
	
	@RequestMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable String customerId){
		
		if(customerId == null)
			throw new CustomerNotFoundException("Customer not found!!");
		
		return service.getCustomer(Integer.parseInt(customerId));
	}
}
