package com.kalai.lc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.RequestScope;

@Controller
@RequestMapping("/spring-l-calculator/myapp")
public class FrontController {

	@RequestMapping("/home")
	@ResponseBody
	public String home() {
		return "welcome to spring - MVC";
	}
}
