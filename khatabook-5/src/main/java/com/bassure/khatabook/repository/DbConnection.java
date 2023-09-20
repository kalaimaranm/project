package com.bassure.khatabook.repository;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Setter
@Getter
@Repository
public class DbConnection {

//    private static final String url = "jdbc:mysql://bassure.in:3306/kalaimaran_db";
//    private static final String user = "Kalai";
//    private static final String pass = "Kalai@4321";
//    public static Connection getConnection() throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        Connection connection = DriverManager.getConnection(url, user, pass);
//        return connection;
//    }
    private static DataSource dataSource;
    public DbConnection(DataSource dataSource) {
        DbConnection.dataSource = dataSource;
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {

        return dataSource.getConnection();
    }

}
