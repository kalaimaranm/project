package com.kalai.property.model;

public class CardNumber {

	private String firstFourDigit;
	private String secondFourDigit;
	private String thirdFourDigit;
	private String lastFourDigit;

	public CardNumber() {
        
	}

	public CardNumber(String firstFourDigit, String secondFourDigit, String thirdFourDigit, String lastFourDigit) {
		this.firstFourDigit = firstFourDigit;
		this.secondFourDigit = secondFourDigit;
		this.thirdFourDigit = thirdFourDigit;
		this.lastFourDigit = lastFourDigit;
	}

	public String getFirstFourDigit() {
		return firstFourDigit;
	}

	public void setFirstFourDigit(String firstFourDigit) {
		this.firstFourDigit = firstFourDigit;
	}

	public String getSecondFourDigit() {
		return secondFourDigit;
	}

	public void setSecondFourDigit(String secondFourDigit) {
		this.secondFourDigit = secondFourDigit;
	}

	public String getThirdFourDigit() {
		return thirdFourDigit;
	}

	public void setThirdFourDigit(String thirdFourDigit) {
		this.thirdFourDigit = thirdFourDigit;
	}

	public String getLastFourDigit() {
		return lastFourDigit;
	}

	public void setLastFourDigit(String lastFourDigit) {
		this.lastFourDigit = lastFourDigit;
	}

}
