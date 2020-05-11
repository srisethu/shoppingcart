/**
 *
 */
package com.mindtree.springboot.shoppingcart.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Sridevi Uppala
 *
 */
public class HomeControllerTest {

    private static HomeController controller;

    @BeforeAll
    public static void setUp() {
        controller = new HomeController();
    }

    @Test
    public void testGetRegistrationForm() {
        ModelAndView actual = controller.getRegistrationForm();

        assertNotNull(actual);
        //fail();
    }

}
