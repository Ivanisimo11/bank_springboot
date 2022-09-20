package com.bankapp.dao;

import com.bankapp.entity.BankAccount;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class BankAccountDAOImpl implements BankAccountDAO {
    private final List<BankAccount> bankAccounts;

    public BankAccountDAOImpl() {
        List<BankAccount> temp = new ArrayList<>();
        for (int i = 0; i < 125; i++) {
            temp.add(new BankAccount(i, i * 50, i % 20));
        }
        bankAccounts = Collections.unmodifiableList(temp);
    }

    @Override
    public List<BankAccount> getBanksAccountByBankId(int id) {
        List<BankAccount> bankAccountList = new ArrayList<>();
        for (BankAccount bankAccount : bankAccounts) {
            if (bankAccount.getBankId() == id) {
                bankAccountList.add(bankAccount);
            }
        }
        return bankAccountList;
    }
}
