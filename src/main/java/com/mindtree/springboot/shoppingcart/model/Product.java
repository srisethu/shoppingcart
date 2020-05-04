/**
 *
 */
package com.mindtree.springboot.shoppingcart.model;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity class representing a Product.
 * @author Sridevi Uppala
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "PRODUCT_TYPE")
@NamedQuery(name = "Product.findAllOrderedByNameDescending",
query = "SELECT p FROM Product p ORDER BY p.name DESC")
public class Product implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 7509134462233971065L;

    /** The product id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;

    /** The product name. */
    @Column
    private String name;

    /** The price. */
    @Column
    private float price;

    /**
     * Gets the product id.
     *
     * @return the product id
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the product name.
     *
     * @return the product name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the product name.
     *
     * @param name the new product name
     */
    public void setName(String productName) {
        this.name = productName;
    }

    /**
     * Gets the price.
     *
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * Sets the price.
     *
     * @param price the new price
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * @param id the id to set
     */
    public void setId(int productId) {
        this.id = productId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + Float.floatToIntBits(price);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
    }

}
