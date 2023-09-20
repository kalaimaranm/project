package com.kalai.microservice.customer.customersservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kalai.microservice.customer.customersservice.entity.Customer;
import com.kalai.microservice.customer.customersservice.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/customers")
	public ResponseEntity<String> saveAddress(@RequestBody Customer customer) {

		if (customerService.saveCustomer(customer)) {

			return ResponseEntity.ok("customer added sccessfully");
		}

		return ResponseEntity.internalServerError().body("customer addtion failed...");

	}
}
