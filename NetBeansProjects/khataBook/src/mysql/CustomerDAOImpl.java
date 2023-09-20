package mysql;

import com.mysql.cj.jdbc.PreparedStatementWrapper;
import dao.CustomerDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import static khatabook.Customer.kb;
import model.Customer;
import khatabook.Khatabook;
import static khatabook.Khatabook.khatabook;
import khatabook.Payment;
import java.util.Objects;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public boolean createAccount(Customer customer) throws SQLException, ClassNotFoundException {
        try (Connection connection = Khatabook.getConnection(); PreparedStatement ps = connection.prepareStatement("insert into customer (name,phone,aadhaar) values(?,?,?)");) {
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getPhone());
            ps.setString(3, customer.getAadhaar());
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
        String query = "";
        try (Connection connection = kb.getConnection()) {

            if (Objects.nonNull(customer.getPhone())) {
                PreparedStatement ps = connection.prepareStatement("update customer set phone = ? where id = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
//                query= ;
                ps.setString(1, customer.getPhone());
                ps.setInt(2, customer.getId());
                return ps.executeUpdate() != 0;
            } else if (Objects.nonNull(customer.getAadhaar())) {
                PreparedStatement ps = connection.prepareStatement("update customer set aadhaar = ? where id = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
//                 query= ;
                ps.setString(1, customer.getAadhaar());
                ps.setInt(2, customer.getId());
                return ps.executeUpdate() != 0;
            } else if (Objects.nonNull(customer.getName())) {
                PreparedStatement ps = connection.prepareStatement("update customer set name = ? where id = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
//                 query= ;
                ps.setString(1, customer.getName());
                ps.setInt(2, customer.getId());
                return ps.executeUpdate() != 0;
            } else if (Objects.nonNull(customer.getAddress())) {
                PreparedStatement ps = connection.prepareStatement("update address set doorno = ?, street = ?, distric = ?, state = ?, pincode = ? where customer_id = ?");
//                query= ";
                System.out.println("address : " + customer.getAddress());
                ps.setString(1, customer.getAddress().getHouseNo());
                ps.setString(2, customer.getAddress().getStreet());
                ps.setString(3, customer.getAddress().getDistric());
                ps.setString(4, customer.getAddress().getState());
                ps.setString(5, customer.getAddress().getPincode());
                ps.setInt(6, customer.getId());

                return ps.executeUpdate() != 0;
            }
        } catch (SQLException sql) {
            sql.printStackTrace();
        }

        return false;

    }

    @Override
    public boolean deleteCustomer(int id) throws SQLException, ClassNotFoundException {
        try (Connection connection = kb.getConnection(); PreparedStatement ps = connection.prepareStatement("update customer set statuss=false where id = ?");) {
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

        return null;
    }

    @Override  // validation customer live,debts irruka?
    public boolean payDebts(double amount, String phone) throws SQLException, ClassNotFoundException {
        try (Connection connection = kb.getConnection();) {
            PreparedStatement ps = connection.prepareStatement("update customer set debt_balance = ? where phone = ?");
            ps.setDouble(1, amount);
            ps.setString(2, phone);
            int rs = ps.executeUpdate();
            return rs == 1;
        }
    }

    @Override
    public double getCustomerBalance(String phone) throws SQLException, ClassNotFoundException {

        try (Connection connection = kb.getConnection(); PreparedStatement ps = connection.prepareStatement("select debt_balance from customer where phone = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);) {
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
    public void updateCustomerBalance(String phone, double balance) throws SQLException, ClassNotFoundException {

    }

    @Override
    public double getWalletBalance(String phone) throws SQLException, ClassNotFoundException {
        return 0.0;
    }

    @Override
    public boolean getCustomerStatus(String phone) throws SQLException, ClassNotFoundException {
        try (Connection connection = kb.getConnection();
              PreparedStatement ps = connection.prepareStatement("select statuss from customer where phone = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);) {
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
        try (Connection connection = Khatabook.getConnection(); PreparedStatement ps = connection.prepareStatement("select id from customer where phone=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);) {
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
        model.Customer customer = null;
        try (Connection connection = kb.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from customer where phone=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);) {
            ps.setString(1, phone);
            ResultSet rs = ps.executeQuery();
            return rs.absolute(1) ? rs.getBoolean(8) ? customer = new model.Customer(rs.getInt(1),
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
