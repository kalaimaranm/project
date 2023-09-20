package com.Fresh.Hotels;

import org.springframework.stereotype.Component;

@Component
public class EmailSender implements Message {

	@Override
	public String sendMessage() {
		// TODO Auto-generated method stub
		return "Welcome to Tacobell, May I know the order";
	}

}
