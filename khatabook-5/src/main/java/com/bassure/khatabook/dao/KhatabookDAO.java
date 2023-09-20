package com.bassure.khatabook.dao;

import com.bassure.khatabook.repository.AddressDAOImpl;
import com.bassure.khatabook.repository.AuthenticationAuthorizationDAOImpl;
import com.bassure.khatabook.repository.LineItemDAOImpl;
import com.bassure.khatabook.repository.ProductDAOImpl;
import com.bassure.khatabook.repository.OrderDAOImpl;
import com.bassure.khatabook.repository.PaymentDAOImpl;
import com.bassure.khatabook.repository.StockDAOImpl;
import com.bassure.khatabook.repository.CustomerDAOImpl;

public interface KhatabookDAO {

    public CustomerDAOImpl getCustomer();

    public AddressDAOImpl getAddress();

    public ProductDAOImpl getProduct();

    public OrderDAOImpl getorder();

    public LineItemDAOImpl getLineItem();

    public PaymentDAOImpl getPayment();

    public StockDAOImpl getStock();

    public AuthenticationAuthorizationDAOImpl getAuthenticationAuthorizationDAOImpl();

}
