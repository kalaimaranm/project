package in.web.dao;

import in.web.model.Register;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
//import org.apache.commons.lang.RandomStringUtils;
import java.util.function.Supplier;
import java.util.HashSet;
import java.util.Set;

public class InsertData {

    static String url = "jdbc:mysql://bassure.in:3306/kalaimaran_db";
    static String user = "Kalai";
    static String pass = "Kalai@4321";

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
        try (Connection connection = DriverManager.getConnection(url, user, pass);
            PreparedStatement statement = connection.prepareStatement("insert into form (name,mail,address,phoneno) values (?,?,?,?)")) {
//             statement.setInt(1,1);
            statement.setString(1, register.getName());
            statement.setString(2, register.getMail());
            statement.setString(3, register.getAddress());
            statement.setString(4, register.getPhoneNo());
            int result = statement.executeUpdate();
            return  result != 0;

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return false;
    }

}
