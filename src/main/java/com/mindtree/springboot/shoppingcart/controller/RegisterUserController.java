package com.mindtree.springboot.shoppingcart.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.springboot.shoppingcart.model.User;
import com.mindtree.springboot.shoppingcart.service.UserService;
import com.mindtree.springboot.shoppingcart.validator.UserDetailsValidator;

/**
 * The Class RegisterUserController.
 *
 * @author Sridevi Uppala
 */
@Controller
public class RegisterUserController {

    /** The Constant LOGGER to give access to logging. */
    private static final Logger LOGGER = LoggerFactory.getLogger(RegisterUserController.class);

    /** The validator. */
    @Autowired
    private UserDetailsValidator validator;

    /** The user service. */
    @Autowired
    private UserService userService;

    /**
     * Adds the user.
     *
     * @param user    the user
     * @param result  the result
     * @param model   the model
     * @param session the session
     * @return the model and view
     */
    @PostMapping(value = "/saveUser")
    public ModelAndView addUser(@Valid @ModelAttribute("userDetail") User user, BindingResult result, ModelMap model,
            HttpSession session) {
        validator.validate(user, result);
        String returnView = "registerUser";
        if (result.hasErrors()) {
            LOGGER.error("validation error has occured");
            return new ModelAndView(returnView);
        }
        try {
            userService.saveUser(user);
        } catch (RuntimeException e) {
            result.rejectValue("name", "", "Invalid Username or Username already exists");
            LOGGER.debug("Invalid Username or Username already exists " + e.getStackTrace());
            return new ModelAndView(returnView);
        }
        LOGGER.info("user created successfully");
        return new ModelAndView("redirect:/login", model);
    }

}
