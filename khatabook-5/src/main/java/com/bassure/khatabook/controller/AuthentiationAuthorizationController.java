package com.bassure.khatabook.controller;

import com.bassure.khatabook.model.LoginCredential;
import com.bassure.khatabook.service.AuthenticationAuthorizationService;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthentiationAuthorizationController {

    @Autowired
    AuthenticationAuthorizationService authenticationAuthorizationService;

    @PostMapping("/home-page")
    public String loginCredential(HttpServletRequest request, @RequestParam("userid") int id, @RequestParam("password") String password, ModelMap model) throws ClassNotFoundException, SQLException {

        LoginCredential loginCredential = authenticationAuthorizationService.loginCredential(new LoginCredential(id, password, ""));
//        System.out.println(loginCredential);
        if (loginCredential != null && loginCredential.getRole().equals("CUSTOMER")) {
            request.getSession().setAttribute("customerId", id);
            request.getSession().setAttribute("role", loginCredential.getRole());
            System.out.println(request.getSession().getAttribute("customerId"));
            return "customer/customer-home";
        } else if (loginCredential != null && loginCredential.getRole().equals("SHOPKEEPER")) {
            System.out.println("inside shopkeeper condition");
            return "shopkeeper/";
        } else {

            return "customer/user-not-found";
        }

    }

    @GetMapping("/log-out")
    public String logout(HttpServletRequest request) {

        request.getSession().invalidate();
        return "login-form";
    }
}
