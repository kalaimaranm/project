package com.bassure.khatabook.servlet;

import com.bassure.khatabook.dao.KhatabookDAO;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.bassure.khatabook.model.Address;
import com.bassure.khatabook.model.Customer;
import com.bassure.khatabook.mysql.MysqlKhatabookImpl;

public class AddCustomerServlet extends GenericServlet {

    public static KhatabookDAO khatabook = new MysqlKhatabookImpl();

    @Override
    public void service(ServletRequest request, ServletResponse response) {
        try {
//            Logger.getLogger(AddCustomerServlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
//            response.getWriter().print(">> inside addCustomerServlet...");
            Customer customer = new Customer(0, request.getParameter("name"), request.getParameter("phone"), request.getParameter("aadhaar"), 0.0, 0.0, true, new Address(request.getParameter("doorno"), request.getParameter("street"), request.getParameter("distric"), request.getParameter("state"), request.getParameter("pincode")));
//            if (true) {
            if (khatabook.getCustomer().createAccount(customer) && khatabook.getAddress().insertAddress(customer)) {
//                response.getWriter().print("/success.html");
                response.getWriter().print("customer added successfully "+request.getParameter("street"));
            } else {
                response.getWriter().print("Failed...");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
