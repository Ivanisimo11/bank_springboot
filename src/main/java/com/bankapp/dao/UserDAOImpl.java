package com.bankapp.dao;

import com.bankapp.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    private final List<User> users;

    public UserDAOImpl() {
        users = new ArrayList<>();
        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin");
        users.add(user);
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public User getUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean addUser(User user) {
        System.out.println(user);
        return users.add(user);
    }
}
