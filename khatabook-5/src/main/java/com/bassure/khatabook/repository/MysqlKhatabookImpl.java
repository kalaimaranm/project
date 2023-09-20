package com.bassure.khatabook.repository;

//import com.bassure.khatabook.dao.KhatabookDAO;
//import com.bassure.khatabook.repository.AddressDAOImpl;
//import com.bassure.khatabook.repository.CustomerDAOImpl;
//import com.bassure.khatabook.repository.LineItemDAOImpl;
//import com.bassure.khatabook.repository.OrderDAOImpl;
//import com.bassure.khatabook.repository.PaymentDAOImpl;
//import com.bassure.khatabook.repository.ProductDAOImpl;
//import com.bassure.khatabook.repository.StockDAOImpl;
import com.bassure.khatabook.dao.KhatabookDAO;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
//@Setter
@NoArgsConstructor
public class MysqlKhatabookImpl implements KhatabookDAO {

    @Autowired
    CustomerDAOImpl customerDAOImpl;
    @Autowired
    AddressDAOImpl addressDAOImpl;
    @Autowired
    ProductDAOImpl productDAOImpl;
    @Autowired
    OrderDAOImpl orderDAOImpl;
    @Autowired
    LineItemDAOImpl lineItemDAOImpl;
    @Autowired
    PaymentDAOImpl paymentDAOImpl;
    @Autowired
    StockDAOImpl stockDAOImpl;
    @Autowired
    AuthenticationAuthorizationDAOImpl authenticationAuthorizationImpl;

    @Override
    public CustomerDAOImpl getCustomer() {

        return customerDAOImpl;
    }

    @Override
    public AddressDAOImpl getAddress() {

        return addressDAOImpl;
    }

    @Override
    public ProductDAOImpl getProduct() {

        return productDAOImpl;
    }

    @Override
    public OrderDAOImpl getorder() {

        return orderDAOImpl;
    }

    @Override
    public LineItemDAOImpl getLineItem() {

        return lineItemDAOImpl;

    }

    @Override
    public PaymentDAOImpl getPayment() {

        return paymentDAOImpl;
    }

    @Override
    public StockDAOImpl getStock() {

        return stockDAOImpl;
    }

    @Override
    public AuthenticationAuthorizationDAOImpl getAuthenticationAuthorizationDAOImpl() {

        return authenticationAuthorizationImpl;
    }
}
