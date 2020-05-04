/**
 *
 */
package com.mindtree.springboot.shoppingcart.dao;

import java.util.*;

import org.springframework.stereotype.Repository;

import com.mindtree.springboot.shoppingcart.model.Product;

/**
 * @author Sridevi Uppala
 *
 */
@Repository
public interface ProductDao {

    /**
     * @return
     */
    List<Product> fetchAllProduct();

    /**
     * @return
     */
    List<String> fetchAllProductType();

    /**
     * @param productId
     * @return
     */
    Optional<Product> fetchProductById(Integer productId);

    /**
     * @param productName
     * @return
     */
    List<Product> fetchProductByName(String productName);

    /**
     * Find all ordered by name descending.
     *
     * @return the list
     */
    List<Product> findAllOrderedByNameDescending();

}
