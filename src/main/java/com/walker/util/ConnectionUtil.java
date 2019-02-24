package com.walker.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	public static Connection getConnection() throws IOException, SQLException {
		Connection connection = null;
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String role = "bank_project_jdbc";
		String pw = "top-secret-password";		
		
		try {
//			System.out.println("Connection Utility");  // Debug
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection(url,role,pw);
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
}
/*
private static Connection connection;

public static Connection getConnection() throws IOException, SQLException {
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	Properties prop = new Properties();
	ClassLoader loader = Thread.currentThread().getContextClassLoader();
	prop.load(loader.getResourceAsStream("connection.properties"));
	String url = prop.getProperty("url");
	String username = prop.getProperty("user");
	String password = prop.getProperty("pass");
	if (connection == null || connection.isClosed()) {
		connection = DriverManager.getConnection(url, username, password);
	}
	return connection;
}
*/