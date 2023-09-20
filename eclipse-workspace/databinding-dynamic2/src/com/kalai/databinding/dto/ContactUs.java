package com.kalai.databinding.dto;

public class ContactUs {
	
	private String name;
	private String email = "contactus@gmail.com";
	private Phone phone;
	
	public ContactUs (String name, String email) {
		this.name = name;
		this.email = email;
	}
	public ContactUs () {
		
	}
 	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
