/**
 *
 */
package com.mindtree.springboot.shoppingcart.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.mindtree.springboot.shoppingcart.model.User;
import com.mindtree.springboot.shoppingcart.repository.UserRepository;

/**
 * @author Sridevi Uppala
 *
 */
@Repository
public class UserDaoImpl implements UserDao {

    /**
     * userRespository
     */
    @Resource
    UserRepository userRespository;

    /**
     *getUser
     */
    @Override
    public User getUser(User user) {
        User userResult = userRespository.findByName(user.getName());
        return userResult != null ? userResult : null;
    }

    /**
     *saveUser
     */
    @Override
    public User saveUser(User user) throws RuntimeException {
        return userRespository.save(user);
    }

}
