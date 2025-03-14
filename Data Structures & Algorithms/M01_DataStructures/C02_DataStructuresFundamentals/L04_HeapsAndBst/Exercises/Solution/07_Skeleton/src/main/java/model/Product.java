package model;

import interfaces.Decrease;

import java.util.Objects;

public class Product implements Decrease<Product>, Comparable<Product> {
    private int price;
    public Product(int price) {
        this.price = price;
    }

    @Override
    public void decrease() {
        this.price--;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price;
    }

    @Override
    public int hashCode() {
        // Final like we are going to assign that again somewhere
        // no, no it is safety - no nerd intentions were to take place here,
        // whatsoever. And yea this comment is so long just so you can read it :)
        final int prime = 73;
        return Objects.hash(price) * prime;
    }

    @Override
    public int compareTo(Product other) {
        return this.getPrice() - other.getPrice();
    }
}
