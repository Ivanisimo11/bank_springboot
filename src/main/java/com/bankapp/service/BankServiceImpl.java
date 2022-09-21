package com.bankapp.service;

import com.bankapp.dao.BankDAO;
import com.bankapp.entity.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankServiceImpl implements BankService {
    @Autowired
    private BankDAO bankDAO;


    @Override
    public List<Bank> getAllBanks() {
        return bankDAO.getAllBanks();
    }

    @Override
    public Bank getBank(int id) {
        return bankDAO.getBank(id);
    }
}
