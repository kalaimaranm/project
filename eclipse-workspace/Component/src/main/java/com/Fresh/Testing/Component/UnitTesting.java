package com.Fresh.Testing.Component;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")  // object will created during the xml file loaded 
public class UnitTesting {
	public UnitTesting() {
		System.out.println(">> inside UnitTesting Constructor");
	}
}
