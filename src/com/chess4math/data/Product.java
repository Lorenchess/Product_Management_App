package com.chess4math.data;

import java.math.BigDecimal;

import static com.chess4math.data.Rating.*;
import static java.math.RoundingMode.HALF_UP;
import java.time.LocalDate;
import java.util.Objects;


/**
 *
 * @author lorenchess
 */
public abstract class Product {

    private int id;
    private String name;
    private BigDecimal price;
    public static final BigDecimal DISCOUNT_RATE = BigDecimal.valueOf(0.1);
    private Rating rating;

    Product(int id, String name, BigDecimal price, Rating rating) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    Product(int id, String name, BigDecimal price) {
        this(id, name, price, NOT_RATED);
    }

    public Rating getRating() {
        return rating;
    }

    public BigDecimal getDiscount() {
        return price.multiply(DISCOUNT_RATE).setScale(2, HALF_UP);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public abstract Product applyRating(Rating newRating);
//    {
//        return new Product(id, name, price, newRating);
//    }

    /**
     * Get the value of the best before date for the product
     * @return the value of bestBefore
     */

    public LocalDate getBestBefore() {
        return LocalDate.now();
    }

    @Override
    public String toString() {
        return id + ", " + name + ", " + price + ", "
                + getDiscount() + ", " + rating.getStars()+" "+getBestBefore();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }
        if (obj instanceof Product) {
            final Product other = (Product) obj;
            return this.id == other.id && Objects.equals(this.name, other.name);
        }
        return false;
    }


}

