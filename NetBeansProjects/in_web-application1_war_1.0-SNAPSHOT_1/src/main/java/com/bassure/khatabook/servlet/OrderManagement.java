package com.bassure.khatabook.servlet;

import com.bassure.khatabook.model.Customer;
import com.bassure.khatabook.model.LineItem;
import com.bassure.khatabook.model.Order;
import com.bassure.khatabook.model.Payment;
import com.bassure.khatabook.model.Product;
//import java.util.List;
//import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.Getter;

//@Setter
//@Getter
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
//        lineItemList = Arrays.copyOf(lineItemList, 0);
//        products = Arrays.copyOf(products, 0);
//        order = 
        lineItemList.clear();
        products.clear();
        order = null;
        phone = null;
        customer = null;
        payment = null;
        orderId = 0;
        customerId = 0;
    }

//    public static void main(String[] args) {
//        System.out.println("lineItemList is :" + lineItemList);
//        System.out.println("products is :" + products);
//        lineItemList.put(1, null);
//        products.add(null);
//        System.out.println("lineItemList is :" + lineItemList);
//        System.out.println("products is :" + products);
//        clearData();
//        System.out.println("lineItemList is :" + lineItemList);
//        System.out.println("products is :" + products);
//    }
}
