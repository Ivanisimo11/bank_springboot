package com.bankapp.controller;

import com.bankapp.entity.User;
import com.bankapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/user")
public class UserController {
    private final Logger logger= Logger.getLogger("UserController");
    @Autowired
    private UserService userService;


    @GetMapping("/{id}")
    public User get(@PathVariable int id) {
        logger.log(Level.INFO, "(get)user/{id} - get(" + id + ")");
        return userService.getUser(id);
    }

    @PostMapping("/{id}")
    public void save(@RequestBody User user) {
        logger.log(Level.INFO, "(post)bank/{id} - save(" + user.toString() + ")");
         userService.addOrUpdateUser(user);
    }
}
