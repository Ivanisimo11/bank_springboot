package com.bankapp.service;

import com.bankapp.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    public User getUser(int id);

    public void addOrUpdateUser(User user);

}
