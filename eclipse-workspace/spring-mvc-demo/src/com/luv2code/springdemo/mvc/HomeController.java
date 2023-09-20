package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/outer")
public class HomeController {
	@RequestMapping("/menu")
	public String showPage() {
		return "/WEB-INF/view/main-menu.jsp";
	}
}
