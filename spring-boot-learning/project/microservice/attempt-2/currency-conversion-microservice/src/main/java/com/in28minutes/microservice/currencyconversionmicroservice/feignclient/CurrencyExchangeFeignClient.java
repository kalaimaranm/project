package com.in28minutes.microservice.currencyconversionmicroservice.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.in28minutes.microservice.currencyconversionmicroservice.model.CurrencyConversion;

@FeignClient(name = "currency-exchange")
//@FeignClient(name = "currency-exchange", url = "localhost:8000")
public interface CurrencyExchangeFeignClient {

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	CurrencyConversion getExchangeAmount(@PathVariable String from, @PathVariable String to);

}
