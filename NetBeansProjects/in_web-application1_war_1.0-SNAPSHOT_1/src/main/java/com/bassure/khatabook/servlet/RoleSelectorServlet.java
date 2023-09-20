package com.bassure.khatabook.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RoleSelectorServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {

            out.print(request.getUserPrincipal());

            if (request.isUserInRole("CUSTOMER")) {
                response.sendRedirect("customerhome.html");
            } else if (request.isUserInRole("SHOPKEEPER")) {
                response.sendRedirect("shopkeeperhome.html");
            }
        }
    }
}
