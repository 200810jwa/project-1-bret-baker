package com.revpro1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.revpro1.models.User;
import com.revpro1.utils.ConnectionUtil;

public class UserDAO implements IUserDAO {

	Connection connection = null;
	PreparedStatement stmt = null;

	@Override
	public User getByUsername(String username) {

		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM project1.ers_users WHERE ers_username = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, username);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				return new User(
					rs.getInt("ers_users_id"),
					rs.getString("ers_username"),
					rs.getString("ers_password"),
					rs.getString("user_first_name"),
					rs.getString("user_last_name"), 
					rs.getString("user_email"), 
					rs.getInt("user_role_id"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			closeResources();
		}

		return null;

	}

	private void closeResources() {
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException e) {
			System.out.println("Could not close statement!");
			e.printStackTrace();
		}

		try {
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			System.out.println("Could not close connection!");
			e.printStackTrace();
		}
	}

}