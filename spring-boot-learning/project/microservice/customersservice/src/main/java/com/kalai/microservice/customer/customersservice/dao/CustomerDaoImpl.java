package com.kalai.microservice.customer.customersservice.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kalai.microservice.customer.customersservice.entity.Customer;

@Repository
public class CustomerDaoImpl {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public boolean save(Customer customer) {

		return jdbcTemplate.update("insert into Customer values(?,?)", 
				customer.getName(), customer.getAge()) != 0;
	
	}

}
