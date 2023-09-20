package com.kalai.mycafe;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/outer")
public class HomeController {
//	@RequestMapping("/")
    @RequestMapping("/welcome")
	public static String home() {
		return "/WEB-INF/view/home.jsp";
	}
    @RequestMapping("/order")
	public static String order() {
		return "/WEB-INF/view/order.jsp";
	}
}
