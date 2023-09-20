package com.in28minutes.microservice.currencyconversionmicroservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.in28minutes.microservice.currencyconversionmicroservice.feignclient.CurrencyExchangeFeignClient;
import com.in28minutes.microservice.currencyconversionmicroservice.model.CurrencyConversion;

@RestController
public class CurrencyConversionController {

	@Autowired
	private CurrencyExchangeFeignClient feignClient;

//	@GetMapping("currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
//	public CurrencyConversion calculateCurrencyConversion(@PathVariable String from, @PathVariable String to,
//			@PathVariable BigDecimal quantity) {
//
//		System.out.println("quantity" + quantity);
//
//		Map<String, String> uriVariables = new HashMap();
//		uriVariables.put("from", from);
//		uriVariables.put("to", to);
//
//		ResponseEntity<CurrencyConversion> result = new RestTemplate().getForEntity(
//				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class, uriVariables);
//
//		System.out.println(result.getHeaders());
//		CurrencyConversion currencyConversion = result.getBody();
//		System.out.println("currency-conversion rest call" + currencyConversion);
//
//		currencyConversion.setQuantity(quantity);
//		System.out.println("currecy multiple" + currencyConversion.getAmount());
//		System.out.println("currency calculated amount " + currencyConversion.getAmount());
//
//		currencyConversion.setTotalCalculatedAmount(quantity.multiply(currencyConversion.getAmount()));
//		return null;
//
//		return currencyConversion;
//		return new CurrencyConversion(1000l, from, to, quantity, currencyConversion.getConversionMultiple(),
//				quantity.multiply(currencyConversion.getConversionMultiple()), currencyConversion.getEnvironment());
//	}

	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversionUsingFeignClient(@PathVariable String from,
			@PathVariable String to, @PathVariable BigDecimal quantity) {
		System.out.println("-------inside feign client call-------");

		CurrencyConversion currencyConversion = feignClient.getExchangeAmount(from, to);
		System.out.println("currency-conversion - " + currencyConversion);
		currencyConversion.setQuantity(quantity);
		currencyConversion.setTotalCalculatedAmount(quantity.multiply(currencyConversion.getAmount()));

		return currencyConversion;

	}

}
