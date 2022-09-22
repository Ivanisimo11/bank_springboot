package com.bankapp.dao;

import com.bankapp.entity.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
public class BankAccountDAOImpl implements BankAccountDAO {
    private final Logger logger= Logger.getLogger("BankAccountDAOImpl");
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<BankAccount> getBanksAccountByBankId(int id) {
        logger.log(Level.INFO,"getBanksAccountByBankId(" + id + ")");
        BasicQuery query = new BasicQuery("{ bankId: " + id + " }");
        return mongoTemplate.find(query, BankAccount.class);
    }
}
