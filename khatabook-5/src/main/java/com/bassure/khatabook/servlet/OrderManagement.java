package com.bassure.khatabook.servlet;

import com.bassure.khatabook.model.Customer;
import com.bassure.khatabook.model.LineItem;
import com.bassure.khatabook.model.Order;
import com.bassure.khatabook.model.Payment;
import com.bassure.khatabook.model.Product;
import java.util.HashMap;
import java.util.Map;

public class OrderManagement {

    public static Map<Integer, LineItem> lineItemList = new HashMap();
    public static Map<Integer,Product> products = new HashMap();
    public static Order order;
    public static String phone;
    public static Customer customer;
    public static int orderId;
    public static int customerId;
    public static Payment payment;

    public static void clearData() {

        lineItemList.clear();
        products.clear();
        order = null;
        phone = null;
        customer = null;
        payment = null;
        orderId = 0;
        customerId = 0;
    }
}
