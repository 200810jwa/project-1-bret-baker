package com.revpro1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revpro1.models.User;
import com.revpro1.utils.ConnectionUtil;

public class UserDAO implements IUserDAO {

	Connection connection = null;
	PreparedStatement stmt = null;

	@Override
	public List<User> getByUsername(String username) {
		
		List<User> users = new ArrayList<>();
		
//		System.out.println("getByUsername invoked with username = " + username);

		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM project1.ers_users WHERE ers_username = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, username);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("ers_users_id");
				String username1 = rs.getString("ers_username");
				String password = rs.getString("ers_password");
				String firstname = rs.getString("user_first_name");
				String lastname = rs.getString("user_last_name");
				String email = rs.getString("user_email");
				int roleId = rs.getInt("user_role_id");
				User user = new User(id, username1, password, firstname, lastname, email, roleId);
				users.add(user);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("WE FAILED TO RETRIEVE USERs");
			return null;
		} finally {
			closeResources();
		}
		
//		for(int i = 0; i < users.size(); i++) {
//			System.out.println("user at index " + i);
//			System.out.println(users.get(i));
//		}

		return users;

	}
	
	@Override
	public List<User> getById(int id) {
		
		List<User> users = new ArrayList<>();
		
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM project1.ers_users WHERE ers_users_id = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int id1 = rs.getInt("ers_users_id");
				String username1 = rs.getString("ers_username");
				String password = rs.getString("ers_password");
				String firstname = rs.getString("user_first_name");
				String lastname = rs.getString("user_last_name");
				String email = rs.getString("user_email");
				int roleId = rs.getInt("user_role_id");
				User user = new User(id1, username1, password, firstname, lastname, email, roleId);
				users.add(user);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			closeResources();
		}

		return users;
		
	}
	
	@Override
	public void updatePassword(String password, String username) {
		
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "UPDATE project1.ers_users SET ers_password = ? WHERE ers_username = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, password);
			stmt.setString(2, username);

			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		} finally {
			closeResources();
		}
		
		return;
		
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
