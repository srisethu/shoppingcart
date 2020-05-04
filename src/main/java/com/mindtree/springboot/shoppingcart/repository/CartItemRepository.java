/**
 *
 */
package com.mindtree.springboot.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.springboot.shoppingcart.model.CartItem;

/**
 * The Interface ProductRespository.
 *
 * @author Sridevi Uppala
 */
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {

}
