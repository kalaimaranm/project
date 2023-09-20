package com.bassure.khatabook.service;

import com.bassure.khatabook.model.LoginCredential;
import com.bassure.khatabook.repository.MysqlKhatabookImpl;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationAuthorizationService {

    @Autowired
    MysqlKhatabookImpl mysqlKhatabookImpl;

    public LoginCredential loginCredential(LoginCredential loginCredential) throws ClassNotFoundException, SQLException {

        return mysqlKhatabookImpl.getAuthenticationAuthorizationDAOImpl().checkCredential(loginCredential);

    }

}
