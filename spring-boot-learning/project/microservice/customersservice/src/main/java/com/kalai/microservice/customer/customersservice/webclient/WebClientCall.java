package com.kalai.microservice.customer.customersservice.webclient;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.kalai.microservice.customer.customersservice.entity.Address;

import reactor.core.publisher.Mono;

@Component
public class WebClientCall {

	@Autowired
	private WebClient webClient;

	public boolean saveAddress(Address address) {

		webClient.post()
		.uri(URI.create("/addresss"))
		.body(Mono.just(address), Address.class)
		.retrieve()
		.bodyToMono(String.class);
		
		
		return true;

	}

}
