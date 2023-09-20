package com.bassure.khatabook.service;

import com.bassure.khatabook.model.Customer;
import com.bassure.khatabook.model.Payment;
import com.bassure.khatabook.repository.MysqlKhatabookImpl;
import static com.bassure.khatabook.servlet.OrderManagement.phone;
import java.sql.SQLException;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    MysqlKhatabookImpl mysqlKhatabookImpl;

    public boolean addCustomer(Customer customer) throws SQLException, ClassNotFoundException {

        System.out.println("inside service()");

        if (mysqlKhatabookImpl.getCustomer().createAccount(customer)
                && mysqlKhatabookImpl.getAddress().insertAddress(customer)) {
            customer.setId(mysqlKhatabookImpl.getCustomer().getCustomerIdByPhoneNo(customer.getPhone()));
            return true;
        }
        return false;

    }

    public Customer getCustomerByPhone(String phone) throws SQLException, ClassNotFoundException {

        return mysqlKhatabookImpl.getCustomer().getCustomerByPhoneNo(phone);

    }
    
    public Customer getCustomerById(int customerId) throws SQLException, ClassNotFoundException {
        
        
        return mysqlKhatabookImpl.getCustomer().getCustomerById(customerId);
    }

    public boolean payDebt(int id, double amount) throws SQLException, ClassNotFoundException {

        if (mysqlKhatabookImpl.getCustomer().payDebts(amount, id)
                && mysqlKhatabookImpl.getPayment().makePayment(new Payment(0, id, amount, LocalDateTime.now().toString(), "debt"))) {

            return true;
        }

        return false;
    }

    public Payment getPaymentDetail(int customerId) throws ClassNotFoundException, SQLException {

        return mysqlKhatabookImpl.getPayment().getPaymentDetail(customerId);
    }

    public boolean deleteCustomer(int id) throws SQLException, ClassNotFoundException {

        if (mysqlKhatabookImpl.getCustomer().deleteCustomer(id)) {
            return true;
        }

        return false;
    }

    public boolean updateCustomer(Customer customer) throws SQLException, ClassNotFoundException {

        if (mysqlKhatabookImpl.getCustomer().updateCustomer(customer)) {

            return true;
        }

        return false;
    }

}
