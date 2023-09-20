package com.bassure.khatabook.filter;

import com.bassure.khatabook.dao.KhatabookDAO;
import com.bassure.khatabook.mysql.MysqlKhatabookImpl;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Objects;
import java.io.PrintWriter;

public class CustomerExistFilter implements Filter {

    KhatabookDAO khatabookDAO = new MysqlKhatabookImpl();
    PrintWriter out;
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
       out = response.getWriter();
        try {
            if (Objects.nonNull(khatabookDAO.getCustomer().getCustomerByPhoneNo(request.getParameter("phone")))) {
                chain.doFilter(request, response);
            } else {
                out.println("<div align = \"center\"><h1>Customer already exist </h1><br /><a href = \"createaccount.html\">Home</a></div>");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CustomerExistFilter.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }

    public void log(String msg) {
//        filterConfig.getServletContext().log(msg);        
    }

}
