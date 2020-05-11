/**
 *
 */
package com.mindtree.springboot.shoppingcart.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Sridevi Uppala
 *
 */
public class HomeControllerTest {

    private HomeController controller;

    @BeforeAll
    public void setUp() {
        controller = new HomeController();
    }

    @Test
    public void testGetRegistrationForm() {
        ModelAndView actual = controller.getRegistrationForm();

        assertNotNull(actual);
    }

}
