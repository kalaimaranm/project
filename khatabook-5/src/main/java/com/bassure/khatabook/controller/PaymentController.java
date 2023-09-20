package com.bassure.khatabook.controller;

import com.bassure.khatabook.model.Order;
import com.bassure.khatabook.service.PaymentService;
import jakarta.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @GetMapping("/payment-page")
    public String paymentService(HttpServletRequest request) {

        return "payment/payment-option";
    }

    @PostMapping("/initiate-payment")
    public String payNow(HttpServletRequest request, ModelMap model) throws ClassNotFoundException, SQLException {

        Order order = (Order) request.getSession().getAttribute("order");
        String paymentOption = request.getParameter("payment-option");
        System.out.println("payment option : " + paymentOption);
        double balanceAmount = 0;
        if (paymentOption.equals("pay-now")) {

            balanceAmount = Double.parseDouble(request.getParameter("amount"));
            balanceAmount = balanceAmount == order.getTotal() ? order.getTotal() : order.getTotal() - balanceAmount;
            System.out.println("pay-now : " + balanceAmount);

            if (paymentService.payNow(order, balanceAmount)) {
                model.addAttribute("payment", paymentService.getPaymentDetail(order.getCustomerID()));
                return "payment/payment-detail";
            }
            return "payment/payment-failed";
        } else if (paymentOption.equals("pay-later") && paymentService.payLater(order, order.getTotal())) {
            System.out.println("balanceAmout : " + balanceAmount);
            model.addAttribute("payment", paymentService.getPaymentDetail(order.getCustomerID()));
            return "payment/payment-detail";

        }

        return "payment/payment-failed";
    }

    @GetMapping("/generate-invoice")
    public String generateInvoice(HttpServletRequest request) throws ClassNotFoundException, SQLException {

//        Order order = (Order) request.getSession().getAttribute("order");
//        paymentService.getOrderById(order.getId());

        return "order/invoice";
    }
}
