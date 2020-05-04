package com.mindtree.springboot.shoppingcart;

import org.slf4j.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableTransactionManagement
public class ShoppingCartApplication {

    /** The Constant logger. */
    private static final Logger logger = LoggerFactory.getLogger(ShoppingCartApplication.class);

    public static void main(String[] args) {
        logger.info("Starting shopping cart spring boot app.");
        SpringApplication.run(ShoppingCartApplication.class, args);
    }

}
