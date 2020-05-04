/**
 *
 */
package com.mindtree.springboot.shoppingcart.model;

import java.util.Set;

import javax.persistence.*;

/**
 * Entity representing a Cart.
 * @author Sridevi Uppala
 *
 */
@Entity
public class Cart {

    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /** The product id. */
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<CartItem> cartItems;


    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private User user;

    /**
     * Instantiates a new cart.
     */
    public Cart() { }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the cartItems
     */
    public Set<CartItem> getCartItems() {
        return cartItems;
    }

    /**
     * @param cartItems the cartItems to set
     */
    public void setCartItems(Set<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }


}
