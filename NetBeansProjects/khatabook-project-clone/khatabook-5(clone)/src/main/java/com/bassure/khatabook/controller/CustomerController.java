package com.bassure.khatabook.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CustomerController extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jspPage = "";

        System.out.println(java.time.LocalTime.now() +"   "+ request.getParameter("j_password").equals("d41d8cd98f00b204e9800998ecf8427e"));
        System.out.println();
//        RequestDispatcher dipatcher = request.getRequestDispatcher(jspPage);
//        String option = request.getParameter("option");
//
//        switch (option) {
//            case "addcustomer": {
//                jspPage = "/WEB-INF/view/viewcustomer.html";
//                dipatcher.forward(request, response);
//                break;
//            }
//        }
    }
}
