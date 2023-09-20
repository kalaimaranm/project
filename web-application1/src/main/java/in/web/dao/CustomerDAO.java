package in.web.dao;

import in.web.model.Register;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import org.apache.commons.lang.RandomStringUtils;
import java.util.List;

public class CustomerDAO {

    static String url = "jdbc:mysql://bassure.in:3306/kalaimaran_db";
    static String user = "Kalai";
    static String pass = "Kalai@4321";
    List<CustomerClass> customers = new ArrayList<>();

//    public static void main(String[] args) {
//        Set<String> listOfId = new HashSet<>();
//        for (int i = 0; i < 1000; i++) {
//            listOfId.add(RandomStringUtils.randomNumeric(2));
//        }
//        System.out.println("listOfId length:" + listOfId.size());
//        for (String s : listOfId) {
//            System.out.println("customer Id :" + s);
//        }
//
//    }
//    public static Supplier<String> generateId = () -> RandomStringUtils.randomAlphanumeric(10);
    //    public static Supplier<Connection> dbConnection = () -> DriverManager.getConnection(url, user, pass);
    public boolean dataInsertion(Register register) throws SQLException, IOException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");//com.mysql.cj.jdbc.Driver
        try (Connection connection = DriverManager.getConnection(url, user, pass); PreparedStatement statement = connection.prepareStatement("insert into form (name,mail,address,phoneno) values (?,?,?,?)")) {
//             statement.setInt(1,1);
            statement.setString(1, register.getName());
//            statement.setString(2, register.getMail());
//            statement.setString(3, register.getAddress());
//            statement.setString(4, register.getPhoneNo());
            int result = statement.executeUpdate();
            return result != 0;

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return false;
    }

    public boolean createCustomerAccount(CustomerClass customer) {

        try (Connection connection = DriverManager.getConnection(url, user, pass); PreparedStatement ps = connection.prepareStatement("insert into customer (name,phone,aadhaar,debt_balance,wallet_balance,status) values(?,?,?,?,?,?)");) {
//            PreparedStatement ps2 = connection.prepareStatement("insert into login_credential values (?,?,?)");
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getPhone());
            ps.setString(3, customer.getAadhaar());
            ps.setDouble(4, customer.getDebtBalance());
            ps.setDouble(5, customer.getWalletBalance());
            ps.setBoolean(6, customer.isStatus());
            int b = ps.executeUpdate();
//            ps2.setInt(1,getCustomerIdByPhoneNo(customer.getPhone()));
//            ps2.setString(2,customer.getPassword());
//            ps2.setString(3, "CUSTOMER");

            return b == 1; //== ps.executeUpdate();
//            return ps.execute();  Its not working?

        } catch (SQLException sql) {
            sql.printStackTrace();
        }
        return false;
    }

    public List<CustomerClass> getAllCustomer() throws SQLException,ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(url, user, pass); 
             PreparedStatement ps = connection.prepareStatement("select * from customer");) {
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                customers.add(new CustomerClass(result.getInt(1), result.getString(2),
                        result.getString(3), result.getString(4),
                        result.getDouble(5), result.getDouble(6),
                        result.getBoolean(7)));
            }
        }
        return customers;
    }

}
