/**
 *
 */
package com.mindtree.springboot.shoppingcart.repository;

import java.util.*;

import org.springframework.data.jpa.repository.*;

import com.mindtree.springboot.shoppingcart.model.Product;

/**
 * The Interface ProductRepository.
 *
 * @author Sridevi Uppala
 */
public interface ProductRepository extends JpaRepository<Product, Integer>{

    /**
     * Find all product type.
     *
     * @return the list
     */
    @Query(value = "select distinct(p.PRODUCT_TYPE) from Product p", nativeQuery = true )
    List<String> findAllProductType();

    /**
     * Find by product id.
     *
     * @param id the id
     * @return the list
     */
    Optional<Product> findById(Integer id);

    /**
     * Find by prod name.
     *
     * @param name the name
     * @return the list
     */
    List<Product> findByName(String name);


    /**
     * Find all ordered by name descending.
     *
     * @return the list
     */
    List<Product> findAllOrderedByNameDescending();

}
