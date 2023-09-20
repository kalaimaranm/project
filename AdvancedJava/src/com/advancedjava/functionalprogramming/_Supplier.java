package com.advancedjava.functionalprogramming;

import java.util.function.Supplier;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class _Supplier {

    public static void main(String[] args) {

    }
    static String url = "jdbc:mysql://bassure.in3306/kalaimaran_db";
    static String user = "Kalai";
    static String pass = "Kalai@4321";
    static Supplier<Connection> connectionSupplier = new Supplier<Connection>() {
        @Override
        public Connection get() {
            Connection connection = null;
            try {
                connection = DriverManager.getConnection(url, user, pass);
            } catch (SQLException ex) {
                Logger.getLogger(_Supplier.class.getName()).log(Level.SEVERE, null, ex);
            }
            return connection;
        }
    };
}
