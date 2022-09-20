package com.bankapp.dao;

import com.bankapp.entity.Bank;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Repository
public class BankDAOImpl implements BankDAO {
    private final List<Bank> banks;
    public BankDAOImpl() {
        List<Bank> temp = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            temp.add(new Bank(i,"Bank № " + i));
        }
        banks = Collections.unmodifiableList(temp);
    }

    @Override
    public List<Bank> getAllBanks() {
        return banks;
    }

    @Override
    public Bank getBank(int id) {
        return banks.get(id);
    }


}