package com.bassure.khatabook.mysql;

import com.bassure.khatabook.dao.KhatabookDAO;

public class MysqlKhatabookImplTest implements KhatabookDAO {

    CustomerDAOImpl customerDAOImpl;
    AddressDAOImpl addressDAOImpl;
    ProductDAOImpl productDAOImpl;
    OrderDAOImpl orderDAOImpl;
    LineItemDAOImpl lineItemDAOImpl;
    PaymentDAOImpl paymentDAOImpl;
    StockDAOImpl stockDAOImpl;

    @Override
    public CustomerDAOImpl getCustomer() {
        if (customerDAOImpl != null) {
            return customerDAOImpl;
        }
        customerDAOImpl = new CustomerDAOImpl();
        return customerDAOImpl;
    }

    @Override
    public AddressDAOImpl getAddress() {
        if (addressDAOImpl != null) {
            return addressDAOImpl;
        }
        addressDAOImpl = new AddressDAOImpl();
        return addressDAOImpl;
    }

    @Override
    public ProductDAOImpl getProduct() {
        if (productDAOImpl != null) {
            return productDAOImpl;
        }
        productDAOImpl = new ProductDAOImpl();
        return productDAOImpl;
    }

    @Override
    public OrderDAOImpl getorder() {
        if (orderDAOImpl != null) {
            return orderDAOImpl;
        }
        orderDAOImpl = new OrderDAOImpl();
        return orderDAOImpl;
    }

    @Override
    public LineItemDAOImpl getLineItem() {
        if (lineItemDAOImpl != null) {
            return lineItemDAOImpl;
        }
        lineItemDAOImpl = new LineItemDAOImpl();
        return lineItemDAOImpl;
    }

    @Override
    public PaymentDAOImpl getPayment() {
        if (paymentDAOImpl != null) {
            return paymentDAOImpl;
        }
        paymentDAOImpl = new PaymentDAOImpl();
        return paymentDAOImpl;
    }

    @Override
    public StockDAOImpl getStock() {
        if (stockDAOImpl != null) {
            return stockDAOImpl;
        }
        stockDAOImpl = new StockDAOImpl();
        return stockDAOImpl;
    }

}
