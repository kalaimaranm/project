package com.kalai.house.controller;

import java.net.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kalai.house.DTO.Order;

@Controller
public class Welcome {
//	@ResponseBody
	@RequestMapping("/welcome")
	public String viewWelcome(Model model) {
		model.addAttribute("name", "Your's");
		return "welcome";
//		return "/WEB-INF/view/welcome.html";
//		return "Welcome to spring-MVC";
	}

//	@ResponseBody
	@RequestMapping("/order")
	public String orderView(@ModelAttribute() Order order) { // param name should match with html
															// form input name
//		model.addAttribute("order", order);
		System.out.println(order);
//		model.addAttribute("item", request.getAttribute("item"));
//		return "item name is : " + itemName;
		return "order";
	}
}
