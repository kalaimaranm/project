package com.kalai.lc.service;

import org.springframework.stereotype.Component;

@Component
public class Category {

	String type;
	String name;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
