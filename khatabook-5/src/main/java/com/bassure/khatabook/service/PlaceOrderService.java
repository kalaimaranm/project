package com.bassure.khatabook.service;

import com.bassure.khatabook.model.Product;
import com.bassure.khatabook.repository.MysqlKhatabookImpl;
import java.sql.SQLException;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaceOrderService {

    @Autowired
    MysqlKhatabookImpl mysqlKhatabookImpl;

    public Product[] getAllProduct() throws SQLException, ClassNotFoundException {

        Map<Integer, Product> products = mysqlKhatabookImpl.getProduct().getAllProduct();

//        System.out.println("producsMap: " + products);
//        for (Product product : products.values()) {
//
//            System.out.println(product);
//        }
        return products.values().toArray(new Product[products.size()]);
    }

    public int genOrderId() throws ClassNotFoundException, SQLException {

        return mysqlKhatabookImpl.getorder().genOrderID();
    }

}
