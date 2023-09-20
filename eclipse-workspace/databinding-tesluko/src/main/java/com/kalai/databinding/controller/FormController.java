package com.kalai.databinding.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;
import com.kalai.databinding.dao.FormCRUD;
import com.kalai.databinding.dto.UserRecord;
import com.kalai.databinding.dto.UserRecords;

@Controller
public class FormController {
	@Autowired
	FormCRUD formCRUD;// = new FormCRUD();

	@ResponseBody
	@RequestMapping("/home")
	public String home() {

		return "home";
	}

	@RequestMapping("/signin")
	public String login(@RequestParam() String email, @RequestParam() String password) throws ClassNotFoundException, SQLException {
		if (Objects.nonNull(formCRUD.getUser(email, password))) {
			return "detail";
		}
		return "home";
		
	}
	@RequestMapping("/signupform")
	public String signup() {
		
		return "signup";
	}

	@RequestMapping("/signup")
	public String signup(@ModelAttribute UserRecords userRecord) throws ClassNotFoundException, SQLException {
        if (formCRUD.creatAccount(userRecord)) {
        	return "detail";
        } 
		return "signup";
	}

	public String update(@ModelAttribute UserRecord userRecord) {

		return "detail";
	}

}
