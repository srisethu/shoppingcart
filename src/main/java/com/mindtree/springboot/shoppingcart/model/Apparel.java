/**
 *
 */
package com.mindtree.springboot.shoppingcart.model;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity class representing a Apparel.
 *
 * @author Sridevi Uppala
 *
 */
@Entity
@DiscriminatorValue(value = "APPAREL")
public class Apparel extends Product implements Comparable<Apparel>, Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1109478771838118271L;

    /** The type. */
    @Column
    private String type;

    /** The brand. */
    @Column
    private String brand;

    /** The design. */
    @Column
    private String design;

    /**
     * Gets the type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type.
     *
     * @param type the new type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the brand.
     *
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Sets the brand.
     *
     * @param brand the new brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Gets the design.
     *
     * @return the design
     */
    public String getDesign() {
        return design;
    }

    /**
     * Sets the design.
     *
     * @param design the new design
     */
    public void setDesign(String design) {
        this.design = design;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((brand == null) ? 0 : brand.hashCode());
        result = prime * result + ((design == null) ? 0 : design.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
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
        Apparel other = (Apparel) obj;
        if (brand == null) {
            if (other.brand != null)
                return false;
        } else if (!brand.equals(other.brand))
            return false;
        if (design == null) {
            if (other.design != null)
                return false;
        } else if (!design.equals(other.design))
            return false;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Apparel [type=" + type + ", brand=" + brand + ", design=" + design + "]";
    }

    @Override
    public int compareTo(Apparel apparel) {
        if (this.type.equalsIgnoreCase(apparel.getType()) && this.brand.equalsIgnoreCase(apparel.getBrand())
                && this.design.equalsIgnoreCase(apparel.getDesign()) && this.getName().equalsIgnoreCase(apparel.getName())) {
            return 0;
        }
        return 1;
    }

}
