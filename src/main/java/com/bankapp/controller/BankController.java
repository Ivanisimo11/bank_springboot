package com.bankapp.controller;

import com.bankapp.entity.Bank;
import com.bankapp.entity.BankAccount;
import com.bankapp.entity.User;
import com.bankapp.service.BankAccountService;
import com.bankapp.service.BankService;
import com.bankapp.service.JwtTokenService;
import com.bankapp.service.UserService;
import org.springframework.data.repository.query.QueryLookupStrategy;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank")
public class BankController {
    private final BankService bankService;
    private final BankAccountService bankAccountService;
    private final UserService userService;
    private final JwtTokenService jwtTokenService;

    public BankController(BankService bankService, BankAccountService bankAccountService, UserService userService, JwtTokenService jwtTokenService) {
        this.bankService = bankService;
        this.bankAccountService = bankAccountService;
        this.userService = userService;
        this.jwtTokenService = jwtTokenService;
    }

    @PostMapping("/login")
    public User login(@RequestParam("user") String username, @RequestParam("password") String password) {
        String token = jwtTokenService.getJWTToken(username);
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setToken(token);
        userService.addUser(user);
        return user;

    }
    @GetMapping("/list")
    public List<Bank> list() {
        return bankService.getAllBanks();
    }

    @GetMapping("/{id}")
    public Bank get(@PathVariable int id) {
        return bankService.getBank(id);
    }

    @GetMapping("/{id}/account/list")
    public List<BankAccount> getAccountsList(@PathVariable int id){
        return bankAccountService.getBanksAccountByBankId(id);
    }
}
