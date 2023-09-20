package com.bassure.khatabook.servlet;

import com.bassure.khatabook.dao.KhatabookDAO;
import com.bassure.khatabook.model.Customer;
import com.bassure.khatabook.mysql.MysqlKhatabookImpl;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DeleteCustomerServlet extends GenericServlet {

    static KhatabookDAO khatabook = new MysqlKhatabookImpl();
    static PrintWriter out;
    static Customer customer;
//    DeleteCustomerServlet deleteCustomer = new DeleteCustomerServlet();
    ServletRequest request;
    ServletResponse response;

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
       this.out = response.getWriter();

        String option = request.getParameter("option");

        switch (option) {
            case "menu": {
                // show menu
                getData();
                break;
            }
            case "getdata": {
                try {
                    // get phone no from user if availble send respective output and show customer detail page
                    customer = khatabook.getCustomer().getCustomerByPhoneNo(request.getParameter("phone"));
//                    DeleteCustomerServlet dc = new DeleteCustomerServlet();
//                    dc.service(request,response);
                    DeleteCustomerServlet.showCustomer(customer);

                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(DeleteCustomerServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

                break;
            }
            case "confirmation": {
                try {
                    // get confirmatio from user and delete the user and send response
                    if (khatabook.getCustomer().deleteCustomer(customer.getId())) {
                        out.print("<div bgcolor = 'green'><h1>Account deleted successfully...</h1></div>");
                    } else {
                        out.print("<div bgcolor = 'red'><h1>Account deletion Failed...</h1></div>");
                    }
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(DeleteCustomerServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
        }
//          if(request.getParameter("")){
//    }

    }

    public static boolean showCustomer(Customer customer) throws SQLException, ClassNotFoundException, ServletException, IOException {
//       out = out;
//        customer = khatabook.getCustomer().getCustomerByPhoneNo(phone);
        if (Objects.nonNull(customer)) {
//            ViewCustomerServlet viewCustomerServlet = new ViewCustomerServlet();
            viewCustomer(customer, "deletecustomer");
//            viewCustomerServlet.setCustomer(customer);
//            viewCustomerServlet.service(request, response);  

        } else {
            out.print("<h1>Sorry, Customer detail not Found...</h1>");
        }

        return false;
    }

    public boolean deleteCustomer(String phone) throws SQLException, ClassNotFoundException {
        if (customer.getDebtBalance() == 0) {

        }
        if (khatabook.getCustomer().deleteCustomer(customer.getId())) {
            out.print("<h1>Your account deleted successfully...</h1>");
        } else {
            out.print("Sorry customer have debt balance Rs. "
                    + khatabook.getCustomer().getCustomerBalance(phone)
                    + "\nCustomer Have to pay debt balance to delete account ");
        }
        return false;
    }

    public static void getData() throws IOException {
//        response.getWriter();
        out.print("<!DOCTYPE html>\n");
        out.print("<html>");
        out.print("<head>");
        out.print("<title>Enter Customer Detail </title>\n");
        out.print("<meta charset=\"UTF-8\">\n");
        out.print("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
        out.print(" </head>\n");
        out.print("<body>\n");
        out.print("<form name = \"viewcustomer\" action=\"deletecustomer?option=getdata\" method = \"post\">\n");
        out.print("<div class=\"viewcustomer\">\n");
        out.print("<div class=\"container1\">");
        out.print("<h1 id=\"control-7823122\" align = \"center\">Enter Customer phone no</h1></div>");
        out.print(" <div class=\"container2\">");
        out.print("<label for=\"phone\" class=\"formbuilder-text-label\">phone no<span class=\"formbuilder-required\">*</span></label>\n");
        out.print("<input type=\"text\" placeholder=\"Enter Your Registered phone no\" class=\"form-control\" name=\"phone\" id=\"phone\" required=\"required\" aria-required=\"true\">");
        out.print("</div>");
        out.print(" <div class=\"formbuilder-button form-group field-submit\">");
        out.print("<button type=\"submit\" class=\"btn-success btn\" name=\"submit\" style=\"success\" id=\"submit\">submit</button>");
        out.print("</div>");
        out.print("</div>");
        out.print("</form>");
        out.print("</body>");
        out.print("</html>");
    }
        public static void viewCustomer(Customer customer, String requestFrom) {
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
        out.write("                font-weight: 700;\n");
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
        out.write("                                    <tr>\n");
        out.write("                                        <th width=\"30%\">Wallet Balance</th>\n");
        out.write("                                        <td width=\"2%\">:</td>\n");
        out.write("                                        <td>" + customer.getWalletBalance() + "</td>\n");
        out.write("                                    </tr>\n");
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
        out.write("        <!-- partial -->\n");
        out.write("\n");
        if (requestFrom.equals("deletecustomer") && customer.getDebtBalance() == 0) {
            out.write("<h1 align = 'center'> Confirm your account and Press delete button</h1>");
            out.write("<div align = 'center'><a href=\"deletecustomer?option=confirmation\" class=\"w3-button w3-black\" ><button class=\"w3-button w3-black\" >delete</button></a></div><br/><br/>\n");
        } else if (requestFrom.equals("deletecustomer") && customer.getDebtBalance() != 0) {
            out.write("<div bgcolor = 'red'><h1>Sorry customer have debt balance Rs. " + customer.getDebtBalance()
                    + "\nCustomer Have to pay debt balance to delete account </h1></div>");
        }
        out.write("    </body>\n");
        out.write("</html>");
    }
}
