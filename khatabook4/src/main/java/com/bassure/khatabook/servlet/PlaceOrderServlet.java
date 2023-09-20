package com.bassure.khatabook.servlet;

import com.bassure.khatabook.dao.KhatabookDAO;
import com.bassure.khatabook.model.Customer;
import com.bassure.khatabook.model.LineItem;
import com.bassure.khatabook.model.Order;
import com.bassure.khatabook.model.Payment;
import com.bassure.khatabook.model.Product;
import com.bassure.khatabook.mysql.MysqlKhatabookImplTest;
import static com.bassure.khatabook.servlet.OrderManagement.payment;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Objects;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlaceOrderServlet extends HttpServlet {

    PrintWriter out;
    KhatabookDAO khatabook = new MysqlKhatabookImplTest();
    HashMap<Integer, Product> products;
    Map<Integer, LineItem> lineItem;
    Order order;
    double tempTotal;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, IOException {
        out = response.getWriter();
        out.write("<!DOCTYPE html>\n");
        out.write("<html lang=\"en\" >\n");
        out.write("    <head>\n");
        String option = request.getParameter("option");
        switch (option) {
            case "view": {
                try {

                    if (Objects.isNull(request.getSession().getAttribute("products"))) {
                        request.getSession().setAttribute("products", khatabook.getProduct().getAllProduct());

                    }
                    if (Objects.isNull(request.getSession().getAttribute("customer"))) {    //stoped
                        request.setAttribute("customer", khatabook.getCustomer()
                                .getCustomerById(Integer.parseInt(request.getUserPrincipal().getName())));
                    }
                    products = new HashMap<>();
                    products = (HashMap<Integer, Product>) request.getSession().getAttribute("products");
                    viewProduct(products);
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(PlaceOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }

            case "addlineitem": {
                if (Objects.isNull(request.getSession().getAttribute("lineItem"))) {
                    HashMap<Integer, LineItem> lineItem = new HashMap<>();
                    request.getSession().setAttribute("lineItem", lineItem);
                    request.getSession().setAttribute("total", 0);
                }
                int productId = Integer.parseInt(request.getParameter("id"));
                lineItem = (HashMap<Integer, LineItem>) request.getSession().getAttribute("lineItem");
                if (lineItem.containsKey(productId)) {//you dont need to check product quantity add card button will be disable if product quantity = 0
                    lineItem.get(productId).setQuantity(lineItem.get(productId).getQuantity() + 1);
                } else if ((!lineItem.containsKey(productId)) && Objects.nonNull(products) && products.get(productId).getQuantity() > 0) {  // don't need check objects.nonull(products)
                    lineItem.put(Integer.valueOf(products.get(productId).getId()), new LineItem(0, products.get(productId).getId(), 1, products.get(productId).getName(), products.get(productId).getPrice()));
                }
                products.get(productId).setQuantity(products.get(productId).getQuantity() > 0 ? products.get(productId).getQuantity() - 1 : 0);
                LineItem[] lineItemTotal = lineItem
                        .values()
                        .toArray(new LineItem[lineItem.size()]);
                tempTotal = 0;
                for (LineItem tempLineItem : lineItemTotal) {
                    tempTotal = tempTotal + tempLineItem.getQuantity() * tempLineItem.getPrice();
                }
                request.getSession().setAttribute("total", tempTotal);
                request.getSession().setAttribute("products", products);
                request.getSession().setAttribute("lineItem", lineItem);
                viewProduct(products);
                lineItem(lineItem);
                break;
            }
            // deleting the products after adding to cart and increase in products[]
            case "delete": {

                // reduce the product quantity from products and reduce amount in total bill
                int productId = Integer.parseInt(request.getParameter("id"));
                if (lineItem.get(productId).getQuantity() > 0) {
                    lineItem.get(productId).setQuantity(lineItem.get(productId).getQuantity() - 1);
                    request.getSession().setAttribute("total", (Double) request.getSession().getAttribute("total") - products.get(productId).getPrice());
                    tempTotal = (Double) request.getSession().getAttribute("total");
                    out.println("inside quantity reduce check");
                }
                //  Increasing one quantity to product
                if (products.containsKey(productId) && products.get(productId).getQuantity() >= 0) {
                    products.get(productId).setQuantity(products.get(productId).getQuantity() + 1);
                    out.println("inside product quantity increase check");
                }
                request.getSession().setAttribute("lineItem", lineItem);
                request.getSession().setAttribute("products", products);
                viewProduct(products);
                lineItem(lineItem);
                break;
            }

            case "placeyourorder": {
                if (tempTotal > 0) {
                    HashMap<Integer, LineItem> lineItemTemp = (HashMap<Integer, LineItem>) request.getSession().getAttribute("lineItem");
                    LineItem[] lineItem = lineItemTemp.values().toArray(new LineItem[lineItemTemp.size()]);
                    try {
                        order = new Order(khatabook.getorder().genOrderID(), ((Customer) request.getSession().getAttribute("customer")).getId(), tempTotal, LocalDateTime.now().toString(), "", lineItem);
                        order.setStatus(request.isUserInRole("CUSTOMER") ? "Pending" : "successfull");
                        request.getSession().setAttribute("order", order);
                        if (request.isUserInRole("CUSTOMER")
                                && khatabook.getorder().orderEntry(order)
                                && khatabook.getLineItem().lineItemEntry(order)
                                && khatabook.getProduct().productEntry(order)) {

                            request.getSession().removeAttribute("customer");
                            request.getSession().removeAttribute("order");
                            request.getSession().removeAttribute("total");
                            request.getSession().removeAttribute("lineItem");
                            request.getSession().removeAttribute("products");
                            out.println("<br/><br/><br/><br/><div align = \"center\"> <h1> Order Placed Successfully </h1><br/><h1>Please wait for confirmation from shop</h1>"
                                    + "<button><a href = \"customerhome.html\">Home</a></button>"
                                    + "<button> <a href = \"placeorder?option=orderhistory\">order history</a></button></div>");
                        } else {
                            out.println("<br/><br/><br/><br/><div align = \"center\"><h1>Order Failed...</h1>"
                                    + "<button><a href = \"customerhome.html\">Home</a></button></div>");
                        }
                        if (request.isUserInRole("SHOPKEEPER")) {
                            paymentOption(order);
                        }
                    } catch (ClassNotFoundException | SQLException ex) {
                        Logger.getLogger(PlaceOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
                    out.print("<h1 align = \"center\">Sorry, Your cart is empty <br/>Please add item to cart </h1>");
                }
                break;
            }
            case "paymentoption": {

                try {
                    paymentOption(khatabook.getorder().getOrderById(Integer.parseInt(request.getParameter("orderid"))));
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(PlaceOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            case "payment": {
                String paymentOption = request.getParameter("paymentoption");
                double totalAmount = tempTotal;
                if (request.isUserInRole("CUSTOMER") && Objects.nonNull(request.getParameter("orderid"))) {
                    try {
                        order = khatabook.getorder().getOrderById(Integer.parseInt(request.getParameter("orderid")));
                    } catch (ClassNotFoundException | SQLException ex) {
                        Logger.getLogger(PlaceOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (!paymentOption.equals("paylater")) {
                    totalAmount = Double.parseDouble(request.getParameter("amount"));
                    totalAmount = totalAmount == order.getTotal() ? totalAmount : order.getTotal() - totalAmount;
                }
                payment = new Payment(order.getId(),
                        order.getCustomerID(),
                        order.getTotal(), LocalDateTime.now().toString(), "order");
                try {
                    if (request.isUserInRole("SHOPKEEPER") && (paymentOption.equals("paylater") || paymentOption.equals("partial"))
                            && khatabook.getorder().orderEntry(order)
                            && khatabook.getLineItem().lineItemEntry(order)
                            && khatabook.getPayment().makePayment(payment)
                            && khatabook.getCustomer().updateCustomerBalance(((Customer) request.getSession().getAttribute("customer")).getPhone(), totalAmount)
                            && khatabook.getProduct().productEntry(order)) {
                        order = (Order) request.getSession().getAttribute("order");
                        request.getSession().removeAttribute("customer");
                        request.getSession().removeAttribute("order");
                        request.getSession().removeAttribute("total");
                        request.getSession().removeAttribute("lineItem");
                        request.getSession().removeAttribute("products");
                        String user = "SHOPKEEPER";
                        viewInvoice(order, user);
                    } else if (request.isUserInRole("CUSTOMER")
                            && khatabook.getPayment().makePayment(payment)
                            && khatabook.getCustomer().updateCustomerBalance(khatabook.getCustomer().getCustomerById(order.getCustomerID()).getPhone(), totalAmount)
                            && khatabook.getorder().updateOrderStatus("successfull", order.getId())) {
                        out.println("<br/><br/><br/><div align = \"center\"><h1>Payment Successfull...</h1>"
                                + "<button><a href = \"customerhome.html\">Home</a></button></div>");
                    } else {
                        out.print("<h1 align = \"center\">Sorry, order & payment failed...</h1>");
                    }
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(PlaceOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            case "invoice": {
                try {
                    int orderId = Integer.parseInt(request.getParameter("orderid"));
                    String userRole = request.isUserInRole("CUSTOMER") ? "CUSTOMER" : "SHOPKEEPER";
                    viewInvoice(khatabook.getorder().getOrderById(orderId), userRole);
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(PlaceOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            case "orderhistory": {
                try {
                    orderHistory(Integer.parseInt(request.getUserPrincipal().getName()));
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(PlaceOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }

            case "pendingorder": {
                try {
                    pendingOrders(khatabook.getorder().getAllPendingOrders());
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(PlaceOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            case "approveorder": {
                try {
                    if (khatabook.getorder().updateOrderStatus("Accepted", Integer.parseInt(request.getParameter("orderid")))) {
                        response.sendRedirect("placeorder?option=pendingorder");
                    } else {
                        response.sendRedirect("placeorder?option=pendingorder");
                    }

                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(PlaceOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
            case "rejectorder": {
                int orderId = Integer.parseInt(request.getParameter("orderid"));
                Order order = null;
                try {
                    order = khatabook.getorder().getOrderById(orderId);
                    if (khatabook.getorder().increaseProductQuantity(order)
                            && khatabook.getorder().updateOrderStatus("Cancelled", orderId)) {
                        response.sendRedirect("placeorder?option=pendingorder");
                    }
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(PlaceOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

                break;
            }

        }

    }

    void viewProduct(HashMap<Integer, Product> products) {
        out.print("<table align=\"center\" border=1 rules=all>");
        out.print("    <th>");
        out.print("        <tr>");
        out.print("            <th>Id</th>");
        out.print("            <th>Name</th>");
        out.print("            <th>Price</th>");
        out.print("            <th>Weight</th>");
        out.print("            <th>Quantity</th>");
        out.print("            <th colspan=\"2\">Update Qty</th>");
        out.print("        </tr> ");
        out.print("    </th> ");

        for (Product tempProduct : products.values()) {
            if (tempProduct.isStatus()) {
                out.print("<tr>");
                out.print("<td>" + tempProduct.getId() + "</td>");
                out.print("<td>" + tempProduct.getName() + "</td>");
                out.print("<td>" + tempProduct.getPrice() + "</td>");
                out.print("<td>" + tempProduct.getWeight() + "</td>");
                out.print("<td>" + tempProduct.getQuantity() + "</td>");
                if (tempProduct.getQuantity() > 0) {
                    out.print("<td><a href=placeorder?id=" + tempProduct.getId() + "&option=addlineitem>Add to Cart</a></td>");
                    out.print("</tr>");
                } else {
                    out.print("<td><a>sold out</a></td>");
                    out.print("</tr>");
                }
            }
        }
        out.print("</table>");
        out.println("<br>");
        out.println("<br>");
        out.println("<br>");
        out.println("<br>");
    }

    public void lineItem(Map<Integer, LineItem> lineItem) { //lineitem is not empty na show or dont show 
        if (Objects.nonNull(lineItem)) {
            if (!lineItem.isEmpty()) {
                out.print("<table align= 'center' border=1 rules=all>");
                out.print("<table>");
                out.print("    <th>");
                out.print("        <tr>");
                out.print("            <th colspan=all>S.No</th>");
                out.print("            <th>Product Id</th>");
                out.print("            <th>Name</th>");
                out.print("            <th>Quantity</th>");
                out.print("            <th>Price</th>");
                out.print("            <th>Remove</th>");
                out.print("        </tr> ");
                out.print("    </th> ");
            }

            int sNo = 0;
            for (LineItem tempLineItem : lineItem.values()) {
                if (tempLineItem.getQuantity() > 0) {
                    out.print("<tr>");
                    out.print("<td>" + ++sNo + "</td>");
                    out.print("<td>" + tempLineItem.getProductID() + "</td>");
                    out.print("<td>" + tempLineItem.getProductName() + "</td>");
                    out.print("<td>&nbsp;&nbsp;&nbsp;" + tempLineItem.getQuantity() + "</td>");
                    out.print("<td>" + tempLineItem.getPrice() + "</td>");
                    out.print("<td><a href = \"placeorder?option=delete&id=" + tempLineItem.getProductID() + "\">" + "Remove" + "</a></td>");
                    out.print("</tr>");
                }

            }
            out.print("</table>");
            if (!lineItem.isEmpty()) {
                out.println(" <form  action=\"placeorder?option=placeyourorder\"> \n"
                        + "<label for=\"total\">Total Amount<label><br/><input type = text value = \"" + tempTotal + "\" readonly />"
                        + "            <a href = placeorder?option=placeyourorder>Place Your Order</a> \n"
                        + "        </form>\n"
                        + " ");// /Check out & Payment
            }
        }
    }

    public void paymentOption(Order order) {
        out.write("\n");
        out.write("\n");
        out.write("\n");
        out.write("<html>\n");
        out.write("    <head>\n");
        out.write("        <title>TODO supply a title</title>\n");
        out.write("        <meta charset=\"UTF-8\">\n");
        out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
        out.write("        <style>\n");
        out.write("            body{\n");
        out.write("                background-color: #ffffff;\n");
        out.write("\n");
        out.write("            }\n");
        out.write("            .container{\n");
        out.write("                width: 600px;\n");
        out.write("                background-color: #fff;\n");
        out.write("                padding-top: 100px;\n");
        out.write("                padding-bottom: 100px;\n");
        out.write("\n");
        out.write("            }\n");
        out.write("            .card{\n");
        out.write("                background-color: #fff;\n");
        out.write("                width: 300px;\n");
        out.write("                border-radius: 15px;\n");
        out.write("                box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);\n");
        out.write("            }\n");
        out.write("            .name{\n");
        out.write("                font-size: 15px;\n");
        out.write("                color: #403f3f;\n");
        out.write("                font-weight: bold;\n");
        out.write("            }\n");
        out.write("            .cross{\n");
        out.write("                font-size: 11px;\n");
        out.write("                color: #b0aeb7;\n");
        out.write("            }\n");
        out.write("            .pin{\n");
        out.write("                font-size: 14px;\n");
        out.write("                color: #b0aeb7;\n");
        out.write("            }\n");
        out.write("            .first{\n");
        out.write("                border-radius: 8px;\n");
        out.write("                border: 1.5px solid #78b9ff;\n");
        out.write("                color: #000;\n");
        out.write("                background-color: #eaf4ff;\n");
        out.write("            }\n");
        out.write("            .second{\n");
        out.write("                border-radius: 8px;\n");
        out.write("                border: 1px solid #acacb0;\n");
        out.write("                color: #000;\n");
        out.write("                background-color: #fff;\n");
        out.write("            }\n");
        out.write("            .dot{\n");
        out.write("\n");
        out.write("            }\n");
        out.write("            .head{\n");
        out.write("                color: #137ff3;\n");
        out.write("                font-size: 12px;\n");
        out.write("            }\n");
        out.write("            .dollar{\n");
        out.write("                font-size: 18px;\n");
        out.write("                color: #097bf7;\n");
        out.write("            }\n");
        out.write("            .amount{\n");
        out.write("                color: #007bff;\n");
        out.write("                font-weight: bold;\n");
        out.write("                font-size: 18px;\n");
        out.write("\n");
        out.write("            }\n");
        out.write("            .form-control{\n");
        out.write("                font-size: 18px;\n");
        out.write("                font-weight: bold;\n");
        out.write("                width: 100px;\n");
        out.write("                /*width: 60px;*/\n");
        out.write("                height: 28px;\n");
        out.write("\n");
        out.write("            }\n");
        out.write("            .back{\n");
        out.write("                color: #aba4a4;\n");
        out.write("                font-size: 15px;\n");
        out.write("                line-height: 73px;\n");
        out.write("                font-weight: 400;\n");
        out.write("            }\n");
        out.write("            .button{\n");
        out.write("                width: 150px;\n");
        out.write("                height: 60px;\n");
        out.write("                border-radius: 8px;\n");
        out.write("                font-size: 17px;\n");
        out.write("            }\n");
        out.write("        </style>\n");
        out.write("    </head>\n");
        out.write("\n");
        out.write("    <body>\n");
        out.write("        <div class = \"alignment\" align = \"center\">\n");
        out.write("            <div class=\"container d-flex justify-content-center mt-5\">\n");
        out.write("                <div class=\"card\">\n");
        out.write("\n");
        out.write("\n");
        out.write("\n");
        out.write("                    <div>\n");
        out.write("                        <div class=\"d-flex pt-3 pl-3\">\n");
        out.write("                            <!--&#xf42c;	&#xf1f0;-->	\n");
        out.write("\n");
        out.write("                            <!--<i class='fab fa-amazon-pay' style='font-size:48px;color:red'></i>-->\n");
        out.write("                            <div align = \"center\" ><img src=\"https://img.icons8.com/ios-filled/50/000000/visa.png\" width=\"60\" height=\"80\" /></div>\n");
        out.write("                            <!--                        <div><span class=\"cross\">&#10005&#10005&#10005&#10005</span><span class=\"pin ml-2\">8880</span></div></div>-->\n");
        out.write("                            <div class=\"mt-3 pl-2\"><span class=\"name\">Payment option</span>\n");
        out.write("                            </div><br/><br/>\n");
        out.write("\n");
        out.write("<form action = \"placeorder?option=payment&orderid=" + order.getId() + "\" method = \"post\">");
        out.write("\n");
        out.write("                            <div class=\"py-2  px-3\">\n");
        out.write("                                <div class=\"first pl-2 d-flex py-2\">\n");
        out.write("                                    <div class=\"form-check\">\n");
        out.write("                                        <input type=\"radio\" name=\"paymentoption\" value =\"paylater\" class=\"form-check-input mt-3 dot\" checked>\n");
        out.write("                                    </div>\n");
        out.write("                                    <div class=\"border-left pl-2\"><strong><span class=\"head\">Pay Later</span></strong><div><span class=\"dollar\">&#x20B9;</span><span class=\"amount\">" + order.getTotal() + "</span></div></div>\n");
        out.write("\n");
        out.write("                                </div>\n");
        out.write("                            </div>\n");
        out.write("\n");
        out.write("\n");
        out.write("                            <div class=\"py-2  px-3\">\n");
        out.write("                                <div class=\"second pl-2 d-flex py-2\">\n");
        out.write("                                    <div class=\"form-check\">\n");
        out.write("                                        <input type=\"radio\" name=\"paymentoption\" value =\"partial\" class=\"form-check-input mt-3 dot\">\n");
        out.write("                                    </div>\n");
        out.write("                                    <div class=\"border-left pl-2\"><strong><span class=\"head\">Partial/Full Payment</span></strong><div class=\"d-flex\"><span class=\"dollar\">&#x20B9;</span>"
                + "<input type=\"number\" name=\"amount\" class=\"form-control ml-1\" placeholder=\"0\"></div></div>\n");
        out.write("\n");
        out.write("                                </div> \n");
        out.write("                            </div>	\n");
        out.write("\n");
        out.write("\n");
        out.write("                            <div align = \"center\" class=\"d-flex justify-content-between px-3 pt-4 pb-3\">\n");
        out.write("<input type = \"submit\" name = \"submit\" value = \"proceed\"><br/><br/>");
        out.write("                            </div>\n");
        out.write("\n");
        out.write("\n");
        out.write("\n");
        out.write("                        </div>\n");
        out.write("                    </div>\n");
        out.write("</form>");
        out.write("\n");
        out.write("                </div>   </div> </body>\n");
        out.write("</html>\n");
    }

    public void viewInvoice(Order order, String user) {
        out.write("\n");
        out.write("\n");
        out.write("\n");
        out.write("<!DOCTYPE html>\n");
        out.write("\n");
        out.write("<html>\n");
        out.write("    <head>\n");
        out.write("        <title>TODO supply a title</title>\n");
        out.write("        <meta charset=\"UTF-8\">\n");
        out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
        out.write("        <style>#invoice-POS{\n");
        out.write("                box-shadow: 0 0 1in -0.25in rgba(0, 0, 0, 0.5);\n");
        out.write("                padding:2mm;\n");
        out.write("                margin: 0 auto;\n");
        out.write("                width: 94mm;\n");
        out.write("                /*width: 44mm;*/\n");
        out.write("                background: #FFF;\n");
        out.write("\n");
        out.write("\n");
        out.write("                ::selection {\n");
        out.write("                    background: #f31544;\n");
        out.write("                    color: #FFF;\n");
        out.write("                }\n");
        out.write("                ::moz-selection {\n");
        out.write("                    background: #f31544;\n");
        out.write("                    color: #FFF;\n");
        out.write("                }\n");
        out.write("                h1{\n");
        out.write("                    font-size: 1.5em;\n");
        out.write("                    color: #222;\n");
        out.write("                }\n");
        out.write("                h2{\n");
        out.write("                    font-size: .9em;\n");
        out.write("                }\n");
        out.write("                h3{\n");
        out.write("                    font-size: 1.2em;\n");
        out.write("                    font-weight: 300;\n");
        out.write("                    line-height: 2em;\n");
        out.write("                }\n");
        out.write("                p{\n");
        out.write("                    font-size: .7em;\n");
        out.write("                    color: #666;\n");
        out.write("                    line-height: 1.2em;\n");
        out.write("                }\n");
        out.write("\n");
        out.write("                #top, #mid,#bot{ /* Targets all id with 'col-' */\n");
        out.write("                    border-bottom: 1px solid #EEE;\n");
        out.write("                }\n");
        out.write("\n");
        out.write("                #top{\n");
        out.write("                    min-height: 100px;\n");
        out.write("                }\n");
        out.write("                #mid{\n");
        out.write("                    min-height: 80px;\n");
        out.write("                }\n");
        out.write("                #bot{\n");
        out.write("                    min-height: 50px;\n");
        out.write("                }\n");
        out.write("\n");
        out.write("                #top .logo{\n");
        out.write("                    /*//float: left;*/\n");
        out.write("                    height: 60px;\n");
        out.write("                    width: 60px;\n");
        out.write("                    background: url(http://michaeltruong.ca/images/logo1.png) no-repeat;\n");
        out.write("                    background-size: 60px 60px;\n");
        out.write("                }\n");
        out.write("                .clientlogo{\n");
        out.write("                    float: left;\n");
        out.write("                    height: 60px;\n");
        out.write("                    width: 60px;\n");
        out.write("                    background: url(http://michaeltruong.ca/images/client.jpg) no-repeat;\n");
        out.write("                    background-size: 60px 60px;\n");
        out.write("                    border-radius: 50px;\n");
        out.write("                }\n");
        out.write("                .info{\n");
        out.write("                    display: block;\n");
        out.write("                    /*//float:left;*/\n");
        out.write("                    margin-left: 0;\n");
        out.write("                }\n");
        out.write("                .title{\n");
        out.write("                    float: right;\n");
        out.write("                }\n");
        out.write("                .title p{\n");
        out.write("                    text-align: right;\n");
        out.write("                }\n");
        out.write("                table{\n");
        out.write("                    width: 100%;\n");
        out.write("                    border-collapse: collapse;\n");
        out.write("                }\n");
        out.write("                td{\n");
        out.write("                    /*                    //padding: 5px 0 5px 15px;\n");
        out.write("                                        //border: 1px solid #EEE*/\n");
        out.write("                }\n");
        out.write("                .tabletitle{\n");
        out.write("                    /*//padding: 5px;*/\n");
        out.write("                    font-size: .5em;\n");
        out.write("                    background: #EEE;\n");
        out.write("                }\n");
        out.write("                .service{\n");
        out.write("                    border-bottom: 1px solid #EEE;\n");
        out.write("                }\n");
        out.write("                .item{\n");
        out.write("                    width: 24mm;\n");
        out.write("                }\n");
        out.write("                .itemtext{\n");
        out.write("                    font-size: .5em;\n");
        out.write("                }\n");
        out.write("\n");
        out.write("                #legalcopy{\n");
        out.write("                    margin-top: 5mm;\n");
        out.write("                }\n");
        out.write("\n");
        out.write("\n");
        out.write("\n");
        out.write("            }</style>\n");
        out.write("    </head>\n");
        out.write("    <body>\n");
        out.write("\n");
        out.write("        <div id=\"invoice-POS\">\n");
        out.write("\n");
        out.write("            <center id=\"top\">\n");
        out.write("                <div class=\"logo\"></div>\n");
        out.write("                <div class=\"info\"> \n");
        out.write("                    <h2>DMart</h2>\n");
        out.write("                </div>\n");
        out.write("            </center>\n");
        out.write("\n");
        out.write("            <div id=\"mid\">\n");
        out.write("                <div class=\"info\">\n");
        out.write("                    <h2>Contact Info</h2>\n");
        out.write("                    <p> \n");
        out.write("                        Date      :" + LocalDate.now() + "<br/>");
        out.write("                        Time      :" + LocalTime.now() + "<br/>");
        out.write("                        Address   : Electronic city, Bangalore - 60</br>\n");
        out.write("                        Email     : DMart@gmail.com</br>\n");
        out.write("                        Phone     : +91-95673-90876</br>\n");
        out.write("                    </p>\n");
        out.write("                </div>\n");
        out.write("            </div><!--End Invoice Mid-->\n");
        out.write("\n");
        out.write("            <div id=\"bot\">\n");
        out.write("                <hr/>\n");
        out.write("                <div id=\"table\">\n");
        out.write("\n");
        out.write("                    <table>  \n");
        out.write("                        <tr class=\"tabletitle\">\n");
        out.write("                            <td class=\"item\"><h2>Item</h2></td>\n");
        out.write("                            <td class=\"Hours\"><h2>Qty</h2></td>\n");
        out.write("                            <td class=\"Rate\"><h2>Sub Total</h2></td>\n");
        out.write("\n");
        out.write("                        </tr>\n");
        for (LineItem lineItemTemp : order.getLineItem()) {
            if (lineItemTemp.getQuantity() > 0) {
                out.write("                        <tr class=\"service\">\n");
                out.write("                            <td class=\"tableitem\"><p class=\"itemtext\"> &nbsp;  &nbsp;  &nbsp;  &nbsp; " + lineItemTemp.getProductName() + "</p></td>\n");
                out.write("                            <td class=\"tableitem\"><p class=\"itemtext\"> &nbsp;  &nbsp;  &nbsp; " + lineItemTemp.getQuantity() + "</p></td>\n");
                out.write("                            <td class=\"tableitem\"><p class=\"itemtext\"> &nbsp;  &nbsp;  &nbsp; " + lineItemTemp.getQuantity() * lineItemTemp.getPrice() + "</td>\n");
                out.write("                        </tr>\n");
            }
        }
        out.write("                        <tr class=\"tabletitle\">\n");
        out.write("                            <td></td>\n");
        out.write("                            <td class=\"Rate\"> &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp; <h2>tax</h2></td><br/>\n");
        out.write("                            <td class=\"payment\"><h2>&#x20B9;0.00</h2></td>\n");
        out.write("                        </tr>\n");
        out.write("\n");
        out.write("                        <tr class=\"tabletitle\">\n");
        out.write("                            <td></td>\n");
        out.write("                            <td class=\"Rate\"> &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp; <h2>Total</h2></td><br/>\n");
        out.write("                            <td class=\"payment\"><h2>&#x20B9;" + order.getTotal() + "</h2></td>\n");
        out.write("                        </tr>\n");
        out.write("\n");
        out.write("                    </table>\n");
        out.write("                </div><!--End Table-->\n");
        out.write("                <hr/>\n");
        out.write("\n");
        out.write("                <div id=\"legalcopy\">\n");
        out.write("                    <p class=\"legal\" align = 'center'><strong>Thank you for your shopping!<br/>****Visit Again!**** </strong>  \n");
        out.write("                    </p>\n");
        out.write("                </div>\n");
        out.write("\n");
        out.write("            </div>\n");
        out.write("        </div>\n");
        if (user.equals("SHOPKEEPER")) {
            out.write("        <div align = \"center\"><button><a href = \"shopkeeperhome.html\" align = \"center\">Home</a></button></div>\n");
            out.write("                                                            <button><a href = \"placeorder?option=pendingorder\">Back</a></button>\n");
        } else if (user.equals("CUSTOMER")) {
            out.write("        <div align = \"center\"><button><a href = \"placeorder?option=orderhistory\" align = \"center\">Back</a></button></div>\n");
        }

        out.write("    </body>\n");
        out.write("</html>\n");
    }

    public void orderHistory(int customerId) throws SQLException, ClassNotFoundException {
        List<Order> orders = khatabook.getorder().getAllOrdersByCustomerId(customerId);
        out.write("\n");
        out.write("\n");
        out.write("\n");
        out.write("<!DOCTYPE html>\n");
        out.write("<html>\n");
        out.write("    <head>\n");
        out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
        out.write("        <title>Order History</title>\n");
        out.write("\n");
        out.write("        <style>\n");
        out.write("\n");
        out.write("            @import url('https://fonts.googleapis.com/css?family=Assistant');\n");
        out.write("            body {\n");
        out.write("                background: #eee;\n");
        out.write("                font-family: Assistant, sans-serif;\n");
        out.write("            }\n");
        out.write("\n");
        out.write("            .cell-1 {\n");
        out.write("                border-collapse: separate;\n");
        out.write("                border-spacing: 0 4em;\n");
        out.write("                background: #fff;\n");
        out.write("                border-bottom: 5px solid transparent;\n");
        out.write("                /*background-color: gold;*/\n");
        out.write("                background-clip: padding-box;\n");
        out.write("            }\n");
        out.write("\n");
        out.write("            thead {\n");
        out.write("                background: #dddcdc;\n");
        out.write("            }\n");
        out.write("\n");
        out.write("           \n");
        out.write("        </style>\n");
        out.write("    </head>\n");
        out.write("    <body>\n");
        out.write("    <h1 align = \"center\">Order History</h1>\n");
        out.write("        <br/><br/><br/><br/>\n");
        out.write("        <div align = \"center\">\n");
        out.write("            <div class=\"container mt-5\">\n");
        out.write("                <div class=\"d-flex justify-content-center row\">\n");
        out.write("                    <div class=\"col-md-10\">\n");
        out.write("                        <div class=\"rounded\">\n");
        out.write("                            <div class=\"table-responsive table-borderless\">\n");
        out.write("                                <table class=\"table\" cellpadding='12' > \n");
        out.write("                                    <thead>\n");
        out.write("                                        <tr>\n");
        out.write("                                            <!--                                        <th class=\"text-center\">\n");
        out.write("                                                                                        <div class=\"toggle-btn\">\n");
        out.write("                                                                                            <div class=\"inner-circle\"></div>\n");
        out.write("                                                                                        </div>\n");
        out.write("                                                                                    </th>-->\n");
        out.write("                                            <th>Order Id</th>\n");
        out.write("                                            <th>Customer Id</th>\n");
        out.write("                                            <th>status</th>\n");
        out.write("                                            <th>Total</th>\n");
        out.write("                                            <th>Order Placed</th>\n");
        out.write("                                            <th>Invoice</th>\n");
        out.write("                                            <th>Payment</th>\n");
        out.write("                                        </tr>\n");
        out.write("                                    </thead>\n");
        out.write("                                    <tbody class=\"table-body\">\n");
        out.write("\n");
        out.write("\n");
        if (orders.size() == 0) {
            out.println("<br/><br/><br/><br/><h1 align = \"center\">No order Placed Yet...</h1>");
        }
        for (Order order : orders) {

            out.write("                                        <tr class=\"cell-1\">\n");
            out.write("\n");
            out.write("                                            <td>#" + order.getId() + "</td>\n");
            out.write("                                            <td>" + order.getCustomerID() + "</td>\n");
            out.write("                                            <td><span class=\"badge badge-danger\">" + order.getStatus() + "</span></td>\n");
            out.write("                                            <td>" + order.getTotal() + "</td>\n");
            out.write("                                            <td>" + order.getDateTime() + "</td>\n");
            out.write("                                            <td><button><a href = \"placeorder?option=invoice&orderid=" + order.getId() + "\">view</a></button></td>\n");
            out.write("                                                        <!--<td><i class=\"fa fa-ellipsis-h text-black-50\"></i></td>-->\n");
            if (order.getStatus().equals("Accepted")) {
                out.write("                                                        <td>\n");
                out.write("\n");
                out.write("\n");
                out.write("                                                            <button> <a href = \"placeorder?option=paymentoption&orderid=" + order.getId() + "\">Pay now</a></button>\n");
                out.write("                                                        </td>\n");
                out.write("                                                        </tr>\n");
            } else if (order.getStatus().equals("successfull")) {
                out.write("                                            <td>Done</td>\n");
            } else if (order.getStatus().equals("Pending")) {
                out.write("                                            <td>Wait</td>\n");
            } else if (order.getStatus().equals("Cancelled")) {
                out.write("                                            <td>Cancelled</td>\n");
            }
        }
        out.write("\n");
        out.write("                                                        </tbody>\n");
        out.write("                                                        </table>\n");
        out.write("                                                        </div>\n");
        out.write("                                                        </div>\n");
        out.write("                                                        </div>\n");
        out.write("                                                        </div>\n");
        out.write("                                                        </div>    </div>\n");
        out.write("                                                        <br/><br/><br/> <div align = \"center\">\n");
        out.write("                                                            <button><a href = \"customerhome.html\">Home</a></button>\n");
        out.write("                                                        </div>  \n");
        out.write("                                                        </body>\n");
        out.write("                                                        </html>\n");
    }

    public void pendingOrders(List<Order> orders) {

        out.write("\n");
        out.write("\n");
        out.write("\n");
        out.write("<!DOCTYPE html>\n");
        out.write("<html>\n");
        out.write("    <head>\n");
        out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
        out.write("        <title>Pending Orders</title>\n");
        out.write("\n");
        out.write("        <style>\n");
        out.write("\n");
        out.write("            @import url('https://fonts.googleapis.com/css?family=Assistant');\n");
        out.write("            body {\n");
        out.write("                background: #eee;\n");
        out.write("                font-family: Assistant, sans-serif;\n");
        out.write("            }\n");
        out.write("\n");
        out.write("            .cell-1 {\n");
        out.write("                border-collapse: separate;\n");
        out.write("                border-spacing: 0 4em;\n");
        out.write("                background: #fff;\n");
        out.write("                border-bottom: 5px solid transparent;\n");
        out.write("                /*background-color: gold;*/\n");
        out.write("                background-clip: padding-box;\n");
        out.write("            }\n");
        out.write("\n");
        out.write("            thead {\n");
        out.write("                background: #dddcdc;\n");
        out.write("            }\n");
        out.write("            \n");
        out.write("           \n");
        out.write("        </style>\n");
        out.write("    </head>\n");
        out.write("    <body><br/><div align = \"center\"><h1>Pending Orders</h1></div>\n");
        out.write("        <br/><br/>\n");
        out.write("        <div align = \"center\" >\n");
        out.write("            <div class=\"container mt-5\">\n");
        out.write("                <div class=\"d-flex justify-content-center row\">\n");
        out.write("                    <div class=\"col-md-10\">\n");
        out.write("                        <div class=\"rounded\">\n");
        out.write("                            <div class=\"table-responsive table-borderless\">\n");
        out.write("                                <table class=\"table\" cellpadding='12'>\n");
        out.write("                                    <thead>\n");
        out.write("                                        <tr>\n");
        out.write("                                            <!--                                        <th class=\"text-center\">\n");
        out.write("                                                                                        <div class=\"toggle-btn\">\n");
        out.write("                                                                                            <div class=\"inner-circle\"></div>\n");
        out.write("                                                                                        </div>\n");
        out.write("                                                                                    </th>-->\n");
        out.write("                                            <th>Order Id</th>\n");
        out.write("                                            <th>Customer Id</th>\n");
        out.write("                                            <th>status</th>\n");
        out.write("                                            <th>Total</th>\n");
        out.write("                                            <th>Order Placed</th>\n");
        out.write("                                            <th>Invoice</th>\n");
        out.write("                                            <th>Approve</th>\n");
        out.write("                                            <th>Reject</th>\n");
        out.write("                                        </tr>\n");
        out.write("                                    </thead>\n");
        out.write("                                    <tbody class=\"table-body\">\n");
        for (Order order : orders) {
            out.write("\n");
            out.write("\n");
            out.write("                                        <tr class=\"cell-1\">\n");
            out.write("\n");
            out.write("                                            <td>#" + order.getId() + "</td>\n");
            out.write("                                            <td>" + order.getCustomerID() + "</td>\n");
            out.write("                                            <td><span class=\"badge badge-danger\">" + order.getStatus() + "</span></td>\n");
            out.write("                                            <td>&#x20B9;" + order.getTotal() + "</td>\n");
            out.write("                                            <td>" + order.getDateTime() + "</td>\n");
            out.write("                                            <td><button><a href = \"placeorder?option=invoice&orderid=" + order.getId() + "\">view</a></button></td>\n");
            out.write("                                                        <!--<td><i class=\"fa fa-ellipsis-h text-black-50\"></i></td>-->\n");
            out.write("                                                        <td><button><a href = \"placeorder?option=approveorder&orderid=" + order.getId() + "\">Accept</a></button></td>\n");
            out.write("                                                        <td><button><a href = \"placeorder?option=rejectorder&orderid=" + order.getId() + "\">Deny</a></button></td>\n");
            out.write("\n");
            out.write("\n");
            out.write("                                                        </tr>\n");
            out.write("\n");
        }
        out.write("                                                        </tbody>\n");
        out.write("                                                        </table>\n");
        out.write("                                                        </div>\n");
        out.write("                                                        </div>\n");
        out.write("                                                        </div>\n");
        out.write("                                                        </div>\n");
        out.write("                                                        </div>    </div>\n");
        out.write("                                                        <br/><br/><br/> <div align = \"center\">");
        out.write("                                                            <button><a href = \"shopkeeperhome.html\">Home</a></button>");
        out.write("                                                            <button><a href = \"placeorder?option=pendingorder\">Back</a></button>");
        out.write("                                                        </div>                      \n");
        out.write("                                                        </body>\n");
        out.write("                                                        </html>\n");
    }
}
