package com.bassure.khatabook.service;

import com.bassure.khatabook.model.Order;
import com.bassure.khatabook.model.Payment;
import com.bassure.khatabook.repository.MysqlKhatabookImpl;
import static com.bassure.khatabook.servlet.OrderManagement.payment;
import java.sql.SQLException;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    MysqlKhatabookImpl mysqlKhatabookImpl;

    public boolean payNow(Order order, double amount) throws ClassNotFoundException, SQLException {

        System.out.println("inside paynow");

        if (order.getTotal() == amount) {
            return mysqlKhatabookImpl.getorder().orderEntry(order)
                    && mysqlKhatabookImpl.getLineItem().lineItemEntry(order)
                    && mysqlKhatabookImpl.getPayment().makePayment(new Payment(order.getId(), order.getCustomerID(), order.getTotal(), LocalDateTime.now().toString(), "order"))
                    && mysqlKhatabookImpl.getProduct().productEntry(order);

        }
        return mysqlKhatabookImpl.getorder().orderEntry(order)
                && mysqlKhatabookImpl.getLineItem().lineItemEntry(order)
                && mysqlKhatabookImpl.getPayment().makePayment(new Payment(order.getId(), order.getCustomerID(), order.getTotal(), LocalDateTime.now().toString(), "order"))
                && mysqlKhatabookImpl.getCustomer().updateCustomerBalance(order.getCustomerID(), amount)
                && mysqlKhatabookImpl.getProduct().productEntry(order);

    }

    public boolean payLater(Order order, double amount) throws ClassNotFoundException, SQLException {

        System.out.println("paylater outside if");
        return mysqlKhatabookImpl.getorder().orderEntry(order)
                && mysqlKhatabookImpl.getLineItem().lineItemEntry(order)
                && mysqlKhatabookImpl.getPayment().makePayment(new Payment(order.getId(), order.getCustomerID(), order.getTotal(), LocalDateTime.now().toString(), "order"))
                && mysqlKhatabookImpl.getCustomer().updateCustomerBalance(order.getCustomerID(), order.getTotal())
                && mysqlKhatabookImpl.getProduct().productEntry(order);
    }

    public Payment getPaymentDetail(int customerId) throws ClassNotFoundException, SQLException {

        return mysqlKhatabookImpl.getPayment().getPaymentDetail(customerId);
    }

    public Order getOrderById(int orderId) throws ClassNotFoundException, SQLException {

        return mysqlKhatabookImpl.getorder().getOrderById(orderId);
    }

}
