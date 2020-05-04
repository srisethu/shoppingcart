/**
 *
 */
package com.mindtree.springboot.shoppingcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.mindtree.springboot.shoppingcart.service.ProductService;

/**
 * @author Sridevi Uppala
 *
 */
public abstract class AbstractProductController {

    /** The product service. */
    @Autowired
    protected ProductService productService;


    /**
     * Populate product types.
     *
     * @return the list
     */
    @ModelAttribute(name = "productTypes")
    public List<String> populateProductTypes() {
        List<String> productTypes = productService.getProductTypes();
        return productTypes;
    }



}
