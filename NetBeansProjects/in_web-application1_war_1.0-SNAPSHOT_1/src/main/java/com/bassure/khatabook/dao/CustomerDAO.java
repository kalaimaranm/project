package com.bassure.khatabook.dao;

import java.sql.SQLException;
import com.bassure.khatabook.model.Customer;

public interface CustomerDAO {

    public boolean createAccount(Customer customer) throws SQLException, ClassNotFoundException;

    public boolean updateCustomer(Customer customer) throws SQLException, ClassNotFoundException;

    public boolean deleteCustomer(int id) throws SQLException, ClassNotFoundException;

    public void placeOrder() throws SQLException, ClassNotFoundException;

    public Customer[] getAllCustomer() throws SQLException, ClassNotFoundException;

    public Customer getCustomerByPhoneNo(String phone) throws SQLException, ClassNotFoundException;

    public boolean payDebts(double amount, String phone) throws SQLException, ClassNotFoundException;  // finally here you have to get how much amount for whom to pay

    public double getCustomerBalance(String phone) throws SQLException, ClassNotFoundException;

//    public boolean setCustomerBalance(int customerId, double amount) throws SQLException, ClassNotFoundException;

    public boolean updateCustomerBalance(String phone, double balance) throws SQLException, ClassNotFoundException; // updateCustomerBalance()

    public double getWalletBalance(String phone) throws SQLException, ClassNotFoundException;

    public boolean getCustomerStatus(String phone) throws SQLException, ClassNotFoundException;

    public int getCustomerIdByPhoneNo(String phone) throws SQLException, ClassNotFoundException;

}
