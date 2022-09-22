package com.bankapp.dao;

import com.bankapp.entity.User;

import java.util.List;

public interface UserDAO {
    public List<User> getAllUsers();

    public User getUser(int id);

    public void addOrUpdateUser(User user);
}