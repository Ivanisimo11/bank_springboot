package com.bankapp.controller;

import com.bankapp.entity.Bank;
import com.bankapp.entity.BankAccount;
import com.bankapp.service.BankAccountService;
import com.bankapp.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank")
public class BankController {
    @Autowired
    private BankService bankService;
    @Autowired
    private BankAccountService bankAccountService;


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
