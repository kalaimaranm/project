package com.bassure.khatabook.servlet;

import com.bassure.khatabook.dao.KhatabookDAO;
import com.bassure.khatabook.model.Customer;
import com.bassure.khatabook.model.LineItem;
import com.bassure.khatabook.model.Order;
import com.bassure.khatabook.model.Payment;
import com.bassure.khatabook.model.Product;
import com.bassure.khatabook.mysql.MysqlKhatabookImpl;
import static com.bassure.khatabook.servlet.OrderManagement.customer;
import static com.bassure.khatabook.servlet.OrderManagement.lineItemList;
import static com.bassure.khatabook.servlet.OrderManagement.order;
import static com.bassure.khatabook.servlet.OrderManagement.orderId;
import static com.bassure.khatabook.servlet.OrderManagement.payment;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Objects;
import java.time.LocalDateTime;

public class PlaceOrderServlet extends GenericServlet {

    PrintWriter out;
    KhatabookDAO khatabook = new MysqlKhatabookImpl();

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        out = response.getWriter();
        out.write("<!DOCTYPE html>\n");
        out.write("<html lang=\"en\" >\n");
        out.write("    <head>\n");
        String option = request.getParameter("option");
        out.print("option : " + option + "   outside placeorder");
//        OrderManagement.clearData();
        switch (option) {
            case "view": {
                try {
                    if (Objects.isNull(OrderManagement.customer)) {
                        OrderManagement.customer = khatabook.getCustomer().getCustomerByPhoneNo(request.getParameter("phone"));
                        if (Objects.nonNull(OrderManagement.customer)) {
                            OrderManagement.customerId = OrderManagement.customer.getId();
                        }
                    }
                    if (Objects.nonNull(OrderManagement.customer) && OrderManagement.customer.isStatus()) {
                        if (OrderManagement.products.isEmpty()) {
                            try {
                                OrderManagement.products = khatabook.getProduct().getAllProduct();
                            } catch (SQLException | ClassNotFoundException ex) {
                                Logger.getLogger(PlaceOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        viewProduct();
                        lineItem();
                    } else {
                        out.print("<br/><br/><br/><h1 align = \"center\" >Customer not Found</h1>");
                    }
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(PlaceOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
//            case "addlineitem": {
//                try {
//                    //call header of cart
//                    if (Objects.isNull(OrderManagement.order)) {
//                        OrderManagement.orderId = khatabook.getorder().genOrderID();
//                        OrderManagement.order = new Order();
//                        OrderManagement.order.setId(orderId);  // try to delete this because id already store in order object
//                    }
//
//                    int id = Integer.parseInt(request.getParameter("id"));
//                    Product product = OrderManagement.products.get(id);
//
//                    if (OrderManagement.lineItemList.containsKey(id) && product.getQuantity() > 0) {//you dont need to check product quantity add card button will be disable if product quantity = 0
//                        OrderManagement.lineItemList.get(id).setQuantity(OrderManagement.lineItemList.get(id).getQuantity() + 1);
//                    } else if (!OrderManagement.lineItemList.containsKey(id) && Objects.nonNull(product) && product.getQuantity() > 0) {
//                        OrderManagement.lineItemList.put(Integer.valueOf(product.getId()), new LineItem(OrderManagement.order.getId(), product.getId(), 1, product.getName(), product.getPrice()));
//                    }
//                    OrderManagement.products.get(id).setQuantity(OrderManagement.products.get(id).getQuantity() > 0 ? OrderManagement.products.get(id).getQuantity() - 1 : 0);
//                } catch (ClassNotFoundException | SQLException ex) {
//                    Logger.getLogger(PlaceOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                LineItem[] lineItem = OrderManagement.lineItemList
//                        .values()
//                        .toArray(new LineItem[OrderManagement.lineItemList.size()]);
//                double tempTotal = 0;
//                for (LineItem tempLineItem : lineItem) {
//                    tempTotal = tempTotal + tempLineItem.getQuantity() * tempLineItem.getPrice();
//                }
//                OrderManagement.order.setTotal(tempTotal);
////                        
//                Integer id = Integer.valueOf(request.getParameter("id"));
////        if (OrderManagement.lineItemList.containsKey(id)) {
////            OrderManagement.lineItemList.get(id).setQuantity(OrderManagement.lineItemList.get(id).getQuantity() + 1);
////            try {
////                OrderManagement.lineItemList.get(id).setPrice(OrderManagement.lineItemList.get(id).getPrice() + khatabook.getProduct().getProductById(id).getPrice());
////            } catch (SQLException | ClassNotFoundException ex) {
////                Logger.getLogger(PlaceOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
////            }
////                } else {
////                    OrderManagement.lineItemList.put(id, new LineItem());
////                }
////                OrderManagement.lineItemList.put(Integer.valueOf(id), new LineItem());
////                }
////                viewProduct(OrderManagement.products);
//                viewProduct();
//                lineItem();
//                break;
//            }
//
//            case "delete": {
//                // deleting the products after adding to cart and increase in products[]
//                int idd = Integer.parseInt(request.getParameter("id"));
//                if (OrderManagement.lineItemList.get(idd).getQuantity() > 0) {
//                    OrderManagement.lineItemList.get(idd).setQuantity(OrderManagement.lineItemList.get(idd).getQuantity() - 1);
//                    OrderManagement.order.setTotal(OrderManagement.order.getTotal() - OrderManagement.products.get(idd).getPrice());
//
//                }
//
//                if (OrderManagement.products.containsKey(idd) && OrderManagement.products.get(idd).getQuantity() >= 0) {
//                    OrderManagement.products.get(idd).setQuantity(OrderManagement.products.get(idd).getQuantity() + 1);
//
//                }
//                viewProduct();
//                lineItem(); 
////                       for (Product tempProduct : OrderManagement.products.values()) {
////                    if (tempProduct.getId() == idd && tempProduct.getQuantity() > 0) {  // product may became already 0 mean it will be -1
////                        tempProduct.setQuantity(tempProduct.getQuantity() - 1);
//
////                        break;
////                    }
////                }
////                viewProduct(OrderManagement.products);
////                out.print("<h1><h1>");
////                viewProduct();
////                lineItem();
//                break;
//            }
//
//            case "placeyourorder": {
////                out.print("outside placeorder");
//                if (OrderManagement.order.getTotal() > 0) {
//                    out.print("inside place order: " + OrderManagement.order.getTotal());
//                    order.setLineItem(lineItemList.values().toArray(new LineItem[lineItemList.size()]));
//                    paymentOption();
//
//                } else {
//                    out.print("<h1 align = \"center\">Sorry, Your cart is empty <br/>Please add item to add </h1>");
//                }
//
//                OrderManagement.clearData();
//                break;
//            }
//            case "payment": {
//                out.write("inside payment option");
//                String paymentOption = request.getParameter("paymentoption");
//                out.print("payment option is :" + paymentOption);
//                payment = new Payment(order.getId(), customer.getId(), order.getTotal(), LocalDateTime.now().toString(), "order");
//                double partialAmount = partialAmount = Double.parseDouble(request.getParameter("amount"));
//                Payment payment2 = null;
//                String dateTime = LocalDateTime.now().toString();
//                payment2 = new Payment(order.getId(), customer.getId(), partialAmount, dateTime, "order");
//
//                try {
//                    if (paymentOption.equals("paylater")
//                            && khatabook.getorder().orderEntry(order)
//                            && khatabook.getLineItem().lineItemEntry(order)
//                            && khatabook.getPayment().makePayment(payment)
//                            && khatabook.getCustomer().updateCustomerBalance(OrderManagement.customer.getPhone(), OrderManagement.order.getTotal())
//                            && khatabook.getProduct().productEntry(order)) {
//                        viewInvoice();
//                    } else if (paymentOption.equals("partial") && khatabook.getPayment().makePayment(payment) && khatabook.getCustomer().updateCustomerBalance(customer.getPhone(), order.getTotal() - partialAmount)) {
//                        viewInvoice();
////                    else if (paymentOption.equals("partial") && partialAmount == order.getTotal() ? khatabook.getPayment().makePayment(payment) : khatabook.getPayment().makePayment(payment) && khatabook.getPayment().makePayment(payment2)) {
//                    } else {
//                        out.print("Sorry, order failed...");
//                    }
//                } catch (SQLException | ClassNotFoundException ex) {
//                    Logger.getLogger(PlaceOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                break;
//            }
//            case "invoice": {
//                viewInvoice();
//                break;
//            }
        }
    }

    void viewProduct() {
//       Product product = OrderManagement.products;
        out.print("<table align=\"center\" border=1 rules=all>");
//        out.print("<table>");
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

        for (Product tempProduct : OrderManagement.products.values()) {
            if (tempProduct.isStatus()) {
                out.print("<tr>");
                out.print("<td>" + tempProduct.getId() + "</td>");
                out.print("<td>" + tempProduct.getName() + "</td>");
                out.print("<td>" + tempProduct.getPrice() + "</td>");
                out.print("<td>" + tempProduct.getWeight() + "</td>");
                out.print("<td>" + tempProduct.getQuantity() + "</td>");
//                    out.print("<td> <button onclick=location.href=updateproduct?Id="+p1.getProductId()+">Update Qty</button></td>");
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
//        out.println(" <form  action=\"navigationbar.html\"> \n"
//                + "            <input type=\"submit\"  value=\"Return Home\"> \n"
//                + "        </form>\n"
//                + " ");
    }

    public void lineItem() { //lineitem is not empty na show or dont show 
        if (!OrderManagement.lineItemList.isEmpty()) {
            out.print("<table align=\"center\" border=1 rules=all>");
            out.print("<table>");
            out.print("    <th>");
            out.print("        <tr>");
            out.print("            <th colspan=all>Product Id</th>");
            out.print("\"            <th>S.No</th>\"");
            out.print("            <th>Name</th>");
            out.print("            <th>Quantity</th>");
            out.print("            <th>Price</th>");
            out.print("            <th>Remove</th>");
            // out.print("            <th colspan=\"2\">Update Qty</th>");
            out.print("        </tr> ");
            out.print("    </th> ");
        }
        for (LineItem tempLineItem : OrderManagement.lineItemList.values()) {
            if (tempLineItem.getQuantity() > 0) {
                out.print("<tr>");
                int sNo = 0;
                out.print("<td>" + sNo++ + "</td>");
                out.print("<td>" + tempLineItem.getProductName() + "</td>");
                out.print("<td>" + tempLineItem.getQuantity() + "</td>");
                out.print("<td>" + tempLineItem.getPrice() + "</td>");
//        out.print("<td>" + tempLineItem.getWeight() + "</td>");
                out.print("<td><a href = \"placeorder?option=delete&id=" + tempLineItem.getProductID() + "\">" + "Remove" + "</a></td>");
                out.print("</tr>");
            }

        }
        out.print("</table>");
        if (!OrderManagement.lineItemList.isEmpty()) {
            out.println(" <form  action=\"placeorder?option=placeyourorder\"> \n"
                    + "<label for=\"total\">Total Amount<label><br/><input type = text value = \"" + OrderManagement.order.getTotal() + "\" readonly />"
                    + "            <a href = placeorder?option=placeyourorder>Place Your Order</a> \n"
                    + "        </form>\n"
                    + " ");// /Check out & Payment
        }

    }

    public void paymentOption() {
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
        out.write("                            <div class=\"mt-3 pl-2\"><span class=\"name\">Choose a way to pay</span>\n");
        out.write("                            </div><br/><br/>\n");
        out.write("\n");

//        out.write("<form action = \"placeorder?option=\">");
//        out.write("\n");
//        out.write("                            <div class=\"py-2  px-3\">\n");
//        out.write("                                <div class=\"first pl-2 d-flex py-2\">\n");
//        out.write("                                    <div class=\"form-check\">\n");
//        out.write("                                        <input type=\"radio\" name=\"paymentoption\" value = \"paylater\" class=\"form-check-input mt-3 dot\" checked>\n");
//        out.write("                                    </div>\n");
//        out.write("                                    <div class=\"border-left pl-2\"><strong><span class=\"head\">Pay Later</span></strong><div><span class=\"dollar\">&#x20B9;</span><span class=\"amount\">" + order.getTotal() + "</span></div></div>\n");
//        out.write("\n");
//        out.write("                                </div>\n");
//        out.write("                            </div>\n");
//
//        out.write("<div class=\"py-2  px-3\">\n");
//        out.write("");
//        out.write("");
//        out.write("");
//        out.write("");
//        out.write("");
//        out.write("");
//        out.write("");
//        out.write("");
        out.write("<form action = \"placeorder?option=payment\" method = \"post\">");
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
//        out.write("                                <!--<div><span class=\"back\">Go back</span></div>--><br/><br/><br/><br/>\n");
//        out.write("                                <a href = \"placeorder?option=payment\"><button type=\"button\" class=\"btn btn-primary button\">Pay amount</button></a>\n");

        out.write("<input type = \"submit\" name = \"submit\" value = \"proceed\">");

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

    // stoped here
// need to edit invoice generator using order and do the else part (payment is partial->double payment check if payment amount!=order.getTotal single payment amount == order.getTotal single payment ) 
    public void viewInvoice() {
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
        out.write("                        Date-time : Electronic city, Bangalore - 60</br>\n");
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
        for (LineItem lineItem : lineItemList.values()) {
            if (lineItem.getQuantity() > 0) {
                out.write("                        <tr class=\"service\">\n");
                out.write("                            <td class=\"tableitem\"><p class=\"itemtext\">" + lineItem.getProductName() + "</p></td>\n");
                out.write("                            <td class=\"tableitem\"><p class=\"itemtext\">" + lineItem.getQuantity() + "</p></td>\n");
                out.write("                            <td class=\"tableitem\"><p class=\"itemtext\">&#x20B9;375.00</p>" + lineItem.getQuantity() * lineItem.getPrice() + "</td>\n");
                out.write("                        </tr>\n");
            }
        }
        out.write("                        <tr class=\"tabletitle\">\n");
        out.write("                            <td></td>\n");
        out.write("                            <td class=\"Rate\"><h2>tax</h2></td>\n");
        out.write("                            <td class=\"payment\"><h2>&#x20B9;0.00</h2></td>\n");
        out.write("                        </tr>\n");
        out.write("\n");
        out.write("                        <tr class=\"tabletitle\">\n");
        out.write("                            <td></td>\n");
        out.write("                            <td class=\"Rate\"><h2>Total</h2></td>\n");
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
        out.write("        <a href = \"index.html\" align = \"center\">Home</a>\n");
        out.write("    </body>\n");
        out.write("</html>\n");
    }

}
