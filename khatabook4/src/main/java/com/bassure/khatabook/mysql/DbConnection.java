package com.bassure.khatabook.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    private static final String url = "jdbc:mysql://bassure.in:3306/kalaimaran_db";
    private static final String user = "Kalai";
    private static final String pass = "Kalai@4321";

//    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        connection();
//     }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, user, pass);
        return connection;
    }

    public static void connection() throws ClassNotFoundException, SQLException {
        for (int i = 0; i < 150; i++) {
            try{
            getConnection();
            System.out.println("connection = " + i);
            }catch(Exception e){
                
            }
        }
    }
}
