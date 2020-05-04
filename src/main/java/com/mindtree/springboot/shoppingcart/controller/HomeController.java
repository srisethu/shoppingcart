/**
 *
 */
package com.mindtree.springboot.shoppingcart.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.springboot.shoppingcart.model.User;

/**
 * @author Sridevi Uppala HomeController
 */
@Controller
public class HomeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    /**
     * @param session
     * @param model
     * @return
     */
    @GetMapping(path = "/home")
    public ModelAndView home(HttpSession session, ModelMap model) {
        if (session.getAttribute("userDetail") != null) {
            model.addAttribute("userDetail", session.getAttribute("loggedInUser"));
            LOGGER.info("existing session, user already logged in. redirecting to productSearch page");
            return new ModelAndView("forward:/productSearch", model);
        }
        LOGGER.info("no session exists redirecting to Home page");
        return new ModelAndView("home");
    }

    /**
     * Gets the registration form.
     *
     * @return the registration form
     */
    @GetMapping(path = "/registerUser")
    public ModelAndView getRegistrationForm() {
        return new ModelAndView("registerUser", "userDetail", new User());
    }

}
