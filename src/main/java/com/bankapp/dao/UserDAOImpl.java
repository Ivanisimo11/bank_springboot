package com.bankapp.dao;

import com.bankapp.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    private final List<User> users;

    public UserDAOImpl() {
        users = new ArrayList<>();
        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin");
        user.setBirthdate(new Date(2002, 12, 20));
        user.setEmail("admin@gmail.com");
        user.setLastName("admin");
        user.setFirstName("admin");
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
        return users.add(user);
    }

    @Override
    public User getProfileInfo(String username) {
        User user = new User();
        User tempUser = getUser(username);
        user.setFirstName(tempUser.getFirstName());
        user.setLastName(tempUser.getLastName());
        user.setEmail(tempUser.getEmail());
        user.setBirthdate(tempUser.getBirthdate());
        return user;
    }

    @Override
    public boolean updateUser(String username, User user) {
        user.setPassword(getUser(username).getPassword());
        user.setUsername(getUser(username).getUsername());
        user.setToken(getUser(username).getToken());
        users.remove(getUser(username));
        return users.add(user);
    }
}
