package com.kalai.property.controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kalai.property.model.Payment;

public class FormController {

	@RequestMapping("/viewform")
	public String viewForm(@ModelAttribute("payment") Payment payment) {

		return "paymentForm";
	}

	@RequestMapping("/form")
	public String submitForm(@ModelAttribute("payment") Payment payment, BindingResult result) {

		return result.hasErrors() ? "failed" : "successfull";

	}

}
