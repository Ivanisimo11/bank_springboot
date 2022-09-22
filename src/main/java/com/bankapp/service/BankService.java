package com.bankapp.service;

import com.bankapp.entity.Bank;

import java.util.List;

public interface BankService {
    public List<Bank> getAllBanks();
    public Bank getBank(int id);
    public void addBank(Bank bank);
}
