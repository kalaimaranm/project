package com.in28minutes.microservice.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.in28minutes.microservice.currencyconversionservice.entity.CurrencyConversion;

@RestController
public class CurrencyConversionController {

	@Autowired
	private Environment environment;

	@GetMapping(path = "/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversion(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		System.out.println("inside currency conversion service " + quantity);

		HashMap<String, String> data = new HashMap();
		data.put("from", from);
		data.put("to", to);

		ResponseEntity<CurrencyConversion> currencyConversion = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class, data);

//		CurrencyConversion currencyConversion = new CurrencyConversion(1000l, from, to, BigDecimal.valueOf(1.0),
//				BigDecimal.valueOf(10.0), quantity, "8100");

		CurrencyConversion conversion = currencyConversion.getBody();
		conversion.setTotalCalculatedAmount(conversion.getConversionMultiple().multiply(quantity));
		conversion.setQuantity(quantity);
		System.out.println(currencyConversion);
		return conversion;
	}

}
