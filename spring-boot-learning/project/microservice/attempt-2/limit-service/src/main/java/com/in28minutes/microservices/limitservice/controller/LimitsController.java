package com.in28minutes.microservices.limitservice.controller;

import java.lang.module.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.microservices.limitservice.bean.Limit;
import com.in28minutes.microservices.limitservice.config.Configurations;

@RestController
public class LimitsController {

	@Autowired
	private Configurations configuration;

	@GetMapping("/limits")
	public Limit getLimit() {

		return new Limit(configuration.getMinimum(), configuration.getMaximum());
	}

	
}
