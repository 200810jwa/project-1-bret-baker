package com.revpro1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revpro1.models.Reimbursement;
import com.revpro1.models.User;
import com.revpro1.utils.ConnectionUtil;

public class ReimbursementDAO implements IReimbursementDAO {
	
	Connection connection = null;
	PreparedStatement stmt = null;

	@Override
	public List<Reimbursement> getAllReimbursements() {
		
		List<Reimbursement> reimbs = new ArrayList<>();
		
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM project1.ers_reimbursement";

			PreparedStatement stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("reimb_id");
				double amount = rs.getDouble("reimb_amount");
				String submitted = rs.getString("reimb_submitted");
				String resolved = rs.getString("reimb_resolved");
				String description = rs.getString("reimb_description");
				byte[] receipt = rs.getBytes("reimb_receipt");
				String author = rs.getString("reimb_author");
				String resolver = rs.getString("reimb_resolver");
				int statusId = rs.getInt("reimb_status_id");
				int typeId = rs.getInt("reimb_type_id");
				Reimbursement reimb = new Reimbursement(id, amount, submitted, resolved, description, receipt, author, resolver, statusId, typeId);
				reimbs.add(reimb);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("WE FAILED TO RETRIEVE REIMBURSEMENTs");
			return null;
		} finally {
			closeResources();
		}
		
		for(int i = 0; i < reimbs.size(); i++) {
			System.out.println("reimbursement at index " + i);
			System.out.println(reimbs.get(i));
		}

		return reimbs;
		
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
