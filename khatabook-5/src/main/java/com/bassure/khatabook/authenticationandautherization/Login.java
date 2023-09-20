package com.bassure.khatabook.authenticationandautherization;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Login {

    private static String UserRole;

    @GetMapping("")
    public String login() {

        return "";

    }

    public static String getUserRole() {
        return UserRole;
    }

    public static void setUserRole(String UserRole) {
        Login.UserRole = UserRole;
    }

}
