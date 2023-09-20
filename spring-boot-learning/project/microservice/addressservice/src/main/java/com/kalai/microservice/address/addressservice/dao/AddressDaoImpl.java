package com.kalai.microservice.address.addressservice.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kalai.microservice.address.addressservice.entity.Address;

@Repository
public class AddressDaoImpl {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private DBConnection DBConnection;

	public boolean saveAddress(Address address) {

		return jdbcTemplate.update("insert into Address values (?,?,?,?,?,?,?)", address.getDoorNo(),
				address.getStreet(), address.getDistric()
				,address.getCity(), address.getArea()
				,address.getTaluk(),
				address.getPincode()) != 0;

	}

}
