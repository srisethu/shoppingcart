package com.mindtree.springboot.shoppingcart.controller;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.springboot.shoppingcart.exception.*;
import com.mindtree.springboot.shoppingcart.model.*;
import com.mindtree.springboot.shoppingcart.service.CartService;

/**
 * The Class CartController.
 *
 * @author Sridevi Uppala
 */
@RestController
public class CartController {

    /** LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(CartController.class);

    /** The cart service. */
    @Autowired
    CartService cartService;

    /**
     * Add to cart.
     *
     * @param cartItem the cart detail
     * @param session  the session
     * @return the string
     */
    @PostMapping(path = "/addtoCart")
    public String addToCart(@RequestBody CartItem cartItem, HttpSession session) {
        Cart userCart = null;
        try {
            if (session.getAttribute("cartDetail") != null) {
                userCart = (Cart) session.getAttribute("cartDetail");
            } else {
                User user = (User) session.getAttribute("loggedInUser");
                userCart = cartService.createUserCart(user);
                session.setAttribute("cartDetail", userCart);
            }
            cartService.addToCartDetails(cartItem, userCart);
        } catch (ShoppingCartBusinessException | ShoppingCartException e) {
            LOGGER.error(e.getMessage());
            return "{\"status\":\"error\"}";
        }
        return "{\"status\":\"success\"}";
    }

    /**
     * Update cart.
     *
     * @param cartDetail the cart detail
     * @param session    the session
     * @return success
     */
    @PostMapping(path = "/updateCart")
    public String updateCart(@RequestBody CartItem cartDetail, HttpSession session) {
        Cart cart = null;
        try {
            if (session.getAttribute("cartDetail") != null) {
                cart = (Cart) session.getAttribute("cartDetail");
            } else {
                User user = (User) session.getAttribute("loggedInUser");

                cart = cartService.createUserCart(user);
                session.setAttribute("cartDetail", cart);
            }
            cartService.updateCartDetails(cartDetail, cart);
        } catch (ShoppingCartBusinessException | ShoppingCartException e) {
            LOGGER.error(e.getMessage());
            return "{\"status\":\"error\"}";
        }
        return "{\"status\":\"success\"}";
    }

    /**
     * Handle data access exception.
     *
     * @param ex the ex
     * @return error
     */
    @ExceptionHandler(DataAccessException.class)
    public String handleDataAccessException(DataAccessException ex) {
        LOGGER.error("Error while add/updating cart" + ex.getMessage());
        return "{\"status\":\"error\"}";
    }

    @GetMapping(path = "/viewCartDetails")
    public ModelAndView viewCartDetails(HttpSession session, ModelMap model) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Get Cart details.");
        }
        if (session.getAttribute("loggedInUser") != null) {
            User loggedInUser = (User) session.getAttribute("loggedInUser");
            Map<String, List<CartItem>> cartItems = cartService.fetchCartItems(loggedInUser);
            model.addAttribute("cartItemsMapList", cartItems);
            return new ModelAndView("cartDetails");
        } else {
            LOGGER.info("New user hence re-directing to home screen");
            return new ModelAndView("home");
        }
    }
}
