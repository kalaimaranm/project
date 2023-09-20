package com.bassure.khatabook.servlet;

import com.bassure.khatabook.dao.KhatabookDAO;
import com.bassure.khatabook.model.Customer;
import com.bassure.khatabook.mysql.MysqlKhatabookImplTest;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RoleSelectorServlet extends HttpServlet {
    
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {

//            out.print(request.getUserPrincipal());
            if (Objects.nonNull(request.getParameter("option"))) {
                request.getSession().invalidate();
                response.sendRedirect("roleselectorservlet");
            }
            if (request.isUserInRole("CUSTOMER")) {
                response.sendRedirect("customerhome.html");
            } else if (request.isUserInRole("SHOPKEEPER")) {
                response.sendRedirect("shopkeeperhome.html");
            }
            
        }
    }
}
