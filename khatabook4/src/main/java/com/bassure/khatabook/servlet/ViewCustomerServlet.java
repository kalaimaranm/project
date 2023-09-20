package com.bassure.khatabook.servlet;

import com.bassure.khatabook.dao.KhatabookDAO;
import jakarta.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import com.bassure.khatabook.mysql.MysqlKhatabookImplTest;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.bassure.khatabook.model.Customer;
import com.bassure.khatabook.model.Payment;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ViewCustomerServlet extends HttpServlet {

    KhatabookDAO khatabookDAO = new MysqlKhatabookImplTest();
    static Customer customer;
    PrintWriter out;

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        out = response.getWriter();
        String option = request.getParameter("option");
        switch (option) {

            case "getdata": {
                try {
                    if (request.isUserInRole("CUSTOMER")) {
                        customer = khatabookDAO.getCustomer().getCustomerById(Integer.parseInt(request.getUserPrincipal().getName()));
//                        customer = khatabookDAO.getCustomer().getCustomerByPhoneNo(request.getParameter("phone"));
//                    } else if (Objects.nonNull(request.getSession().getAttribute("flag"))) {
//                        viewCustomer(khatabookDAO.getCustomer().getCustomerById(Integer.parseInt(request.getParameter("id"))), "profile");
                    } else if (request.isUserInRole("SHOPKEEPER")) {
                        customer = khatabookDAO.getCustomer().getCustomerById(Integer.parseInt(request.getParameter("customerid")));

                    }
                } catch (SQLException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
                if (Objects.nonNull(customer)) {
                    viewCustomer(customer, "profile");
                } else {
                    out.write("<br/><br/><br/><br/><div align = \"center\"><h1>Sorry Customer Detail Not found</h1> <button><a href = \"customerhome.html\">Back</a></button></div>");
                }
                break;
            }

            case "viewprofile": {

                break;
            }
            case "paydebtprofile": {
                try {
                    if (request.isUserInRole("SHOPKEEPER")) {
                        customer = khatabookDAO.getCustomer().getCustomerById(Integer.parseInt(request.getParameter("customerid")));
                    }
//                                      out.print("inside paydebprofile"+customer.getPhone());
                    if (request.isUserInRole("CUSTOMER")) {
                        customer = khatabookDAO.getCustomer().getCustomerById(Integer.parseInt(request.getUserPrincipal().getName()));
                    }
                    if (Objects.nonNull(customer) && customer.isStatus()) {   // dont wan't check here because if customer exist customer object created else null
                        viewCustomer(customer, "paydebt");
                    }

                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(ViewCustomerServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            case "paydebtamount": {
                double balanceDebt;
                try {
                    balanceDebt = khatabookDAO.getCustomer().getCustomerByPhoneNo(request.getParameter("phone")).getDebtBalance();
                    double amount = Double.parseDouble(request.getParameter("amount"));
                    String phone = request.getParameter("phone");
                    if (amount <= balanceDebt) {
                        if (khatabookDAO.getCustomer().payDebts(balanceDebt - amount, phone)) {
                            String dateTime = LocalDateTime.now().toString();
                            Payment payment = new Payment(0, customer.getId(), amount, dateTime, "debt");
                            khatabookDAO.getPayment().makePayment(payment);
                            out.println("<h1 align = 'center' bgcolor = 'green'><mark style=\"background-color:#3BEE2F\";>Your debt amount &#x20B9;" + amount + " is paid successfully</mark><br/> \n<mark style=\"background-color:#FAD905\";>Debt Balance is " + khatabookDAO.getCustomer().getCustomerBalance(phone) + "</mark></h1>");
                            out.write("<div align = \"center\"><button><a href = \"viewcustomer?option=home\">Back</a></button></div>");

                        }
                    } else {
                        out.print("<h1 align = 'center' style=\"background-color:#F5230E\";>Entered amount &#x20B9; "+amount+"is higher than the debt balance</h1>");
                        out.write("<div align = \"center\"><button><a href = \"viewcustomer?option=home\">Back</a></button></div>");

                    }

                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(ViewCustomerServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            case "home": {
                if (request.isUserInRole("CUSTOMER")) {
                    response.sendRedirect("customerhome.html");
                } else if (request.isUserInRole("SHOPKEEPER")) {
                    response.sendRedirect("shopkeeperhome.html");
                }

                break;
            }
            case "logout" :{
                request.getSession().invalidate();
                response.sendRedirect("roleselectorservlet");
                break;
            }

        }

    }

    public void setCustomer(Customer setCustomer) {
        customer = setCustomer;
    }

    public void viewCustomer(Customer customer, String requestFrom) {
        out.write("<!DOCTYPE html>\n");
        out.write("<html lang=\"en\" >\n");
        out.write("    <head>\n");
        out.write("        <meta charset=\"UTF-8\">\n");
        out.write("        <title>CodePen - Student Profile</title>\n");
        out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
        out.write("\n");
        out.write("        <link href=\"https://fonts.googleapis.com/css?family=Lato:300,400,700,900&display=swap\" rel=\"stylesheet\"><link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css'>\n");
        out.write("        <!--<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css'><link rel=\"stylesheet\" href=\"./style.css\">-->\n");
        out.write("        <style>\n");
        out.write("            body {\n");
        out.write("                padding: 0;\n");
        out.write("                margin: 0;\n");
        out.write("                font-family: 'Lato', sans-serif;\n");
        out.write("                color: #000;\n");
        out.write("            }\n");
        out.write("\n");
        out.write("            .student-profile .card {\n");
        out.write("                border-radius: 10px;\n");
        out.write("            }\n");
        out.write("\n");
        out.write("            .student-profile .card .card-header .profile_img {\n");
        out.write("                width: 150px;\n");
        out.write("                height: 150px;\n");
        out.write("                object-fit: cover;\n");
        out.write("                margin: 10px auto;\n");
        out.write("                border: 10px solid #ccc;\n");
        out.write("                border-radius: 50%;\n");
        out.write("            }\n");
        out.write("\n");
        out.write("            .student-profile .card h3 {\n");
        out.write("                font-size: 20px;\n");
        out.write("        paydebtamount        font-weight: 700;\n");
        out.write("            }\n");
        out.write("\n");
        out.write("            .student-profile .card p {\n");
        out.write("                font-size: 16px;\n");
        out.write("                color: #000;\n");
        out.write("            }\n");
        out.write("\n");
        out.write("            .student-profile .table th,\n");
        out.write("            .student-profile .table td {\n");
        out.write("                font-size: 14px;\n");
        out.write("                padding: 5px 10px;\n");
        out.write("                color: #000;\n");
        out.write("            }\n");
        out.write("            .button-67 {\n");
        out.write("            align-items: center;\n");
        out.write("            background: #CCD1D1;\n");
        out.write("            /*background: #C39BD3;*/\n");
        out.write("            /*background: #f5f5fa;*/\n");
        out.write("            border: 0;\n");
        out.write("            border-radius: 8px;\n");
        out.write("            box-shadow: -10px -10px 30px 0 #fff,10px 10px 30px 0 #1d0dca17;\n");
        out.write("            box-sizing: border-box;\n");
        out.write("            color: #2a1f62;\n");
        out.write("            cursor: pointer;\n");
        out.write("            display: flex;\n");
        out.write("            font-family: \"Cascadia Code\",Consolas,Monaco,\"Andale Mono\",\"Ubuntu Mono\",monospace;\n");
        out.write("            font-size: 1rem;\n");
        out.write("            justify-content: center;\n");
        out.write("            line-height: 1.5rem;\n");
        out.write("            padding: 15px;\n");
        out.write("            position: relative;\n");
        out.write("            text-align: left;\n");
        out.write("            transition: .2s;\n");
        out.write("            user-select: none;\n");
        out.write("            -webkit-user-select: none;\n");
        out.write("            touch-action: manipulation;\n");
        out.write("            white-space: pre;\n");
        out.write("            width: max-content;\n");
        out.write("            word-break: normal;\n");
        out.write("            word-spacing: normal;\n");
        out.write("            }\n");
        out.write("\n");
        out.write("            .button-67:hover {\n");
        out.write("            background: #f8f8ff;\n");
        out.write("            box-shadow: -15px -15px 30px 0 #fff, 15px 15px 30px 0 #1d0dca17;\n");
        out.write("            }\n");
        out.write("\n");
        out.write("            @media (min-width: 768px) {\n");
        out.write("            .button-67 {\n");
        out.write("            padding: 24px;\n");
        out.write("            }\n");
        out.write("            }\n");
        out.write("\n");
        out.write("        </style>\n");
        out.write("    </head>\n");
        out.write("    <body>\n");
        out.write("        <!-- partial:index.partial.html -->\n");
        out.write("        <!-- Student Profile -->\n");
        out.write("        <div class=\"student-profile py-4\">\n");
        out.write("            <div class=\"container\">\n");
        out.write("                <div class=\"row\">\n");
        out.write("                    <div class=\"col-lg-4\">\n");
        out.write("                        <div class=\"card shadow-sm\">\n");
        out.write("                            <div class=\"card-header bg-transparent text-center\">\n");
        out.write("                                <img class=\"profile_img\" src=\"https://placeimg.com/640/480/arch/any\" alt=\"\">\n");
        out.write("                                <h3>" + customer.getName() + "</h3>\n");
        out.write("                            </div>\n");
        out.write("                            <div class=\"card-body\">\n");
        out.write("                                <p class=\"mb-0\"><strong class=\"pr-1\">Customer ID:</strong>" + customer.getId() + "</p>\n");
        out.write("                                <p class=\"mb-0\"><strong class=\"pr-1\">Status:</strong>" + (customer.isStatus() ? "Active" : "InActive") + "</p>\n");
        out.write("                            </div>\n");
        out.write("                        </div>\n");
        out.write("                    </div>\n");
        out.write("                    <div class=\"col-lg-8\">\n");
        out.write("                        <div class=\"card shadow-sm\">\n");
        out.write("                            <div class=\"card-header bg-transparent border-0\">\n");
        out.write("                                <h3 class=\"mb-0\"><i class=\"far fa-clone pr-1\"></i>General Information</h3>\n");
        out.write("                            </div>\n");
        out.write("                            <div class=\"card-body pt-0\">\n");
        out.write("                                <table class=\"table table-bordered\">\n");
        out.write("                                    <tr>\n");
        out.write("                                        <th width=\"30%\">Phone no</th>\n");
        out.write("                                        <td width=\"2%\">:</td>\n");
        out.write("                                        <td>" + customer.getPhone() + "</td>\n");
        out.write("                                    </tr>\n");
        out.write("                                    <tr>\n");
        out.write("                                        <th width=\"30%\">Aadhaar No	</th>\n");
        out.write("                                        <td width=\"2%\">:</td>\n");
        out.write("                                        <td>" + customer.getAadhaar() + "</td>\n");
        out.write("                                    </tr>\n");
        out.write("                                    <tr>\n");
        out.write("                                        <th width=\"30%\">Gender</th>\n");
        out.write("                                        <td width=\"2%\">:</td>\n");
        out.write("                                        <td>Male</td>\n");
        out.write("                                    </tr>\n");
        out.write("                                    <tr>\n");
        out.write("                                        <th width=\"30%\">Debt Balance</th>\n");
        out.write("                                        <td width=\"2%\">:</td>\n");
        out.write("                                        <td>" + customer.getDebtBalance() + "</td>\n");
        out.write("                                    </tr>\n");
//        out.write("                                    <tr>\n");
//        out.write("                                        <th width=\"30%\">Wallet Balance</th>\n");
//        out.write("                                        <td width=\"2%\">:</td>\n");
//        out.write("                                        <td>" + customer.getWalletBalance() + "</td>\n");
//        out.write("                                    </tr>\n");
        out.write("                                </table>\n");
        out.write("                            <div class=\"card-header bg-transparent border-0\">\n");
        out.write("                                <h3 class=\"mb-0\"><i class=\"far fa-clone pr-1\"></i>Address</h3>\n");
        out.write("                            </div>\n");
        out.write("                                <table class=\"table table-bordered\">\n");
        out.write("                                    <tr>\n");
        out.write("                                        <th width=\"30%\">Door/House no</th>\n");
        out.write("                                        <td width=\"2%\">:</td>\n");
        out.write("                                        <td>" + customer.getAddress().getHouseNo() + "</td>\n");
        out.write("                                    </tr>\n");
        out.write("                                    <tr>\n");
        out.write("                                        <th width=\"30%\">Street	</th>\n");
        out.write("                                        <td width=\"2%\">:</td>\n");
        out.write("                                        <td>" + customer.getAddress().getStreet() + "</td>\n");
        out.write("                                    </tr>\n");
        out.write("                                    <tr>\n");
        out.write("                                        <th width=\"30%\">Distric</th>\n");
        out.write("                                        <td width=\"2%\">:</td>\n");
        out.write("                                        <td>" + customer.getAddress().getDistric() + "</td>\n");
        out.write("                                    </tr>\n");
        out.write("                                    <tr>\n");
        out.write("                                        <th width=\"30%\">State</th>\n");
        out.write("                                        <td width=\"2%\">:</td>\n");
        out.write("                                        <td>" + customer.getAddress().getState() + "</td>\n");
        out.write("                                    </tr>\n");
        out.write("                                    <tr>\n");
        out.write("                                        <th width=\"30%\">Pincode</th>\n");
        out.write("                                        <td width=\"2%\">:</td>\n");
        out.write("                                        <td>" + customer.getAddress().getPincode() + "</td>\n");
        out.write("                                    </tr>\n");
        out.write("                                </table>\n");
        out.write("                                </table>\n");
        out.write("                            </div>\n");
        out.write("                    </div>\n");
        out.write("                </div>\n");
        out.write("            </div>\n");
        out.write("        </div>\n");
        out.write("\n");
        if (requestFrom.equals("paydebt") && customer.getDebtBalance() != 0) {
            out.write("<form name = \"paydebt\" action=\"viewcustomer?option=paydebtamount&phone=" + customer.getPhone() + "\" method = \"post\">");
            out.write("&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <label for='amount' name = 'paydebt'>Debt Amount</label><input name = 'amount' type='number'/><br />&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;"
                    + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                    + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                    + "<input type = 'submit' value = 'Pay Debt' /></form>");
//            out.write("            <form name = paydebt action= 'viewcustomer?option=paydebtamount"+ "&phone=" + customer.getPhone() + "'>  "
//                    + "<label for='amount' name = 'paydebt'>Debt Amount</label><input name = 'amount' type='number'/><br /><input type = 'submit' value = 'Pay Debt' /></form>\n");
        }//<button class=\"button-67\" type = \"button\" role=\"button\">          </button>
        if (requestFrom.equals("deletecustomer") && customer.getDebtBalance() == 0) {
            out.write("<h1 align = 'center'> Confirm your account and Press delete button</h1>");
            out.write("<a href=\"deletecustomer?option=confirmation\" class=\"w3-button w3-black\"><button class=\"w3-button w3-black\">delete</button></a><br/><br/>\n");
        } else if (requestFrom.equals("deletecustomer") && customer.getDebtBalance() != 0) {
            out.write("<div bgcolor = 'red'><h1>Sorry customer have debt balance Rs. " + customer.getDebtBalance()
                    + "\nCustomer Have to pay debt balance to delete account </h1></div>");
        }
        out.write("<div align = \"center\"><button><a href = \"viewcustomer?option=home\">Home</a></button></div>");
//        out.write("    <div align = \"center\"><a href = \"\"></a></div>\n");
        out.write("    </body>\n");
        out.write("</html>");
    }
}
