package com.bankapp.dao;

import com.bankapp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
public class UserDAOImpl implements UserDAO {
    private final Logger logger= Logger.getLogger("UserDAOImpl");
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<User> getAllUsers() {
        logger.log(Level.INFO, "getAllUsers()");
        return mongoTemplate.findAll(User.class);
    }

    @Override
    public User getUser(int id) {
        logger.log(Level.INFO, "getUser(" + id + ")");
        BasicQuery query = new BasicQuery("{ _id: " + id + " }");
        return mongoTemplate.findOne(query, User.class);
    }

    @Override
    public void addOrUpdateUser(User user) {
        logger.log(Level.INFO, "addOrUpdateUser(" + user.toString() + ")");
        mongoTemplate.save(user);
    }

}
