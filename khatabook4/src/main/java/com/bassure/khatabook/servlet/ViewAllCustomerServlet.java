package com.bassure.khatabook.servlet;

import com.bassure.khatabook.dao.KhatabookDAO;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.io.PrintWriter;
import com.bassure.khatabook.model.Customer;
import com.bassure.khatabook.mysql.MysqlKhatabookImplTest;
import java.util.Objects;

public class ViewAllCustomerServlet extends GenericServlet {

    KhatabookDAO khatabook = new MysqlKhatabookImplTest();

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
//        response.getWriter().print(">> inside view Customer Servlet" + request.getParameter("phone"));
        PrintWriter out = response.getWriter();
        try {

            Customer[] customer = khatabook.getCustomer().getAllCustomer();
            out.write("<!DOCTYPE html>\n");
            out.write("<html lang=\"en\" >\n");
            out.write("    <head>\n");
            out.write("        <meta charset=\"UTF-8\">\n");
            out.write("        <title>view All Customer Profile</title>\n");
            out.write("        <!-- CSS Code: Place this code in the document's head (between the 'head' tags) -->\n");
            out.write("        <!-- CSS Code: Place this code in the document's head (between the 'head' tags) -->\n");
            out.write("        <style>\n");
            out.write("            table.GeneratedTable {\n");
            out.write("                width: 100%;\n");
            out.write("                background-color: #ffffff;\n");
            out.write("                border-collapse: collapse;\n");
            out.write("                border-width: 2px;\n");
            out.write("                border-color: #000000;\n");
            out.write("                border-style: double;\n");
            out.write("                color: #000000;\n");
            out.write("            }\n");
            out.write("\n");
            out.write("            table.GeneratedTable td, table.GeneratedTable th {\n");
            out.write("                border-width: 2px;\n");
            out.write("                border-color: #000000;\n");
            out.write("                border-style: double;\n");
            out.write("                padding: 3px;\n");
            out.write("            }\n");
            out.write("\n");
            out.write("            table.GeneratedTable thead {\n");
            out.write("                background-color: #5ad368;\n");
            out.write("            }\n");
            out.write("        </style>\n");
            out.write("\n");
            out.write("    </head>\n");
            out.write("    <body>\n");
            out.write("    <h1 align = 'center'>Customer Information</h1>\n");
            out.write("\n");
            out.write("        <!-- HTML Code: Place this code in the document's body (between the 'body' tags) where the table should appear -->\n");
            out.write("        <table class=\"GeneratedTable\">\n");
            out.write("            <thead>\n");
            out.write("                <tr>\n");
            out.write("                    <th>ID</th>\n");
            out.write("                    <th>Name</th>\n");
            out.write("                    <th>Phone</th>\n");
            out.write("                    <th>Aadhaar</th>\n");
            out.write("                    <th>Door/House no</th>\n");
            out.write("                    <th>Street</th>\n");
            out.write("                    <th>Distric</th>\n");
            out.write("                    <th>State</th>\n");
            out.write("                    <th>Pincode</th>\n");
            out.write("                    <th>Country</th>\n");
            out.write("                    <th>Debt Balance</th>\n");
            out.write("                    <th>Status</th>\n");
            out.write("\n");
            out.write("                </tr>\n");
            out.write("            </thead>\n");
            if (Objects.nonNull(customer)) {
                for (Customer tempCustomer : customer) {
                    out.write("            <tbody>\n");
                    out.write("                <tr>\n");
                    out.write("                    <td>" + tempCustomer.getId() + "</td>\n");
                    out.write("                    <td>" + tempCustomer.getName() + "</td>\n");
                    out.write("                    <td>" + tempCustomer.getPhone() + "</td>\n");
                    out.write("                    <td>" + tempCustomer.getAadhaar() + "</td>\n");
                    out.write("                    <td>" + tempCustomer.getAddress().getHouseNo() + "</td>\n");
                    out.write("                    <td>" + tempCustomer.getAddress().getStreet() + "</td>\n");
                    out.write("                    <td>" + tempCustomer.getAddress().getDistric() + "</td>\n");
                    out.write("                    <td>" + tempCustomer.getAddress().getState() + "</td>\n");
                    out.write("                    <td>" + tempCustomer.getAddress().getPincode() + "</td>\n");
                    out.write("                    <td>India</td>\n");
                    out.write("                    <td>" + tempCustomer.getDebtBalance() + "</td>\n");
                    out.write("                    <td>" + (tempCustomer.isStatus() ? "Active" : "InActive") + "</td>\n");
                    out.write("                </tr>\n");
                    out.write("            </tbody>\n");
                }
            }
            out.write("        </table>\n");
            out.write("\n");
            out.write("        <!-- partial -->\n");
            out.write("\n");
            out.write("    </body>\n");
            out.write("</html>");
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

    }
}
