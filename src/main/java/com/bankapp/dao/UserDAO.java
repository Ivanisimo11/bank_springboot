package com.bankapp.dao;

import com.bankapp.entity.User;

import java.util.List;

public interface UserDAO {
    public List<User> getAllUsers();

    public User getUser(String username);

    public boolean addUser(User user);
}