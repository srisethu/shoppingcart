package com.mindtree.springboot.shoppingcart.service;

import com.mindtree.springboot.shoppingcart.model.User;

/**
 * The Interface UserService.
 */
public interface UserService {

    /**
     * Gets the user.
     *
     * @param user the user
     * @return the user
     */
    User getUser(User user);

    /**
     * Save user details.
     *
     * @param user the user
     * @return the user
     */
    User saveUser(User user);

}
