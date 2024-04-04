package com.pedicab.services;

import java.util.List;

import com.pedicab.daos.UserDAO;
import com.pedicab.daos.UserDAOImpl;
import com.pedicab.models.User;

public class UserService {

	private UserDAO userDAO = new UserDAOImpl();
	
	public List<User> getAllUsers(){
		try {
			return userDAO.getAll();
		} catch (Exception e) {
			throw new RuntimeException("failed to get all the users", e);
		}
	}
	
	public int addUser(String email, String password, String name) {
		try {
			User user = new User(email, password, name);
			return userDAO.insert(user);
		} catch (Exception e) {
			throw new RuntimeException("failed to add user", e);
		}
	}
	
	
}
