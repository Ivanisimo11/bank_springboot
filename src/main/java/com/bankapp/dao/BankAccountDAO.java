package com.bankapp.dao;

import com.bankapp.entity.BankAccount;

import java.util.List;

public interface BankAccountDAO {
    public List<BankAccount> getBanksAccountByBankId(int id);
}
