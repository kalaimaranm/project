package com.kalai.house.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/outer")
public class Thank {
	@ResponseBody
	@RequestMapping("/thank")
	public String thankView() {

		return "Thank You....! :)";
	}

	@ResponseBody
	@RequestMapping("specialthank")
	public String specialThankView() {
		return "Thank You \nVisit again.....  :)";
	}

}
