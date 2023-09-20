package com.kalai.microservice.customer.customersservice.webclient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@Configuration
public class WebClients {

	@Bean
	public WebClient getWebClient() {

		return WebClient.
				 builder()
				.baseUrl("http://localhost:8101/addresss")
				.build();

	}

}
