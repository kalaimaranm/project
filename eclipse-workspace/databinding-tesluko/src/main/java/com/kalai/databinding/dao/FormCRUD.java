package com.kalai.databinding.dao;

import com.kalai.databinding.dto.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

//import com.kalai.databinding.dto.UserRecord;
@Component
public class FormCRUD {

	DBConnection DBconnection = new DBConnection();

	public boolean creatAccount(UserRecords user) throws ClassNotFoundException, SQLException {
		try (Connection connection = DBconnection.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("insert into form values (?,?,?,?,?,?,?)");) {
			preparedStatement.setString(1, user.name());
			preparedStatement.setString(2, user.email());
			preparedStatement.setString(3, user.address());
			preparedStatement.setString(4, user.phone());
			preparedStatement.setInt(5, user.age());
			preparedStatement.setString(6, user.gender());
			preparedStatement.setString(7, user.password());

			return preparedStatement.execute();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return false;
	}

	public boolean updateUserDetails(int id, UserRecords userRecord) throws ClassNotFoundException, SQLException {
		try (Connection connection = DBconnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(
						"update table form set name = ?, address = ?, phone = ?, age = ?, gender = ? where id = ?");) {
			preparedStatement.setString(1, userRecord.name());
			preparedStatement.setString(2, userRecord.address());
			preparedStatement.setInt(3, userRecord.age());
			preparedStatement.setString(4, userRecord.gender());
			preparedStatement.setInt(5, id);
			return preparedStatement.executeUpdate() != 0;
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return false;

	}

	public UserRecords getUser(String email, String password) throws SQLException, ClassNotFoundException {
		try (Connection connection = DBconnection.getConnection();
				PreparedStatement prepareStatement = connection.prepareStatement(
						"select * from form where email = ? and password = ?", ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_UPDATABLE);) {

			prepareStatement.setString(1, email);
			prepareStatement.setString(2, password);
			ResultSet result = prepareStatement.executeQuery();
			if (result.absolute(1)) {
				UserRecords userRecord = new UserRecords(result.getString(2), result.getString(3), result.getString(8),
						result.getInt(6), result.getString(7), result.getString(4), result.getString(5));
				return userRecord;
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return null;
	}

	// not implemented
	public boolean deleteUser() {
		return false;
	}

}
