package com.bassure.khatabook.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ShopkeeperUtilFormSelectorServlet extends HttpServlet {
    
    PrintWriter out;
    
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        out = response.getWriter();
        String option = request.getParameter("option");
//        String action = "";
        
        switch (option) {
            case "bill": {
                getCustomerIdForm("iscustomerexist");
                break;
            }
            
            case "viewcustomer" : {
                getCustomerIdForm("viewcustomer?option=getdata");
                break;
            }
                
            
            case "deletecustomer": {
                System.out.println("options is :"+option);
                getCustomerIdForm("deletecustomer?option=getdata");
                break;
            }
            
//            case "paydebt": {
//                
//                break;
//            }
            
            case "paydebt": {
                getCustomerIdForm("deletecustomer?option=getdata");
                break;
            }
            
            case "addcustomer": {
                
                break;
            }
            
            case "logout" : {
                request.getSession().invalidate();
                response.sendRedirect("roleselectorservlet");
            }
            
        }
        
    }
    
    public void getCustomerIdForm(String option) {
        
        out.print("""
                 <!DOCTYPE html>
                  <html>
                      <head>
                          <title>Enter Customer Id</title>
                          <meta charset='UTF-8'>
                          <meta name='viewport' content='width=device-width, initial-scale=1.0'>
                      </head>
                      <body>
                          <br/><br/><br/><br/><br/><br/><br/>
                          <div align = 'center' ><form name='customerid' action='%s' method='POST'>
                                  <label for = 'id'>Customer Id</label>
                                  <input type = 'text' id = 'id' name = 'customerid' required/><br/>
                                  <input type = 'submit' value = 'submit' />
                  
                              </form></div>
                  
                      </body>
                  </html>
                  
                  """.formatted(option));//iscustomerexist
    }
    
   
}
