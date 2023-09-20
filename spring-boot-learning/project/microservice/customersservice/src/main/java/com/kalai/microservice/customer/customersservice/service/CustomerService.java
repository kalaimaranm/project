package com.kalai.microservice.customer.customersservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kalai.microservice.customer.customersservice.dao.CustomerDaoImpl;
import com.kalai.microservice.customer.customersservice.entity.Customer;

@Service
public class CustomerService {
	
	
	@Autowired
	private CustomerDaoImpl customerDaoImpl;
	
	
	public boolean saveCustomer(Customer customer) {
		
		return customerDaoImpl.save(customer);
		
	}

}
