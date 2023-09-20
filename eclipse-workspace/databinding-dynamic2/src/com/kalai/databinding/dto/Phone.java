package com.kalai.databinding.dto;

public class Phone {

	private String countryCode;
	private String phoneno;

	public Phone(String countryCode, String phoneno) {
		this.countryCode = countryCode;
		this.phoneno = phoneno;
	}

	public Phone() {
    
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

}
