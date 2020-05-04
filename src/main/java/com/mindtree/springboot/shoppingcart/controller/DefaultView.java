/**
 *
 */
package com.mindtree.springboot.shoppingcart.controller;

import org.springframework.context.annotation.*;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.*;

/**
 * The Class DefaultView.
 *
 * @author Sridevi Uppala
 */
@SuppressWarnings("deprecation")
@Configuration
public class DefaultView extends WebMvcConfigurerAdapter{

    /**
     * Adds the view controllers.
     *
     * @param registry the registry
     */
    @Override
    public void addViewControllers( ViewControllerRegistry registry ) {
        registry.addViewController( "/" ).setViewName( "forward:/home" );
        registry.setOrder( Ordered.HIGHEST_PRECEDENCE );
        super.addViewControllers( registry );
    }
}
