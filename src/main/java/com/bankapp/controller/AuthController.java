package com.bankapp.controller;

import com.bankapp.entity.User;
import com.bankapp.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.message.AuthException;

@RestController
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public User login(@RequestBody User user) throws AuthException {
        return authService.auth(user);
    }
}
