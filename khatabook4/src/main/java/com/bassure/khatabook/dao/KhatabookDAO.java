package com.bassure.khatabook.dao;

import com.bassure.khatabook.mysql.AddressDAOImpl;
import com.bassure.khatabook.mysql.LineItemDAOImpl;
import com.bassure.khatabook.mysql.ProductDAOImpl;
import com.bassure.khatabook.mysql.OrderDAOImpl;
import com.bassure.khatabook.mysql.PaymentDAOImpl;
import com.bassure.khatabook.mysql.StockDAOImpl;
import com.bassure.khatabook.mysql.CustomerDAOImpl;

public interface KhatabookDAO {

    public CustomerDAOImpl getCustomer();

    public AddressDAOImpl getAddress();

    public ProductDAOImpl getProduct();

    public OrderDAOImpl getorder();

    public LineItemDAOImpl getLineItem();

    public PaymentDAOImpl getPayment();

    public StockDAOImpl getStock();

}
