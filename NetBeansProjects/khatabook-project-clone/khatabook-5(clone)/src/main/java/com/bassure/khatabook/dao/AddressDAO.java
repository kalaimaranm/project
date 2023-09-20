package com.bassure.khatabook.dao;
import java.sql.SQLException;

import com.bassure.khatabook.model.Address;
import com.bassure.khatabook.model.Customer;
public interface AddressDAO {

    public boolean insertAddress(Customer address) throws SQLException, ClassNotFoundException;

    public void updateAddress(Address address) throws SQLException, ClassNotFoundException;
}
