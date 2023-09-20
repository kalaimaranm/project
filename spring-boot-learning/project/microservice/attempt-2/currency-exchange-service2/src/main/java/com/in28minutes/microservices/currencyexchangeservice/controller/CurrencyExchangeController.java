package com.in28minutes.microservices.currencyexchangeservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.microservices.currencyexchangeservice.model.CurrencyExchange;
import com.in28minutes.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private Environment environment;

//	@Autowired
//	private CurrencyExchangeRepository currencyExchangeRepsitory;

	@GetMapping(path = "/currency-exchange/from/{from}/to/{to}", produces = MediaType.APPLICATION_JSON_VALUE)
	public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		System.out.println("request hit ........");

		CurrencyExchange currencyExchange = new CurrencyExchange(10001l, "USD", "INR", new BigDecimal(65),
				environment.getProperty("local.server.port"));
//				currencyExchangeRepsitory.findByFromAndTo(from, to);
		if (currencyExchange == null) {

			throw new RuntimeException("Unable to find data for" + from + " to " + to);
		}
		currencyExchange.setEnvironment(environment.getProperty("local.server.port"));

		System.out.println("currency exchange " + currencyExchange);
		return currencyExchange;
	}

	@GetMapping("/test")
	public String test() {

		return "currency-exchange-service working fine";
	}

}
