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
//import com.bassure.khatabook.mysql.MysqlKhatabookImpl;
import java.io.PrintWriter;

public class AddCustomerServlet extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

//    public static KhatabookDAO khatabook = new MysqlKhatabookImpl();
//    PrintWriter out;
//    @Override
//    public void service(ServletRequest request, ServletResponse response) throws IOException {
//     out = response.getWriter();
//        try {
//
//            Customer customer = new Customer(0, request.getParameter("password"), 
//                    request.getParameter("name"), request.getParameter("phone")
//                    , request.getParameter("aadhaar"), 0.0, 0.0
//                    , true, new Address(request.getParameter("doorno")
//                    , request.getParameter("street"), request.getParameter("distric")
//                    , request.getParameter("state"), request.getParameter("pincode")));
//                if (khatabook.getCustomer().createAccount(customer) && khatabook.getAddress().insertAddress(customer)) {
//                customer = khatabook.getCustomer().getCustomerByPhoneNo(customer.getPhone());
//                out.print("<br/><br/><br/><br/><br/><br/><h1 align = 'center'>customer added successfully " +"</h1>");
//           out.print("""
//                     <div = align = 'center'> <h1>Id       :%d</h1><br/>
//                      <h1>Name     :%s</h1><br/>
//                      <h1>Phone no :%s</h1><br/>
//                      <h1>AadhaarNo:%s<h1><br/></div><br/><br/><div align = 'center'><a href = "roleselectorservlet">Home</a></div>
//                     """.formatted(customer.getId(),customer.getName(),customer.getPhone(),customer.getAadhaar()));
//            } else {
//                response.getWriter().print("Failed...");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
