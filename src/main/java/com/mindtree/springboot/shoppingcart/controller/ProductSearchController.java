/**
 *
 */
package com.mindtree.springboot.shoppingcart.controller;

import java.util.*;

import javax.validation.Valid;

import org.slf4j.*;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.springboot.shoppingcart.model.*;

/**
 * The Class ProductSearchController.
 *
 * @author Sridevi Uppala
 */
@Controller
public class ProductSearchController extends AbstractProductController{

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductSearchController.class);

    /**
     * Product search.
     *
     * @param productSearch the product search
     * @param result the result
     * @param model the model
     * @return the model and view
     */
    @RequestMapping(value = "/productSearch", method = RequestMethod.POST)
    public ModelAndView productSearch(@Valid @ModelAttribute("productSearch") ProductSearch productSearch,
            BindingResult result, ModelMap model) {
        Map<String, List<Product>> products = productService.searchProducts(productSearch);
        model.addAttribute("productsMap", products);
        return new ModelAndView("productSearch");
    }

    /**
     * Handle constraint violation exception.
     *
     * @param ex the exception
     * @return the error view
     */
    @ExceptionHandler(DataAccessException.class)
    public ModelAndView handleConstraintViolationException(DataAccessException ex) {
        LOGGER.error("Error while searching product" + ex.getMessage());
        ModelAndView searchResultsErrorView = new ModelAndView();
        searchResultsErrorView.setViewName("productSearch");
        searchResultsErrorView.addObject("exception", "Error while searching product");
        return searchResultsErrorView;
    }

}
