package com.kalai.databinding.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<Age, Integer> {

	private Integer lower;
	private Integer upper;

	@Override
	public void initialize(Age age) {
		System.out.println(" >>>>>>>>>>>>>>>>>>> inside initialize() method >>>>>>>>>>>>>>>>");
		this.lower = age.lower();
		this.upper = age.upper();
	}

	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext arg1) {
		System.out.println(" >>>>>>>>>>>>>>>>>>> inside isValid() method >>>>>>>>>>>>>>>>");
//		return value > getUpper() || value < getLower() || value == null ? true : false;
		if (value > this.getUpper() || value < this.getLower() || value == null) {
			return false;
		}
		return true;
	} 

	public Integer getLower() {
		return lower;
	}

	public Integer getUpper() {
		return upper;
	}

}