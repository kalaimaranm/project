package com.bassure.khatabook.mysql;

//import com.mysql.cj.jdbc.PreparedStatementWrapper;
import com.bassure.khatabook.dao.CustomerDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import com.bassure.khatabook.model.Customer;
import static com.bassure.khatabook.servlet.AddCustomerServlet.khatabook;
import java.sql.Statement;
import java.util.Objects;
import java.util.Arrays;
import com.bassure.khatabook.model.Address;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public boolean createAccount(Customer customer) throws SQLException, ClassNotFoundException {
        try (Connection connection = DbConnection.getConnection(); PreparedStatement ps = connection.prepareStatement("insert into customer (name,phone,aadhaar,debt_balance,wallet_balance,statuss) values(?,?,?,?,?,?)");) {
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getPhone());
            ps.setString(3, customer.getAadhaar());
            ps.setDouble(4, customer.getDebtBalance());
            ps.setDouble(5, customer.getWalletBalance());
            ps.setBoolean(6, customer.isStatus());
            int b = ps.executeUpdate();
            return b == 1;
//            return ps.execute();  Its not working?

        } catch (SQLException sql) {
            sql.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException, ClassNotFoundException {
        try (Connection connection = DbConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("update customer set name = ?,phone = ?,aadhaar = ? where id = ?"); PreparedStatement preparedStatement2 = connection.prepareStatement("update address set doorno = ?,street = ?, distric = ?,state = ?,pincode =? where customer_id = ?");) {
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getPhone());
            preparedStatement.setString(3, customer.getAadhaar());
            preparedStatement.setInt(4, customer.getId());

            preparedStatement2.setString(1, customer.getAddress().getHouseNo());
            preparedStatement2.setString(2, customer.getAddress().getStreet());
            preparedStatement2.setString(3, customer.getAddress().getDistric());
            preparedStatement2.setString(4, customer.getAddress().getState());
            preparedStatement2.setString(5, customer.getAddress().getPincode());
            preparedStatement2.setInt(6, customer.getId());

            return preparedStatement.executeUpdate() != 0 && preparedStatement2.executeUpdate() != 0;
        } catch (SQLException sqle) {

        }

        return false;

    }

    @Override
    public boolean deleteCustomer(int id) throws SQLException, ClassNotFoundException {
        try (Connection connection = DbConnection.getConnection(); PreparedStatement ps = connection.prepareStatement("update customer set statuss=false where id = ?");) {
            ps.setInt(1, id);

            return ps.executeUpdate() == 1;
        } catch (SQLException sql) {
            sql.printStackTrace();
        }
        return false;

    }

    @Override
    public void placeOrder() throws SQLException, ClassNotFoundException {

    }

    @Override
    public Customer[] getAllCustomer() throws SQLException, ClassNotFoundException {
        try (Connection connection = DbConnection.getConnection(); Statement statement = connection.createStatement();) {
            ResultSet result = statement.executeQuery("select * from customer left join  address on  customer.id = address.customer_id;");
            Customer[] customer = new Customer[0];
            while (result.next()) {
                customer = Arrays.copyOf(customer, customer.length + 1);
                customer[customer.length - 1] = new Customer(result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getDouble(5),
                        result.getDouble(6),
                        result.getBoolean(8),
                        new Address(result.getString(11),
                                result.getString(12),
                                result.getString(13),
                                result.getString(14),
                                result.getString(16)));

            }
            return customer;
        } catch (SQLException sql) {
            sql.printStackTrace();
        }
        return null;
    }

    @Override  // validation customer live,debts irruka?
    public boolean payDebts(double amount, String phone) throws SQLException, ClassNotFoundException {
        try (Connection connection = DbConnection.getConnection();) {
            PreparedStatement ps = connection.prepareStatement("update customer set debt_balance = ? where phone = ?");
            ps.setDouble(1, amount);
            ps.setString(2, phone);
            int rs = ps.executeUpdate();
            return rs == 1;
        }
    }

    @Override
    public double getCustomerBalance(String phone) throws SQLException, ClassNotFoundException {

        try (Connection connection = DbConnection.getConnection(); PreparedStatement ps = connection.prepareStatement("select debt_balance from customer where phone = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);) {
            ps.setString(1, phone);
            ResultSet rs = ps.executeQuery();
            rs.absolute(1);
            return rs.getDouble(1);
        } catch (SQLException sql) {
            sql.printStackTrace();
        }
        return 0;
    }

    @Override
    public boolean updateCustomerBalance(String phone, double amount) throws SQLException, ClassNotFoundException {
        try (Connection connection = DbConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("update customer set debt_balance = debt_balance + ? where phone = ?")) {
            preparedStatement.setDouble(1, amount);
            preparedStatement.setString(2, phone);

            return preparedStatement.executeUpdate() != 0;
        }

    }

    @Override
    public double getWalletBalance(String phone) throws SQLException, ClassNotFoundException {
        return 0.0;
    }

    @Override
    public boolean getCustomerStatus(String phone) throws SQLException, ClassNotFoundException {
        try (Connection connection = DbConnection.getConnection(); PreparedStatement ps = connection.prepareStatement("select statuss from customer where phone = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);) {
            ps.setString(1, phone);
            ResultSet rs = ps.executeQuery();
            rs.absolute(1);
            return rs.getBoolean(1);
        } catch (SQLException sql) {
            sql.printStackTrace();
        }

        return false;
    }

    @Override  // throwing exception if wrong input given
    public int getCustomerIdByPhoneNo(String phone) throws SQLException, ClassNotFoundException {
        try (Connection connection = DbConnection.getConnection(); PreparedStatement ps = connection.prepareStatement("select id from customer where phone=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);) {
            ps.setString(1, phone);
            ResultSet rs = ps.executeQuery();
            boolean b = rs.absolute(1);
            if (b) {
                return rs.getInt(1);
            }
        }
        return 0;
//           if()

    }

    @Override
    public Customer getCustomerByPhoneNo(String phone) throws SQLException, ClassNotFoundException {
        Customer customer = null;
        try (Connection connection = DbConnection.getConnection(); PreparedStatement ps = connection.prepareStatement("select * from customer where phone=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);) {
            ps.setString(1, phone);
            ResultSet rs = ps.executeQuery();
            return rs.absolute(1) ? rs.getBoolean(8) ? customer = new Customer(rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getDouble(5),
                    rs.getDouble(6),
                    rs.getBoolean(8),
                    khatabook.getAddress().getAddress(rs.getInt(1)))
                    : customer
                    : customer;
//            if(rs.absolute(1)){
//            if (getCustomerStatus(phone)) {
//                
//                rs.next();
//                customer = new model.Customer(rs.getInt(1),
//                        rs.getString(2),
//                        rs.getString(3),
//                        rs.getString(4),
//                        rs.getDouble(5),
//                        rs.getDouble(6),
//                        khatabook.getAddress().getAddress(rs.getInt(1)));
//
////            rs.next();
//                return customer; // if it return null customer not found
//            }}
//else{
//                System.err.println("Customer Detail not found");
//            }

        } catch (SQLException sql) {
            sql.printStackTrace();
        }
        return customer;

    }

}
