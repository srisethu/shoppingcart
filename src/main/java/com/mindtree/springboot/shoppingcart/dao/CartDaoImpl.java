/**
 *
 */
package com.mindtree.springboot.shoppingcart.dao;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.UnexpectedRollbackException;

import com.mindtree.springboot.shoppingcart.exception.*;
import com.mindtree.springboot.shoppingcart.model.*;
import com.mindtree.springboot.shoppingcart.repository.*;

/**
 * The Class CartDaoImpl.
 *
 * @author Sridevi Uppala
 */
@Repository
public class CartDaoImpl implements CartDao {

    /** The cart repo. */
    @Resource
    CartRepository cartRepo;

    /** The cart item repo. */
    @Resource
    CartItemRepository cartItemRepo;

    /**
     * Creates the user cart.
     *
     * @param userCart the user cart
     * @return the cart
     * @throws ShoppingCartBusinessException
     * @throws ShoppingCartException
     */
    @Override
    public Cart createCart(Cart userCart) throws ShoppingCartBusinessException, ShoppingCartException {
        try {
            return cartRepo.save(userCart);
        } catch (UnexpectedRollbackException ex) {
            if (ex.getMostSpecificCause() instanceof SQLIntegrityConstraintViolationException) {
                throw new ShoppingCartBusinessException("constraint violation exception");
            }
        } catch (Exception ex) {
            throw new ShoppingCartException("unknown error");
        }
        return null;
    }

    /**
     * Gets the cart by user.
     *
     * @param user the user
     * @return the cart by user
     */
    @Override
    public Cart getCartByUser(User user) {
        return cartRepo.findByUser(user);
    }

    /**
     * Gets the cart by id.
     *
     * @param userCart the user cart
     * @return the cart by id
     */
    @Override
    public Optional<Cart> getCartById(Cart userCart) {
        return cartRepo.findById(userCart.getId());
    }

    /**
     * Adds the cart item.
     *
     * @param item the item
     * @return the cart item
     */
    @Override
    public CartItem addCartItem(CartItem item) {
        return cartItemRepo.save(item);
    }

}
