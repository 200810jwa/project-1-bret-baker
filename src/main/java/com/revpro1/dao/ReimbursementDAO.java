package com.revpro1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revpro1.models.Reimbursement;
import com.revpro1.models.User;
import com.revpro1.models.templates.InsertReimbTemplate;
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
				Reimbursement reimb = new Reimbursement(id, amount, submitted, resolved, description, receipt, author,
						resolver, statusId, typeId);
				reimbs.add(reimb);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("WE FAILED TO RETRIEVE REIMBURSEMENTs");
			return null;
		} finally {
			closeResources();
		}

//		for(int i = 0; i < reimbs.size(); i++) {
//			System.out.println("reimbursement at index " + i);
//			System.out.println(reimbs.get(i));
//		}

		return reimbs;

	}

	@Override
	public List<Reimbursement> getById(int id) {

		List<Reimbursement> reimbs = new ArrayList<>();

		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM project1.ers_reimbursement WHERE reimb_id = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int id1 = rs.getInt("reimb_id");
				double amount = rs.getDouble("reimb_amount");
				String submitted = rs.getString("reimb_submitted");
				String resolved = rs.getString("reimb_resolved");
				String description = rs.getString("reimb_description");
				byte[] receipt = rs.getBytes("reimb_receipt");
				String author = rs.getString("reimb_author");
				String resolver = rs.getString("reimb_resolver");
				int statusId = rs.getInt("reimb_status_id");
				int typeId = rs.getInt("reimb_type_id");
				Reimbursement reimb = new Reimbursement(id1, amount, submitted, resolved, description, receipt, author,
						resolver, statusId, typeId);
				reimbs.add(reimb);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("WE FAILED TO RETRIEVE REIMBURSEMENT");
			return null;
		} finally {
			closeResources();
		}

//		for(int i = 0; i < reimbs.size(); i++) {
//			System.out.println("reimbursement at index " + i);
//			System.out.println(reimbs.get(i));
//		}

		return reimbs;

	}
	
	@Override
	public boolean approveById(int id) {

		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "UPDATE project1.ers_reimbursement SET reimb_resolved = CURRENT_TIMESTAMP, reimb_status_id = 2 WHERE reimb_id = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, id);

			stmt.executeUpdate();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("WE FAILED TO UPDATE REIMBURSEMENT");
			return false;
		} finally {
			closeResources();
		}
		
	}
	
	@Override
	public boolean denyById(int id) {

		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "UPDATE project1.ers_reimbursement SET reimb_resolved = NULL, reimb_status_id = 3 WHERE reimb_id = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, id);

			stmt.executeUpdate();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("WE FAILED TO UPDATE REIMBURSEMENT");
			return false;
		} finally {
			closeResources();
		}
		
	}
	
	@Override
	public List<Reimbursement> getByAuthorId(int authorId) {

		List<Reimbursement> reimbs = new ArrayList<>();

		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM project1.ers_reimbursement WHERE reimb_author = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, authorId);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int id1 = rs.getInt("reimb_id");
				double amount = rs.getDouble("reimb_amount");
				String submitted = rs.getString("reimb_submitted");
				String resolved = rs.getString("reimb_resolved");
				String description = rs.getString("reimb_description");
				byte[] receipt = rs.getBytes("reimb_receipt");
				String author = rs.getString("reimb_author");
				String resolver = rs.getString("reimb_resolver");
				int statusId = rs.getInt("reimb_status_id");
				int typeId = rs.getInt("reimb_type_id");
				Reimbursement reimb = new Reimbursement(id1, amount, submitted, resolved, description, receipt, author,
						resolver, statusId, typeId);
				reimbs.add(reimb);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("WE FAILED TO RETRIEVE REIMBURSEMENTS BY AUTHOR");
			return null;
		} finally {
			closeResources();
		}

//		for(int i = 0; i < reimbs.size(); i++) {
//			System.out.println("reimbursement at index " + i);
//			System.out.println(reimbs.get(i));
//		}

		return reimbs;
		
	}

	@Override
	public boolean insert(InsertReimbTemplate insertReimbTemplate) {

		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "INSERT INTO project1.ers_reimbursement (reimb_amount, reimb_description, reimb_author, reimb_type_id) VALUES (?, ?, ?, ?)";

			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setDouble(1, insertReimbTemplate.getAmount());
			stmt.setString(2, insertReimbTemplate.getDescription());
			stmt.setInt(3, insertReimbTemplate.getAuthor());
			stmt.setInt(4, insertReimbTemplate.getType());

			stmt.executeUpdate();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("WE FAILED TO INSERT REIMBURSEMENT");
			return false;
		} finally {
			closeResources();
		}
		
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
