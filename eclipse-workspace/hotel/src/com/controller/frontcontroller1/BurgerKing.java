package com.controller.frontcontroller1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@RequestMapping("/before")
public class BurgerKing {
//	@ResponseBody()
	@RequestMapping("/menu")
	public String response() {
		return"menu";//Model
//		return "/WEB-INF/view/menu.html";
	}
}
