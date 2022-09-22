package com.bankapp.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class BankAccount {
    @Id
    private int id;
    private int balance;
    private int bankId;

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", balance=" + balance +
                ", bankId=" + bankId +
                '}';
    }

    public BankAccount(int id, int balance, int bankId) {
        this.id = id;
        this.balance = balance;
        this.bankId = bankId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }
}
