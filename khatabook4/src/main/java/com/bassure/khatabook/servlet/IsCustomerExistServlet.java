package com.bassure.khatabook.servlet;

import com.bassure.khatabook.dao.KhatabookDAO;
import com.bassure.khatabook.model.Customer;
import com.bassure.khatabook.mysql.MysqlKhatabookImplTest;
import static com.bassure.khatabook.servlet.AddCustomerServlet.khatabook;
import static com.bassure.khatabook.servlet.OrderManagement.customer;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IsCustomerExistServlet extends HttpServlet {
    
    KhatabookDAO khatabook = new MysqlKhatabookImplTest();
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        if (Objects.nonNull(request.getParameter("customerid")) || request.isUserInRole("CUSTOMER")) {
            Customer customer = null;
            try {
                if (request.isUserInRole("CUSTOMER")) {
                    customer = khatabook.getCustomer().getCustomerById(Integer.parseInt(request.getUserPrincipal().getName()));
                    
                } else if (request.isUserInRole("SHOPKEEPER")) {
                    customer = khatabook.getCustomer().getCustomerById(Integer.parseInt(request.getParameter("customerid")));
                    
                }
//                customer = khatabook.getCustomer().getCustomerById(Integer.parseInt(request.getParameter("customerid")));
            } catch (SQLException | ClassNotFoundException ex) {
                
                Logger.getLogger(IsCustomerExistServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (Objects.nonNull(customer)) {
                request.getSession().setAttribute("customer", customer);
                response.sendRedirect("placeorder?option=view");
            } else if (request.isUserInRole("CUSTOMER")) {
                response.sendRedirect("customerhome.html");
            } else if (request.isUserInRole("SHOPKEEPER")) {
                response.sendRedirect("shopkeeperhome.html");
            }
        }
    }
}
