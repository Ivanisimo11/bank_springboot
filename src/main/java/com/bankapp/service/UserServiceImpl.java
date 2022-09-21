package com.bankapp.service;

import com.bankapp.dao.UserDAO;
import com.bankapp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public User getUser(String username) {
        return userDAO.getUser(username);
    }

    @Override
    public boolean addUser(User user) {
        return userDAO.addUser(user);
    }

    @Override
    public User getProfileInfo(String username) {
        return userDAO.getProfileInfo(username);
    }

    @Override
    public boolean updateUser(String username, User user) {
        return userDAO.updateUser(username,user);
    }
}
