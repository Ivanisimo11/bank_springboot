package com.bankapp.service;

import com.bankapp.dao.BankAccountDAO;
import com.bankapp.entity.BankAccount;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankAccountServiceImpl implements BankAccountService{
    private final BankAccountDAO bankAccountDAO;
    public BankAccountServiceImpl(BankAccountDAO bankAccountDAO) {
        this.bankAccountDAO = bankAccountDAO;
    }

    @Override
    public List<BankAccount> getBanksAccountByBankId(int id) {
        return bankAccountDAO.getBanksAccountByBankId(id);
    }
}
