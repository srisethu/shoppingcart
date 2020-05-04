/**
 *
 */
package com.mindtree.springboot.shoppingcart.controller;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.springboot.shoppingcart.model.Product;

/**
 * The Class ProductController.
 *
 * @author Sridevi Uppala
 */
@Controller
public class ProductController  extends AbstractProductController{

    /**
     * Populate product.
     *
     * @return the map
     */
    @ModelAttribute(name = "productsMap")
    public Map<String, List<Product>> populateProducts() {
        Map<String, List<Product>> products = productService.fetchProducts();
        return products;
    }

    /**
     * Search form.
     *
     * @param session the session
     * @param model the model
     * @return the model and view
     */
    @GetMapping(path = "/productSearch")
    public ModelAndView SearchForm(HttpSession session, ModelMap model) {
        if (session.getAttribute("loggedInUser") != null) {
            return showForm();
        }
        return new ModelAndView("home");
    }

    /**
     * Show Product search form.
     *
     * @return the model and view
     */
    @PostMapping(path = "/productSearchForm")
    public ModelAndView showForm() {
        return new ModelAndView("productSearch");
    }

    /**
     * Find all ordered by name descending.
     *
     * @param model the model
     * @return the model and view
     */
    @GetMapping(path = "/showProductsOrderedByName")
    public ModelAndView findAllOrderedByNameDescending(Model model) {

        List<Product> orderedProducts = (List<Product>) productService.findAllOrderedByNameDescending();

        model.addAttribute("productsOrderedByName", orderedProducts);

        return new ModelAndView("showOrderedProducts");
    }

}
