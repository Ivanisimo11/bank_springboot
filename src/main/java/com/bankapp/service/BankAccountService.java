package com.bankapp.service;

import com.bankapp.entity.BankAccount;

import java.util.List;

public interface BankAccountService {
    public List<BankAccount> getBanksAccountByBankId(int id);
}
