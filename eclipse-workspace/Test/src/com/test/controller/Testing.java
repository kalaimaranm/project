package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Testing {
	@ResponseBody
	@RequestMapping("/test")
	public String view() {
		return "tested";
	}
}
