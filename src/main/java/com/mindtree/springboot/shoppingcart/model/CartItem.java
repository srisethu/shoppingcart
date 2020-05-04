/**
 *
 */
package com.mindtree.springboot.shoppingcart.model;

import javax.persistence.*;

/**
 * Entity representing a Cart item.
 * @author Sridevi Uppala
 *
 */
@Entity
public class CartItem {

    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    /** The product id. */
    @OneToOne(fetch = FetchType.EAGER, optional = false)
    private Product product;

    /** The quantity. */
    private int quantity;

    /**
     * Instantiates a new cart.
     */
    public CartItem() { }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }
    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }


}
