/**
 *Yorbit course 201
 */
package com.mindtree.springboot.shoppingcart.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * Entity class representing a User.
 * @author Sridevi Uppala
 *
 */
@Entity
public class User implements Comparable<User>, Serializable{

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1622338785898165707L;

    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /** The name. */
    @Column(nullable = false, unique = true)
    @NotBlank(message = "Name is mandatory")
    private String name;

    /** The password. */
    @Column(nullable = false)
    @NotBlank(message = "Password is mandatory")
    private String password;

    /**
     * Gets the id.
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int compareTo(User user) {
        System.out.println("compare called");
        if (this.name.equalsIgnoreCase(user.getName()) && this.password.equals(user.getPassword())) {
            return 0;
        }
        return 1;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
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
        User other = (User) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", password=" + password + "]";
    }


}
