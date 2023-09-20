package com.in28minutes.microservices.limitservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(value = "limits-service")
@Component
public class Configurations {
	
	private int minimum;
	private int maximum;
	
//	private int test;
	
//	
//	public int getTest() {
//		return test;
//	}
//	public void setTest(int test) {
//		this.test = test;
//	}
	public int getMinimum() {
		return minimum;
	}
	public int getMaximum() {
		return maximum;
	}
	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}
	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
	
	

}
