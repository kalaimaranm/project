package com.kalai.databinding.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private String url = "jdbc:mysql://bassure.in:3306/kalaimaran_db";   
	String userName = "Kalai";
	String password = "Kalai@4321";

	public Connection getConnection() throws SQLException, ClassNotFoundException {
//		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection(url, userName, password);
        
		return connection;
	}

}
