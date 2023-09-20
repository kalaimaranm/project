package com.kalai.microservice.address.addressservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kalai.microservice.address.addressservice.dao.AddressDaoImpl;
import com.kalai.microservice.address.addressservice.entity.Address;

@Service
public class AddressService {

	@Autowired
	private AddressDaoImpl addressDaoImpl;

	public boolean saveAddress(Address address) {

		return addressDaoImpl.saveAddress(address);
	}

}
