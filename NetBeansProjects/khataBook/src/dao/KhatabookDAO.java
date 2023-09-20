package dao;

import mysql.CustomerDAOImpl;
import mysql.AddressDAOImpl;
import mysql.LineItemDAOImpl;
import mysql.ProductDAOImpl;
import mysql.OrderDAOImpl;
import mysql.PaymentDAOImpl;
import mysql.StockDAOImpl;

public interface KhatabookDAO {

    public CustomerDAOImpl getCustomer();

    public AddressDAOImpl getAddress();

    public ProductDAOImpl getProduct();

    public OrderDAOImpl getorder();

    public LineItemDAOImpl getLineItem();

    public PaymentDAOImpl getPayment();

    public StockDAOImpl getStock();

}
