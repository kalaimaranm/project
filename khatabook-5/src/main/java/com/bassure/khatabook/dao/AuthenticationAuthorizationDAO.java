package com.bassure.khatabook.dao;

import com.bassure.khatabook.model.LoginCredential;
import java.sql.SQLException;

public interface AuthenticationAuthorizationDAO {

    public LoginCredential checkCredential(LoginCredential loginCredentail) throws ClassNotFoundException, SQLException;
}
