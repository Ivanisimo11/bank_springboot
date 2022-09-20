package com.bankapp.service;

import com.bankapp.dao.BankDAO;
import com.bankapp.entity.Bank;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankServiceImpl implements BankService {
    private final BankDAO bankDAO;
    public BankServiceImpl(BankDAO bankDAO) {
        this.bankDAO = bankDAO;
    }

    @Override
    public List<Bank> getAllBanks() {
        return bankDAO.getAllBanks();
    }

    @Override
    public Bank getBank(int id) {
        return bankDAO.getBank(id);
    }
}
