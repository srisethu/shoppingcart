/**
 *
 */
package com.mindtree.springboot.shoppingcart.model;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity class representing a Book.
 *
 * @author Sridevi Uppala
 *
 */
@Entity
@DiscriminatorValue(value = "BOOK")
public class Book extends Product implements Comparable<Book>, Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6029517187385224804L;

    /** The genre. */
    @Column
    private String genre;

    /** The author. */
    @Column
    private String author;

    /** The publications. */
    @Column
    private String publications;

    /**
     * Gets the genre.
     *
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Sets the genre.
     *
     * @param genre the new genre
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Gets the author.
     *
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the author.
     *
     * @param author the new author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Gets the publications.
     *
     * @return the publications
     */
    public String getPublications() {
        return publications;
    }

    /**
     * Sets the publications.
     *
     * @param publications the new publications
     */
    public void setPublications(String publications) {
        this.publications = publications;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((author == null) ? 0 : author.hashCode());
        result = prime * result + ((genre == null) ? 0 : genre.hashCode());
        result = prime * result + ((publications == null) ? 0 : publications.hashCode());
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
        Book other = (Book) obj;
        if (author == null) {
            if (other.author != null)
                return false;
        } else if (!author.equals(other.author))
            return false;
        if (genre == null) {
            if (other.genre != null)
                return false;
        } else if (!genre.equals(other.genre))
            return false;
        if (publications == null) {
            if (other.publications != null)
                return false;
        } else if (!publications.equals(other.publications))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Book [genre=" + genre + ", author=" + author + ", publications=" + publications + "]";
    }

    @Override
    public int compareTo(Book book) {
        if (this.author.equalsIgnoreCase(book.getAuthor()) && this.publications.equalsIgnoreCase(book.getPublications())
                && this.genre.equalsIgnoreCase(book.getGenre()) && this.getName().equalsIgnoreCase(book.getName())) {
            return 0;
        }
        return 1;
    }

}
