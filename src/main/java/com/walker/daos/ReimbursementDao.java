package com.walker.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.walker.dto.CreateReimbDTO;
import com.walker.dto.UpdateReimbDTO;
import com.walker.models.Reimbursement;
import com.walker.util.ConnectionUtil;

public class ReimbursementDao {

	public List<Reimbursement> getReimbursementsByIdStatus(int user_id, int status_id) throws IOException {
		List<Reimbursement> reimbsList = new ArrayList<Reimbursement>();
		
		String query = "SELECT * FROM reimbursements_table " + 
				"WHERE author = (SELECT reimb_users_id FROM reimb_users_table WHERE reimb_users_id = ?) " + 
				"AND reimb_status = ?";
		
		try {
			Connection conn = ConnectionUtil.getConnection();
			PreparedStatement s = conn.prepareStatement(query);
			s.setInt(1, user_id);
			s.setInt(2, status_id);
			ResultSet resultSet = s.executeQuery();	
			
			if(status_id == 1) {
				while (resultSet.next()) {
					Reimbursement reimbs = new Reimbursement();
					reimbs.setId(resultSet.getInt("reimb_id"));
					reimbs.setAmount(resultSet.getDouble("amount"));
					reimbs.setSubmitted(resultSet.getTimestamp("submitted"));
					reimbs.setDescription(resultSet.getString("description"));
					reimbs.setAuthor_id(resultSet.getInt("author"));
					reimbs.setType_id(resultSet.getInt("reimb_type"));
					reimbs.setStatus_id(status_id);
					reimbsList.add(reimbs);
				}
			} else {
				while (resultSet.next()) {
					Reimbursement reimbs = new Reimbursement();
					reimbs.setId(resultSet.getInt("reimb_id"));
					reimbs.setAmount(resultSet.getDouble("amount"));
					reimbs.setSubmitted(resultSet.getTimestamp("submitted"));
					reimbs.setResolved(resultSet.getTimestamp("resolved"));
					reimbs.setDescription(resultSet.getString("description"));
					reimbs.setExplaination(resultSet.getString("explaination"));
					reimbs.setResolver_id(resultSet.getInt("resolver"));
					reimbs.setAuthor_id(resultSet.getInt("author"));
					reimbs.setType_id(resultSet.getInt("reimb_type"));
					reimbs.setStatus_id(status_id);
					reimbsList.add(reimbs);
				}
			}
			
			s.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		System.out.println(reimbsList); // Debug
		return reimbsList;
	}

	public List<Reimbursement> getReimbursementsByStatus(int status_id) throws IOException {
		List<Reimbursement> reimbsList = new ArrayList<Reimbursement>();
		
		String query = "SELECT * FROM reimbursements_table WHERE reimb_status = ?";
		
		try {
			Connection conn = ConnectionUtil.getConnection();
			PreparedStatement s = conn.prepareStatement(query);
			s.setInt(1, status_id);
			ResultSet resultSet = s.executeQuery();	
			
			if(status_id == 1) {
				while (resultSet.next()) {
					Reimbursement reimbs = new Reimbursement();
					reimbs.setId(resultSet.getInt("reimb_id"));
					reimbs.setAmount(resultSet.getDouble("amount"));
					reimbs.setSubmitted(resultSet.getTimestamp("submitted"));
					reimbs.setDescription(resultSet.getString("description"));
					reimbs.setAuthor_id(resultSet.getInt("author"));
					reimbs.setType_id(resultSet.getInt("reimb_type"));
					reimbs.setStatus_id(status_id);
					reimbsList.add(reimbs);
				}
			} else {
				while (resultSet.next()) {
					Reimbursement reimbs = new Reimbursement();
					reimbs.setId(resultSet.getInt("reimb_id"));
					reimbs.setAmount(resultSet.getDouble("amount"));
					reimbs.setSubmitted(resultSet.getTimestamp("submitted"));
					reimbs.setResolved(resultSet.getTimestamp("resolved"));
					reimbs.setDescription(resultSet.getString("description"));
					reimbs.setExplaination(resultSet.getString("explaination"));
					reimbs.setResolver_id(resultSet.getInt("resolver"));
					reimbs.setAuthor_id(resultSet.getInt("author"));
					reimbs.setType_id(resultSet.getInt("reimb_type"));
					reimbs.setStatus_id(status_id);
					reimbsList.add(reimbs);
				}
			}
			
			s.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		System.out.println(reimbsList); // Debug
		return reimbsList;
	}
	
	public void addReimbursementById(CreateReimbDTO cr) throws IOException {
		String query = "INSERT INTO reimbursements_table (amount, submitted, resolved, description, receipt, explaination, resolver, author, reimb_status, reimb_type)"
						+ " VALUES (?, current_timestamp, NULL, ?, NULL, NULL, NULL, ?, 1, ?)";
		
		try {
			Connection conn = ConnectionUtil.getConnection();
			PreparedStatement s = conn.prepareStatement(query);
			s.setDouble(1, cr.getAmount());
			s.setString(2, cr.getDescription());
			s.setInt(3, cr.getAuthor_id());
			s.setInt(4, cr.getType_id());
			s.executeUpdate();
			
			s.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateReimbursementStatus(UpdateReimbDTO ur) throws IOException {
		String query = "UPDATE reimbursements_table SET resolved = current_timestamp, "
				+ "explaination = ?, resolver = ?, reimb_status = ? WHERE reimb_id = ?";
		
		try {
			Connection conn = ConnectionUtil.getConnection();
			PreparedStatement s = conn.prepareStatement(query);
			s.setString(1, ur.getExplaination());
			s.setInt(2, ur.getResolver_id());
			s.setInt(3, ur.getStatus_id());
			s.setInt(4, ur.getId());
			s.executeUpdate();
			
			s.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
