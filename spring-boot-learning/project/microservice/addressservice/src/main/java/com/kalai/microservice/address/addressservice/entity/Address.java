package com.kalai.microservice.address.addressservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Setter
//@Getter
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
public class Address {

	private Long id;
	private Long customerId;
	private String doorNo;
	private String street;
	private String area;
	private String taluk;
	private String distric;
	private String city;
	private String pincode;

	public Address(Long id, Long customerId, String doorNo, String street, String area, String taluk, String distric,
			String city, String pincode) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.doorNo = doorNo;
		this.street = street;
		this.area = area;
		this.taluk = taluk;
		this.distric = distric;
		this.city = city;
		this.pincode = pincode;
	}

	public Long getId() {
		return id;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public String getDoorNo() {
		return doorNo;
	}

	public String getStreet() {
		return street;
	}

	public String getArea() {
		return area;
	}

	public String getTaluk() {
		return taluk;
	}

	public String getDistric() {
		return distric;
	}

	public String getCity() {
		return city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public void setTaluk(String taluk) {
		this.taluk = taluk;
	}

	public void setDistric(String distric) {
		this.distric = distric;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", customerId=" + customerId + ", doorNo=" + doorNo + ", street=" + street
				+ ", area=" + area + ", taluk=" + taluk + ", distric=" + distric + ", city=" + city + ", pincode="
				+ pincode + "]";
	}

}
