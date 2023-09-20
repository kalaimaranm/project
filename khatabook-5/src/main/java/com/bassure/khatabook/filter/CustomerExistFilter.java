package com.bassure.khatabook.filter;

import com.bassure.khatabook.dao.KhatabookDAO;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.IOException;

public class CustomerExistFilter implements Filter {

//    KhatabookDAO khatabookDAO = new MysqlKhatabookImpl();

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        
    }

    public void log(String msg) {
//        filterConfig.getServletContext().log(msg);        
    }

}
