/**
 *
 */
package com.mindtree.springboot.shoppingcart.service;

import java.util.*;

import com.mindtree.springboot.shoppingcart.model.*;

/**
 * The Interface ProductService.
 *
 * @author Sridevi Uppala
 */
public interface ProductService {

    /**
     * Fetch products.
     *
     * @return the map
     */
    Map<String, List<Product>> fetchProducts();

    /**
     * Get product types.
     *
     * @return the list of product types
     */
    List<String> getProductTypes();

    /**
     * Fetch product types by criteria.
     *
     * @param productSearch the product search
     * @return the map
     */
    Map<String, List<Product>> searchProducts(ProductSearch productSearch);

    /**
     * Find all ordered by name descending.
     *
     * @return the list
     */
    List<Product> findAllOrderedByNameDescending();

}
