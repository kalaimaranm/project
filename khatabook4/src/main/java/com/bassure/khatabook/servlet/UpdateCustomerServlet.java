package com.bassure.khatabook.servlet;

import com.bassure.khatabook.dao.KhatabookDAO;
import com.bassure.khatabook.model.Address;
import com.bassure.khatabook.model.Customer;
import com.bassure.khatabook.mysql.MysqlKhatabookImplTest;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.PrintWriter;

public class UpdateCustomerServlet extends GenericServlet {

    KhatabookDAO khatabook = new MysqlKhatabookImplTest();
    PrintWriter out;

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        out = response.getWriter();
//        DeleteCustomerServlet.getData();
        String option = request.getParameter("option");
        switch (option) {
            case "updatecustomer": {
                String phone = request.getParameter("phone");
                try {
                    Customer customer = khatabook.getCustomer().getCustomerByPhoneNo(phone);
                    if (Objects.nonNull(customer) && customer.isStatus()) {
                        updateCustomerForm(customer);
                    }
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(UpdateCustomerServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            case "getdata": {
                Customer customer;
                try {
                    customer = khatabook.getCustomer().getCustomerByPhoneNo(request.getParameter("phone"));
                    if (Objects.nonNull(customer) && customer.isStatus()) {
                        customer = new Customer(Integer.parseInt(request.getParameter("id")),
                                "",
                                request.getParameter("name"),
                                request.getParameter("phone"),
                                request.getParameter("aadhaar"),
                                0,
                                0,
                                true,
                                new Address(request.getParameter("doorno"),
                                        request.getParameter("street"),
                                        request.getParameter("distric"),
                                        request.getParameter("state"),
                                        request.getParameter("pincode")));
                        if (khatabook.getCustomer().updateCustomer(customer)) {
                            out.print("<h1 align = \"center\">Customer details successfully updated...</h1>");
                        } else {
                            out.print("<h1 align = \"center\">Customer Updation Failed</h1>");
                        }
                    } else {
                        out.print("<h1 align = \"center\">Customer not Found</h1>");
                    }
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(UpdateCustomerServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }

    void updateCustomerForm(Customer customer) {
        out.write("\n");
        out.write("\n");
        out.write("\n");
        out.write("<!DOCTYPE html>\n");
        out.write("<html>\n");
        out.write("    <head>\n");
        out.write("        <title>Update product</title>\n");
        out.write("        <link href=\"https://fonts.googleapis.com/css?family=Roboto:300,400,500,700\" rel=\"stylesheet\">\n");
        out.write("        <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.5.0/css/all.css\" integrity=\"sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU\" crossorigin=\"anonymous\">\n");
        out.write("        <style>\n");
        out.write("            html, body {\n");
        out.write("                min-height: 100%;\n");
        out.write("            }\n");
        out.write("            body, div, form, input, textarea, p {\n");
        out.write("                padding: 0;\n");
        out.write("                margin: 0;\n");
        out.write("                outline: none;\n");
        out.write("                font-family: Roboto, Arial, sans-serif;\n");
        out.write("                font-size: 14px;\n");
        out.write("                color: #666;\n");
        out.write("                line-height: 22px;\n");
        out.write("            }\n");
        out.write("            h1 {\n");
        out.write("                position: absolute;\n");
        out.write("                margin: 0;\n");
        out.write("                font-size: 32px;\n");
        out.write("                color: #fff;\n");
        out.write("                z-index: 2;\n");
        out.write("            }\n");
        out.write("            .testbox {\n");
        out.write("                display: flex;\n");
        out.write("                justify-content: center;\n");
        out.write("                align-items: center;\n");
        out.write("                height: inherit;\n");
        out.write("                padding: 20px;\n");
        out.write("            }\n");
        out.write("            form {\n");
        out.write("                width: 100%;\n");
        out.write("                padding: 20px;\n");
        out.write("                border-radius: 6px;\n");
        out.write("                background: #fff;\n");
        out.write("                box-shadow: 0 0 10px 0 #cc0052;\n");
        out.write("            }\n");
        out.write("            .banner {\n");
        out.write("                position: relative;\n");
        out.write("                height: 210px;\n");
        out.write("                background-image: url(\"/uploads/media/default/0001/01/f1cf9a9068f4bfbdbd9758c45db79203579a3561.jpeg\");\n");
        out.write("                background-size: cover;\n");
        out.write("                display: flex;\n");
        out.write("                justify-content: center;\n");
        out.write("                align-items: center;\n");
        out.write("                text-align: center;\n");
        out.write("            }\n");
        out.write("            .banner::after {\n");
        out.write("                content: \"\";\n");
        out.write("                background-color: rgba(0, 0, 0, 0.4);\n");
        out.write("                position: absolute;\n");
        out.write("                width: 100%;\n");
        out.write("                height: 100%;\n");
        out.write("            }\n");
        out.write("            input, textarea {\n");
        out.write("                margin-bottom: 10px;\n");
        out.write("                border: 1px solid #ccc;\n");
        out.write("                border-radius: 3px;\n");
        out.write("            }\n");
        out.write("            input {\n");
        out.write("                width: calc(100% - 10px);\n");
        out.write("                padding: 5px;\n");
        out.write("            }\n");
        out.write("            textarea {\n");
        out.write("                width: calc(100% - 12px);\n");
        out.write("                padding: 5px;\n");
        out.write("            }\n");
        out.write("            .item:hover p, input:hover::placeholder {\n");
        out.write("                color: #cc0052;\n");
        out.write("            }\n");
        out.write("            .item input:hover, .item textarea:hover {\n");
        out.write("                border: 1px solid transparent;\n");
        out.write("                box-shadow: 0 0 6px 0 #cc0052;\n");
        out.write("                color: #cc0052;\n");
        out.write("            }\n");
        out.write("            .item {\n");
        out.write("                position: relative;\n");
        out.write("                margin: 10px 0;\n");
        out.write("            }\n");
        out.write("            .btn-block {\n");
        out.write("                margin-top: 10px;\n");
        out.write("                text-align: center;\n");
        out.write("            }\n");
        out.write("            button {\n");
        out.write("                width: 150px;\n");
        out.write("                padding: 10px;\n");
        out.write("                border: none;\n");
        out.write("                border-radius: 5px;\n");
        out.write("                background: #cc0052;\n");
        out.write("                font-size: 16px;\n");
        out.write("                color: #fff;\n");
        out.write("                cursor: pointer;\n");
        out.write("            }\n");
        out.write("            button:hover {\n");
        out.write("                background: #ff0066;\n");
        out.write("            }\n");
        out.write("            @media (min-width: 568px) {\n");
        out.write("                .name-item, .contact-item {\n");
        out.write("                    display: flex;\n");
        out.write("                    flex-wrap: wrap;\n");
        out.write("                    justify-content: space-between;\n");
        out.write("                }\n");
        out.write("                .contact-item .item {\n");
        out.write("                    width: calc(50% - 8px);\n");
        out.write("                }\n");
        out.write("                .name-item input {\n");
        out.write("                    width: calc(50% - 20px);\n");
        out.write("                }\n");
        out.write("                .contact-item input {\n");
        out.write("                    width: calc(100% - 12px);\n");
        out.write("                }\n");
        out.write("            }\n");
        out.write("        </style>\n");
        out.write("        <script>\n");
        out.write("\n");
        out.write("        </script>\n");
        out.write("    </head>\n");
        out.write("    <body>\n");
        out.write("        <div class=\"testbox\">\n");
        out.write("            <form name = \"updatecustomer\"action=\"updatecustomer?option=getdata\" method = \"post\">");
        out.write("                <div class=\"banner\">\n");
        out.write("                    <h1>Update Customer Form</h1>\n");
        out.write("                </div>\n");
        out.write("                <div class=\"item\">\n");
        out.write("                    <label for = \"id\">Id</label>\n");
        out.write("                    <div class=\"name-item\">\n");
        out.write("                        <input type=\"text\" name=\"id\" id = \"id\" value=\"" + customer.getId() + "\" readonly />\n");
        out.write("                    </div>\n");
        out.write("                </div>\n");
        out.write("                <div class=\"item\">\n");
        out.write("                    <label for = \"name\">Name</label>\n");
        out.write("                    <div class=\"name-item\">\n");
        out.write("                        <input type=\"text\" name=\"name\" id = \"name\" value = \"" + customer.getName() + "\"  placeholder=\"Enter the Customer name\" />\n");
        out.write("                    </div>\n");
        out.write("                </div>\n");
        out.write("                <div class=\"contact-item\">\n");
        out.write("                    <div class=\"item\">\n");
        out.write("                        <label for = \"phone\">Phone no</label>\n");
        out.write("                        <input type=\"text\" name=\"phone\" placeholder=\"Enter the phone no\" value = \"" + customer.getPhone() + "\" />\n");
        out.write("                    </div>\n");
        out.write("\n");
        out.write("                </div>\n");
        out.write("                <div class=\"item\">\n");
        out.write("                    <label for = \"aadhaar\">Aadhaar no</label>\n");
        out.write("                    <input type=\"text\" name=\"aadhaar\" placeholder=\"Enter the Aadhaar no\" value = \"" + customer.getAadhaar() + "\" />\n");
        out.write("                </div>\n");
        out.write("                <div class=\"item\">\n");
        out.write("                    <label for = \"doorno\">Door no/House no</label>\n");
        out.write("                    <input type =\"text\" name = \"doorno\" placeholder=\"Enter the Door no/House no in \" value = \"" + customer.getAddress().getHouseNo() + "\" />\n");
        out.write("                    <!--<textarea rows=\"3\" required></textarea>-->\n");
        out.write("                </div>\n");
        out.write("                <div class=\"item\">\n");
        out.write("                    <label for = \"distric\">Distric</label>\n");
        out.write("                    <input type = \"text\" name = \"distric\" value = \"" + customer.getAddress().getDistric() + "\"/>\n");
        out.write("                </div>\n");
        out.write("                <div class=\"item\">\n");
        out.write("                    <label for = \"state\">State</label>\n");
        out.write("                    <input type=\"text\" name=\"state\" placeholder=\"Enter the State\" value = \"" + customer.getAddress().getState() + "\" />\n");
        out.write("                </div>\n");
        out.write("                <div class=\"item\">\n");
        out.write("                    <label for = \"country\">Country</label>\n");
        out.write("                    <input type=\"text\" name=\"country\" placeholder=\"Enter the Country\" value =  \"India\" readonly />\n");
        out.write("                </div>\n");
        out.write("                <div class=\"item\">\n");
        out.write("                    <label for = \"pincode\">Pincode</label>\n");
        out.write("                    <input type=\"text\" name=\"pincode\" placeholder=\"Enter the Pincode\" value = \"" + customer.getAddress().getPincode() + "\" />\n");
        out.write("                </div>\n");
        out.write("                <div class=\"btn-block\">\n");
//                    out.write("                    <button type=\"submit\" class=\"btn-success btn\" name=\"submit\" style=\"success\" id=\"submit\">UPDATE</button>\n");
        out.write("                    <input type=\"submit\" value = \"UPDATE\" name = \"submit\" id = \"submit\" />\n");
        out.write("                </div>\n");
        out.write("                </div>\n");

        out.write("                </div>\n");

        out.write("\n");
        out.write("\n");

        out.write("            </form>\n");
        out.write("        </div>\n");
        out.write("    </body>\n");
        out.write("</html>");
    }
}
