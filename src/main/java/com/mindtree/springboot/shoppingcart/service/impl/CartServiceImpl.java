/**
 *
 */
package com.mindtree.springboot.shoppingcart.service.impl;

import java.util.*;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.springboot.shoppingcart.dao.*;
import com.mindtree.springboot.shoppingcart.exception.*;
import com.mindtree.springboot.shoppingcart.model.*;
import com.mindtree.springboot.shoppingcart.service.CartService;

/**
 * The Class CartServiceImpl.
 *
 * @author Sridevi Uppala
 */
@Service
@Transactional(rollbackFor = DataAccessException.class)
public class CartServiceImpl implements CartService {

    private static final String PRODUCT_TYPE_APPAREL = "APPAREL";

    private static final String PRODUCT_TYPE_BOOK = "BOOK";

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(CartServiceImpl.class);

    /** The cart dao. */
    @Autowired
    private CartDao cartDao;

    /** The product dao. */
    @Autowired
    private ProductDao productDao;

    /**
     * Creates the user cart.
     *
     * @param user the user
     * @return the cart
     * @throws ShoppingCartException
     * @throws ShoppingCartBusinessException
     */
    @Override
    public Cart createUserCart(User user) throws ShoppingCartBusinessException, ShoppingCartException {
        Cart userCart = cartDao.getCartByUser(user);
        if (userCart == null) {
            LOGGER.info("Creating new cart for the user");
            userCart = new Cart();
            userCart.setUser(user);
            return cartDao.createCart(userCart);
        }
        return userCart;
    }

    /**
     * Adds the to cart details.
     *
     * @param cartItem the cart item
     * @param userCart the user cart
     * @throws ShoppingCartBusinessException the shopping cart business exception
     * @throws ShoppingCartException the shopping cart exception
     */
    @Override
    public void addToCartDetails(CartItem cartItem, Cart userCart) throws ShoppingCartBusinessException, ShoppingCartException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Get product details for id {}", cartItem.getProduct().getId());
        }
        Product product = productDao.fetchProductById(cartItem.getProduct().getId()).get();
        userCart = cartDao.getCartById(userCart).get();
        if (userCart.getCartItems() == null) {
            LOGGER.info("adding item to cart");
            Set<CartItem> cartItems = new HashSet<CartItem>();
            userCart.setCartItems(cartItems);
            addNewProductToCart(cartItem, product, cartItems);
            cartDao.createCart(userCart);
        } else {
            LOGGER.info("updating product quantity");
            Integer quantity = cartItem.getQuantity();
            boolean productExists = false;
            for (CartItem item : userCart.getCartItems()) {
                if (item.getProduct().getId() == cartItem.getProduct().getId()) {
                    item.setQuantity(item.getQuantity() + quantity);
                    cartDao.addCartItem(item);
                    productExists = true;
                    break;
                }
            }
            if (!productExists) {
                addNewProductToCart(cartItem, product, userCart.getCartItems());
                cartDao.createCart(userCart);
            }
        }
    }

    /**
     * Adds the new product to cart.
     *
     * @param cartItem the cart item
     * @param product the product
     * @param cartItems the cart items
     */
    private void addNewProductToCart(CartItem cartItem, Product product, Set<CartItem> cartItems) {
        CartItem item = new CartItem();
        item.setProduct(product);
        item.setQuantity(cartItem.getQuantity());
        item = cartDao.addCartItem(item);
        cartItems.add(item);
    }

    /**
     * Fetch cart items.
     *
     * @param loggedInUser the logged in user
     * @return the map
     */
    @Override
    public Map<String, List<CartItem>> fetchCartItems(User loggedInUser) {
        Map<String, List<CartItem>> cartItemsMap = new HashMap<String, List<CartItem>>();
        Cart userCart = cartDao.getCartByUser(loggedInUser);
        if (userCart != null) {
            Set<CartItem> cartItems = userCart.getCartItems();
            for (CartItem cartItem : cartItems) {
                String productType = null;
                if (cartItem.getProduct() instanceof Book) {
                    productType = PRODUCT_TYPE_BOOK;
                } else if (cartItem.getProduct() instanceof Apparel) {
                    productType = PRODUCT_TYPE_APPAREL;
                }
                if (productType != null) {
                    List<CartItem> CartItemList = null;
                    if (cartItemsMap.get(productType) != null) {
                        CartItemList = cartItemsMap.get(productType);
                    } else {
                        CartItemList = new ArrayList<CartItem>();
                        cartItemsMap.put(productType, CartItemList);
                    }
                    CartItemList.add(cartItem);
                }
            }
        }
        return cartItemsMap;
    }

    /**
     * Update cart details.
     *
     * @param cartItem the cart item
     * @param userCart the user cart
     * @throws ShoppingCartBusinessException the shopping cart business exception
     * @throws ShoppingCartException the shopping cart exception
     */
    @Override
    public void updateCartDetails(CartItem cartItem, Cart userCart) throws ShoppingCartBusinessException, ShoppingCartException {
        userCart = cartDao.getCartById(userCart).get();
        if (cartItem.getQuantity() == 0) {
            LOGGER.info("removing product from cart");
            for (CartItem item : userCart.getCartItems()) {
                if (item.getProduct().getId() == cartItem.getProduct().getId()) {
                    userCart.getCartItems().remove(item);
                    break;
                }
            }
            cartDao.createCart(userCart);
        } else {
            for (CartItem item : userCart.getCartItems()) {
                if (item.getProduct().getId() == cartItem.getProduct().getId()) {
                    item.setQuantity(cartItem.getQuantity());
                    cartDao.addCartItem(item);
                    break;
                }
            }
        }
    }

}
