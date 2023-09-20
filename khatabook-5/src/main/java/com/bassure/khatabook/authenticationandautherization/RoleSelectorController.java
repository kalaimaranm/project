package com.bassure.khatabook.authenticationandautherization;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RoleSelectorController {

    @RequestMapping("/roleselector")
    public String roleSelector(HttpServletRequest request, HttpServletResponse response) throws IOException {

        if (Objects.nonNull(request.getParameter("option"))) {
            request.getSession().invalidate();

            response.sendRedirect("roleselectorservlet");
        }
        if (request.isUserInRole("CUSTOMER")) {

//            response.sendRedirect("customerhome.html");
            return "customerhome";
        } else if (request.isUserInRole("SHOPKEEPER")) {
//            response.sendRedirect("shopkeeperhome.html");
            return "shopkeeperhome";
        }
        return null;

    }
}
