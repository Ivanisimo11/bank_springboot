package com.bankapp.dao;

import com.bankapp.entity.Bank;

import java.util.List;

public interface BankDAO {
    public List<Bank> getAllBanks();
    public Bank getBank(int id);
    public void addBank(Bank bank);
}
