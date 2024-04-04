package com.pedicab.services;

import java.sql.SQLException;
import java.util.List;

import com.pedicab.daos.UserDAO;
import com.pedicab.daos.UserDAOImpl;
import com.pedicab.models.User;

public class UserService {

    private UserDAO userDAO = new UserDAOImpl();
    
    // Propagates any SQLExceptions or other exceptions
    public List<User> getAllUsers() throws Exception {
        return userDAO.getAll();
    }
    
    public User getUserById(int userId) throws SQLException {
        return userDAO.get(userId);
    }
    
    public int addUser(String email, String password, String name) throws Exception {
        User user = new User(email, password, name);
        return userDAO.insert(user);
    }
}
