package com.bassure.khatabook.mysql;

import com.bassure.khatabook.dao.AddressDAO;
import com.bassure.khatabook.dao.KhatabookDAO;
import com.bassure.khatabook.mysql.MysqlKhatabookImpl;
import com.bassure.khatabook.model.Address;
import com.bassure.khatabook.model.Customer;
import java.sql.SQLException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.bassure.khatabook.mysql.DbConnection;

public class AddressDAOImpl implements AddressDAO {

    KhatabookDAO khatabookDAO = new MysqlKhatabookImpl();

    @Override // to add new customer 
    public boolean insertAddress(Customer customer) throws SQLException, ClassNotFoundException {
        try (Connection connection = DbConnection.getConnection(); 
            PreparedStatement ps = connection.prepareStatement("insert into address (customer_id,doorno,street,distric,state,pincode) values(?,?,?,?,?,?)");) {
            ps.setInt(1, khatabookDAO.getCustomer()
                    .getCustomerIdByPhoneNo(customer.getPhone()));
            ps.setString(2, customer.getAddress()
                    .getHouseNo());
            ps.setString(3, customer.getAddress()
                    .getStreet());
            ps.setString(4, customer.getAddress()
                    .getDistric());
            ps.setString(5, customer.getAddress()
                    .getState());
            ps.setString(6, customer.getAddress()
                    .getPincode());
            int b = ps.executeUpdate();
            return b == 1;
        } catch (SQLException sql) {
            sql.printStackTrace();
        }
        return false;
    }

    @Override
    public void updateAddress(Address address
    ) {

    }

    public Address getAddress(int id) throws SQLException, ClassNotFoundException {
        try (Connection connection = DbConnection.getConnection(); PreparedStatement ps = connection.prepareStatement("select * from address where customer_id = ?");) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            Address address = new Address(rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(8));
            return address;
        } catch (SQLException sql) {
            sql.printStackTrace();
        }
        return null;

    }

}
