package com.bankapp.dao;

import com.bankapp.entity.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


@Repository
public class BankDAOImpl implements BankDAO {
    private final Logger logger= Logger.getLogger("BankDAOImpl");
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Bank> getAllBanks() {
        logger.log(Level.INFO,"getAllBanks()");
        return mongoTemplate.findAll(Bank.class);
    }

    @Override
    public Bank getBank(int id) {
        logger.log(Level.INFO,"getBank(" + id + ")");
        BasicQuery query = new BasicQuery("{ _id: " + id + " }");
        return mongoTemplate.findOne(query, Bank.class);
    }

    @Override
    public void addBank(Bank bank) {
        logger.log(Level.INFO,"addBank(" + bank.toString() + ")");
        mongoTemplate.save(bank);
    }
}