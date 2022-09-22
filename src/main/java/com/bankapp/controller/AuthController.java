package com.bankapp.controller;

import com.bankapp.entity.User;
import com.bankapp.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.message.AuthException;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class AuthController {
    private final Logger logger= Logger.getLogger("AuthController");
    @Autowired
    private AuthService authService;


    @PostMapping("/login")
    public User login(@RequestBody User user) throws AuthException {
        logger.log(Level.INFO, "(post)/login - login(" + user.toString() + ")");
        return authService.auth(user);
    }
}
