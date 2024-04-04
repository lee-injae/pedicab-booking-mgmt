package com.pedicab.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pedicab.DatabaseConnector;
import com.pedicab.models.User;

public class UserDAOImpl implements UserDAO {

	//CRUD - Retrieve
	@Override
	public User get(int userId) throws SQLException {
		// TODO Auto-generated method stub
		
		Connection conn = DatabaseConnector.getConnection();
		User user = null; 
		
		String sql = "SELECT user_id, user_email, user_password, user_name "
				+ "FROM users WHERE user_id = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, userId);
		
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
			int oid = rs.getInt("user_id");
			String userEmail = rs.getString("user_email");
			String userPassword = rs.getString("user_password");
			String userName = rs.getString("user_name");
			
		
			user = new User(oid, userEmail, userPassword, userName);
		}
		
		DatabaseConnector.closeResultSet(rs);
		DatabaseConnector.closePreparedStatement(ps);
		DatabaseConnector.closeConnection(conn);
		
		return user;
	}
		 

	@Override
	public List<User> getAll() throws SQLException {
		
		try (Connection conn = DatabaseConnector.getConnection()){
			String sql = "SELECT * FROM users;";
			
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			List<User> users = new ArrayList<>();
			
			while (rs.next()) {
				User user = new User();
				user.setUserId(rs.getInt("user_id"));
				user.setUserEmail(rs.getString("user_email"));
				user.setUserName(rs.getString("user_name"));
				
				users.add(user);
			}
			return users;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int save(User user) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(User user) throws SQLException {
		
		Connection conn = DatabaseConnector.getConnection();
		
		String sql = "INSERT INTO users"
				+ " (user_email, user_password, user_name)"
				+ " VALUES (?, ?, ?)";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, user.getUserEmail());
		ps.setString(2, user.getUserPassword());
		ps.setString(3, user.getUserName());
		
		int result = ps.executeUpdate();
		
		DatabaseConnector.closePreparedStatement(ps);
		DatabaseConnector.closeConnection(conn);
		
		return result;
	}

	@Override
	public int update(User user) throws SQLException {
		Connection conn = DatabaseConnector.getConnection();
		
		String sql = "UPDATE users "
				+ "SET user_email = ?, user_password = ?, user_name =? "
				+ "WHERE user_id =?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, user.getUserEmail());
		ps.setString(2, user.getUserPassword());
		ps.setString(3, user.getUserName());
		ps.setInt(4, user.getUserId());
		
		int result = ps.executeUpdate();
		
		DatabaseConnector.closePreparedStatement(ps);
		DatabaseConnector.closeConnection(conn);
		
		return result;
	}

	@Override
	public int delete(User user) throws SQLException {
		Connection conn = DatabaseConnector.getConnection();
		
		String sql = "DELETE FROM users "
				+ "WHERE user_id = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, user.getUserId());
		
		int result = ps.executeUpdate();
		
		DatabaseConnector.closePreparedStatement(ps);
		DatabaseConnector.closeConnection(conn);
		
		return result; 
	}

}
