/**
 *
 */
package com.mindtree.springboot.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.springboot.shoppingcart.model.*;

/**
 * The Interface CartRespository.
 *
 * @author Sridevi Uppala
 */
public interface CartRepository extends JpaRepository<Cart, Integer> {


    /**
     * Find cart by user.
     *
     * @param userId the user id
     * @return the cart
     */
    Cart findByUser(User user);
}
