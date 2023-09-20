package com.Fresh.Hotels;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



public class ConfigTest {
	@Bean
	public static Hotel burgerKing() {
		
		return new BurgerKing();
	}
}
