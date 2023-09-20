package dao;

import java.sql.SQLException;

import model.Address;
import model.Customer;
public interface AddressDAO {

    public boolean insertAddress(Customer address) throws SQLException, ClassNotFoundException;

    public void updateAddress(Address address) throws SQLException, ClassNotFoundException;
}
