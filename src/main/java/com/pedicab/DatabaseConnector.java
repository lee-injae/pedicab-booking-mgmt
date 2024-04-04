package com.pedicab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnector {
	
	private static final String URL = "jdbc:mysql://localhost:3306/pedicab_db";
	private static final String USER = "root";
	private static final String PASSWORD = "password";
	
	private DatabaseConnector(){
	}
	
	public static Connection getConnection() throws SQLException {
		
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
	
	public static void closeConnection(Connection connection) throws SQLException {
		connection.close();
	}
	
	public static void closeStatement(Statement statement) throws SQLException {
		statement.close();
	}
	
	public static void closePreparedStatement(PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.close();
	}

	public static void closeResultSet(ResultSet resultSet) throws SQLException {
		resultSet.close();
	}
	
	
	
	
	
//	public static void main(String[] args) {
//		try {
//			Connection conn = getConnection();
//			System.out.println("Connection successful " + conn);
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
}
