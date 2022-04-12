package com.manhattan.models;

import com.manhattan.entities.EditionType;

import java.math.BigDecimal;

public class BookTitleEditionTypeAndPriceModel {
    private String title;
    private EditionType editionType;
    private BigDecimal price;

    public BookTitleEditionTypeAndPriceModel(String title, EditionType editionType, BigDecimal price) {
        this.title = title;
        this.editionType = editionType;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", title, editionType, price);
    }
}
