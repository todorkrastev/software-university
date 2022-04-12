package com.manhattan.models;

import java.math.BigDecimal;

public class BookTitleAndPriceModel {
    private String title;
    private BigDecimal price;

    public BookTitleAndPriceModel(String title, BigDecimal price) {
        this.title = title;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s - $%.2f", title, price);
    }
}
