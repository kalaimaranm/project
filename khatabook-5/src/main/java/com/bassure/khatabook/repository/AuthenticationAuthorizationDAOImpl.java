package com.bassure.khatabook.repository;

import com.bassure.khatabook.dao.AuthenticationAuthorizationDAO;
import com.bassure.khatabook.model.LoginCredential;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AuthenticationAuthorizationDAOImpl implements AuthenticationAuthorizationDAO {

    @Autowired
    MysqlKhatabookImpl mysqlKhatabookImpl;

    @Override
    public LoginCredential checkCredential(LoginCredential loginCredentail) throws ClassNotFoundException, SQLException {
        try (Connection connection = DbConnection.getConnection(); 
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM login_credential WHERE user_id =? AND password = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);) {
            preparedStatement.setInt(1, loginCredentail.getId());
            preparedStatement.setString(2, loginCredentail.getPassword());
            ResultSet result = preparedStatement.executeQuery();
            return result.absolute(1) ? new LoginCredential(result.getInt(1), result.getString(2), result.getString(3))
                    : null;

            
        } catch (SQLException sqle) {

            sqle.printStackTrace();
        }
        return null;

    }
    
   

}
