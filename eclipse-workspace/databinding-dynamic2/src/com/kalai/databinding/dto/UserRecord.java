package com.kalai.databinding.dto;

public record UserRecord(String name, String email, 
		                 String password, int age,
		                 String gender, String address,
		                 String phone) {

	public String name() {
		return name;
	}

	public String email() {
		return email;
	}

	public String password() {
		return password;
	}

	public int age() {
		return age;
	}

	public String gender() {
		return gender;
	}

	public String address() {
		return address;
	}

	public String phone() {
		return phone;
	}

	

}
