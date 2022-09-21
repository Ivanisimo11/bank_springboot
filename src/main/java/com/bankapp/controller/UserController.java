package com.bankapp.controller;

import com.bankapp.entity.User;
import com.bankapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("/{username}")
    public User get(@PathVariable String username) {
        return userService.getProfileInfo(username);
    }

    @PostMapping("/{username}")
    public boolean save(@PathVariable String username, @RequestBody User user) {
        return userService.updateUser(username,user);
    }
}
