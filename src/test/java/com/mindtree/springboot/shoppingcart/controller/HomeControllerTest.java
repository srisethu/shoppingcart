/**
 *
 */
package com.mindtree.springboot.shoppingcart.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Sridevi Uppala
 *
 */
public class HomeControllerTest {

    private HomeController controller;

    @Before
    public void setUp() {
        controller = new HomeController();
    }

    @Test
    public void testGetRegistrationForm() {
        ModelAndView actual = controller.getRegistrationForm();

        assertNotNull(actual);
    }

}
