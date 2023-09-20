package com.Fresh.Testing.Component;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Testing.xml");
		Testing testing = context.getBean("testing",Testing.class);
		System.out.println("After xml file loaded");
		context.close();
	}
}
