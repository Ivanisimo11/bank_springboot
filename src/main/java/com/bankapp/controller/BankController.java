package com.bankapp.controller;

import com.bankapp.entity.Bank;
import com.bankapp.entity.BankAccount;
import com.bankapp.service.BankAccountService;
import com.bankapp.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/bank")
public class BankController {
    private final Logger logger= Logger.getLogger("BankController");
    @Autowired
    private BankService bankService;
    @Autowired
    private BankAccountService bankAccountService;


    @GetMapping("/list")
    public List<Bank> list() {
        logger.log(Level.INFO, "(get)bank/list - list()");
        return bankService.getAllBanks();
    }

    @GetMapping("/{id}")
    public Bank get(@PathVariable int id) {
        logger.log(Level.INFO, "(get)bank/{id} - get(" + id + ")");
        return bankService.getBank(id);
    }

    @GetMapping("/{id}/account/list")
    public List<BankAccount> getAccountsList(@PathVariable int id){
        logger.log(Level.INFO, "(get)bank/{id}/account/list - getAccountsList(" + id + ")");

        return bankAccountService.getBanksAccountByBankId(id);
    }
    @PostMapping("/add")
    public void save(@RequestBody Bank bank) {
        logger.log(Level.INFO, "(post)bank/add - save(" + bank.toString() + ")");
        bankService.addBank(bank);
    }
}
