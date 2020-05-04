/**
 *
 */
package com.mindtree.springboot.shoppingcart.dao;

import com.mindtree.springboot.shoppingcart.model.User;

/**
 * The Interface UserDao.
 *
 * @author Sridevi Uppala
 */
public interface UserDao {

    /**
     * Gets the user.
     *
     * @param user the user
     * @return the user
     */
    User getUser(User user);

    /**
     * Save user.
     *
     * @param user the user
     * @return the user
     */
    User saveUser(User user);
}
