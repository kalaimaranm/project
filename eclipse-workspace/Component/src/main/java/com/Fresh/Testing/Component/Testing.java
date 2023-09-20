package com.Fresh.Testing.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") // where as object will create when you call the bean
public class Testing {
	public Testing() {
		System.out.println(">> inside Testing Constructor....");
	}
@PostConstruct
	public static void init() {
		System.out.println(">> Hey do my start up stuff.....");
	}
@PreDestroy
	public static void destroy() {
		System.out.println(">> Hey do my start up stuff.....");
	}
}
