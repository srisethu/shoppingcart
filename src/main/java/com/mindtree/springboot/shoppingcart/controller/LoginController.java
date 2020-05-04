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

/**
 * The Class LoginController.
 *
 * @author Sridevi Uppala
 */
@Controller
public class LoginController {

    /** LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    /** The user manager service. */
    @Autowired
    private UserService userManagerService;

    /**
     * Show form.
     *
     * @return the model and view
     */
    @GetMapping(path = "/login")
    public ModelAndView showForm() {
        return new ModelAndView("login", "userDetail", new User());
    }

    /**
     * Submit.
     *
     * @param user the user
     * @param result the result
     * @param model the model
     * @param session the session
     * @return the model and view
     */
    @PostMapping(path = "/loginUser")
    public ModelAndView submit(@Valid @ModelAttribute("userDetail") User user, BindingResult result, ModelMap model,
            HttpSession session) {
        User loggedInUser = userManagerService.getUser(user);
        if (loggedInUser == null || !user.equals(loggedInUser)) {
            result.rejectValue("", "", "Invalid UserName or Password");
            return new ModelAndView("login");
        }
        LOGGER.info("User Logged in success");
        model.addAttribute("loggedInUser", loggedInUser);
        session.setAttribute("loggedInUser", loggedInUser);
        return new ModelAndView("forward:/productSearchForm", model);
    }

}
