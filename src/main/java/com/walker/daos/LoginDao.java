package com.walker.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.walker.models.Employee;
import com.walker.util.ConnectionUtil;

public class LoginDao {

	public Employee getUser(String username) throws IOException {
		Employee emp = new Employee();
		
		String query = "SELECT * FROM reimb_users_table WHERE username = ?";
		try {
			Connection conn = ConnectionUtil.getConnection();
			PreparedStatement s = conn.prepareStatement(query);
			s.setString(1, username);
			
			ResultSet resultSet = s.executeQuery();	
			
			while (resultSet.next()) {
				emp.setId(resultSet.getInt("reimb_users_id"));
				emp.setUsername(resultSet.getString("username"));
				emp.setFirstName(resultSet.getString("firstname"));
				emp.setLastName(resultSet.getString("lastname"));
				emp.setEmail(resultSet.getString("email"));
				emp.setFinanceManager(resultSet.getInt("user_role"));
			}
			
			s.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}
	
	public String getSalt(String username) throws IOException {
		String salt = null;
		System.out.println("u" + username);
		String query = "SELECT pw_salt FROM reimb_users_table WHERE username = ?";
		
		try {
			Connection conn = ConnectionUtil.getConnection();
			PreparedStatement s = conn.prepareStatement(query);
			s.setString(1, username);
			
			ResultSet resultSet = s.executeQuery();	
			
			if (resultSet.next()) {
				salt = resultSet.getString("pw_salt");
				System.out.println("Salt:	" + salt);   // Debug
			}
			System.out.println("Salt2:	" + salt);   // Debug
			return salt;
//			s.close();

		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return salt;
	}
	
	public String getPWHash(String username, String db_password) throws IOException {
		String query = "SELECT user_password FROM reimb_users_table WHERE username = ?";
		
		try {
			Connection conn = ConnectionUtil.getConnection();
			PreparedStatement s = conn.prepareStatement(query);
			s.setString(1, username);
			
			ResultSet resultSet = s.executeQuery();	
			
			while (resultSet.next()) {
				db_password = resultSet.getString("user_password");
			}
			
			s.close();

		}catch(SQLException e) {
			e.printStackTrace();
		}
		return db_password;
	}
}
