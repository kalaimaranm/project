package com.kalai.lc.service;

import org.springframework.beans.factory.annotation.Autowired;

public class Main {
	@Autowired
	static Category category;

	public static void main(String... args) {
		System.out.println("category is : " + category);
		
	}

}
