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
    public User getUser(int id) {
        return userDAO.getUser(id);
    }

    @Override
    public void addOrUpdateUser(User user) {
        userDAO.addOrUpdateUser(user);
    }
}
