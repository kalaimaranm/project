package com.kalai.databinding.dto;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.kalai.databinding.validator.Age;

public class User {
//	@NotNull(message = "* name should not be blank")
//	@Min(value = 3, message = "* name should contains atleast 3 character")
//	@Max(value = 25, message = "* maximum size of name is 25 character")
//	@NotNull(message = "* name should not be blank")
//	@Size(min = 3, max = 25, message = "*name should be within the range [3-25] character")
	@NotEmpty(message = "* name should not be empty")
	@NotBlank(message = "* please dont fill the blank space")
	@NotNull(message = " * name should n't be null")
	private String name;
	@NotNull(message = "* email should not be blank")
	private String email;
	private String password;
//	@Age(lower = 16, upper = 58)
	private Integer age;
	private String gender;
	private String address;
	private String phone;
	@AssertTrue(message = "* You have to agree terms & condition to use this application")
	private boolean agreeCondition;
	private ContactUs contactUs;

	public ContactUs getContactUs() {
		return contactUs;
	}

	public void setContactUs(ContactUs contactUs) {
		this.contactUs = contactUs;
	}

	public boolean isAgreeCondition() {
		return agreeCondition;
	}

	public void setAgreeCondition(boolean agreeCondition) {
		this.agreeCondition = agreeCondition;
	}

	public User() {

	}

	public User(String name, String email, String password, int age, String gender, String address, String phone,
			boolean agreeCondition) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.phone = phone;
		this.agreeCondition = agreeCondition;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
