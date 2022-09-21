package com.bankapp.service;

import com.bankapp.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    public User getUser(String username);

    public boolean addUser(User user);

    public User getProfileInfo(String username);

    public boolean updateUser(String username, User user);

}
