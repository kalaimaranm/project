package in.java.unit.test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JavaUnitTest {
    
    private static String url = "jdbc:mysql://bassure.in:3306/kalaimaran_db";
    private static String user = "Kalai";
    private static String pass = "Kalai@4321";
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main2(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try {

            //String query = "select * from Employee";
            String query = "{call getdata(?)}";
            Connection connection = DriverManager.getConnection(url, user, pass);
            System.out.println(connection.getClass().getName());
//             Statement statement = connection.createStatement();
            CallableStatement prepareCall = connection.prepareCall(query);
            prepareCall.setString("name", "Developer");
            ResultSet pc = prepareCall.executeQuery();
            while (pc.next()) {
                System.out.println(pc.getInt(1) + " " + pc.getString(2));
            }
            System.out.println("completed");

            //  ResultSet rs = statement.executeQuery(query);
//            while (rs.next()) {
//                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getInt(4) + " " + rs.getString(5));
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main3(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String query = "select * from login where userid = ? and pass = ?";
        //FString query = "select * from login where userid = 1000 and pass = "djf"";
        Connection connection = DriverManager.getConnection(url, user, pass);
        PreparedStatement statement = connection.prepareStatement(query);
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your userid");
        int id = scan.nextInt();
        System.out.println("Enter Your pass");
        String passw = scan.next();
        statement.setInt(1, id);
        statement.setString(2, passw);
        ResultSet rs = statement.executeQuery();
        System.out.println(rs.next());
    }

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(url, user, pass);
        Connection connection2 = DriverManager.getConnection(url, user, pass);
        System.out.println(connection);
        System.out.println(connection2);

    }
}
//dive into 

