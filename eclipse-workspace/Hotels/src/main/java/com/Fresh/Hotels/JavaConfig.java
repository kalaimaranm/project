package com.Fresh.Hotels;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
//import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
//@ComponentScan("com.Fresh.Hotels")

@Configurable
public class JavaConfig {

	@Bean
	public Hotel getBurgerKing() {
		return new BurgerKing();
	}
//	@Bean
//	public 

}
