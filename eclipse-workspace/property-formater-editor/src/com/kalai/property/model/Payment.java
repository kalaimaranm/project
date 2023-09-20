package com.kalai.property.model;

import java.util.Date;

public class Payment {

	private String firstFourDigit = "xxxx";
	private String secondFourDigit = "xxxx";
	private String thirdFourDigit = "xxxx";
	private String lastFourDigit = "xxxx";
	private String cardHolderName = "RAKESH M";
	private String cvv = "109";
	private Date expiryDate;

	public Payment() {

	}

	public Payment(String firstFourDigit, String secondFourDigit, String thirdFourDigit, String lastFourDigit,
			String cardHolderName, String cvv, Date expiryDate) {
		this.firstFourDigit = firstFourDigit;
		this.secondFourDigit = secondFourDigit;
		this.thirdFourDigit = thirdFourDigit;
		this.lastFourDigit = lastFourDigit;
		this.cardHolderName = cardHolderName;
		this.cvv = cvv;
		this.expiryDate = expiryDate;
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

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

}
