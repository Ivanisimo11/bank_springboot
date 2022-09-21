package com.bankapp.service;

import com.bankapp.dao.BankAccountDAO;
import com.bankapp.entity.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankAccountServiceImpl implements BankAccountService{
    @Autowired
    private BankAccountDAO bankAccountDAO;

    @Override
    public List<BankAccount> getBanksAccountByBankId(int id) {
        return bankAccountDAO.getBanksAccountByBankId(id);
    }
}
