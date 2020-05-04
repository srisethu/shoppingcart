package com.mindtree.springboot.shoppingcart.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.springboot.shoppingcart.dao.UserDao;
import com.mindtree.springboot.shoppingcart.model.User;
import com.mindtree.springboot.shoppingcart.service.UserService;

/**
 * The implementation of UserService interface.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{

    /** The user dao. */
    @Autowired
    private UserDao userDao;


    /**
     * Gets the user.
     *
     * @param user the user
     * @return the user
     */
    @Override
    public User getUser(User user) {
        return userDao.getUser(user);
    }


    /**
     * Save user.
     *
     * @param user the user
     * @return the user
     */
    @Override
    public User saveUser(User user) {
        return userDao.saveUser(user);
    }

}
