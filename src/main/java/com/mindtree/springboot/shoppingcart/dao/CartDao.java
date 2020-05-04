/**
 *
 */
package com.mindtree.springboot.shoppingcart.dao;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.mindtree.springboot.shoppingcart.exception.*;
import com.mindtree.springboot.shoppingcart.model.*;

/**
 * The Interface CartDao.
 *
 * @author Sridevi Uppala
 */
@Repository
public interface CartDao {

    /**
     * Creates the user cart.
     *
     * @param userCart the user cart
     * @return the cart
     * @throws ShoppingCartBusinessException
     * @throws ShoppingCartException
     */
    Cart createCart(Cart userCart) throws ShoppingCartBusinessException, ShoppingCartException;

    /**
     * Gets the cart by user.
     *
     * @param user the user
     * @return the cart by user
     */
    Cart getCartByUser(User user);

    /**
     * Gets the cart by id.
     *
     * @param userCart the user cart
     * @return the cart by id
     */
    Optional<Cart> getCartById(Cart userCart);

    /**
     * Adds the cart item.
     *
     * @param item the item
     * @return the cart item
     */
    CartItem addCartItem(CartItem item);

}
