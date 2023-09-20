package com.kalai.microservice.address.addressservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kalai.microservice.address.addressservice.entity.Address;
import com.kalai.microservice.address.addressservice.service.AddressService;


@RestController
public class AddressController {

	@Autowired
	private AddressService addressService;

	@PostMapping("/addresss")
	public ResponseEntity<String> saveAddress(@RequestBody Address address) {

		if (addressService.saveAddress(address)) {

			return ResponseEntity.ok("address added successfully");
		}
		return ResponseEntity.internalServerError().body("address addition failed");

	}

}
