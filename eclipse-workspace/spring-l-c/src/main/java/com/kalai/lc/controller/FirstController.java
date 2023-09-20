package com.kalai.lc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class FirstController {
     @RequestMapping("/test2")
	public String viewTest() {
		return "test";
	}

}
