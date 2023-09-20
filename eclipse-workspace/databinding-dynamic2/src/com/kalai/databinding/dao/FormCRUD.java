package com.kalai.databinding.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.kalai.databinding.dto.User;
import com.kalai.databinding.dto.UserRecord;

@Component
public class FormCRUD {

	DBConnection DBconnection = new DBConnection();

	public boolean creatAccount(User user) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		try (Connection connection = DBconnection.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("insert into form values (?,?,?,?,?,?,?)");) {
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getAddress());
			preparedStatement.setString(4, user.getPhone());
			preparedStatement.setInt(5, user.getAge());
			preparedStatement.setString(6, user.getGender());
			preparedStatement.setString(7, user.getPassword());
       
			
			return preparedStatement.executeUpdate() != 0;
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return false;
	}

	public boolean updateUserDetails(int id, UserRecord userRecord) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
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

	public UserRecord getUser(String email, String password) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		try (Connection connection = DBconnection.getConnection();
				PreparedStatement prepareStatement = connection.prepareStatement(
						"select * from form where email = ? and password = ?", ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_UPDATABLE);) {

			prepareStatement.setString(1, email);
			prepareStatement.setString(2, password);
			ResultSet result = prepareStatement.executeQuery();
			if (result.absolute(1)) {
				UserRecord userRecord = new UserRecord(result.getString(2), result.getString(3), result.getString(8),
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
