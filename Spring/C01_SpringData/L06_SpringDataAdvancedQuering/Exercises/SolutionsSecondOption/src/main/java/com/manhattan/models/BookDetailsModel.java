package com.manhattan.models;

import com.manhattan.entities.AgeRestriction;
import com.manhattan.entities.EditionType;

import java.math.BigDecimal;

public class BookDetailsModel {
   private String title;
   private EditionType editionType;
   private AgeRestriction ageRestriction;
   private BigDecimal price;

    public BookDetailsModel(String title, EditionType editionType, AgeRestriction ageRestriction, BigDecimal price) {
        this.title = title;
        this.editionType = editionType;
        this.ageRestriction = ageRestriction;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %.2f", title, editionType, ageRestriction, price);
    }
}
