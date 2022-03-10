package com.example.advquerying.services;

import com.example.advquerying.entities.Size;

import java.math.BigDecimal;


public interface ShampooService {
    void findAllShampoosByGivenSizeOrderedByShampooId(Size size);

    void findAllShampoosByGivenSizeOrLabel(Size size, int id);

    void findAllShampoosWhichPriceIsHigherThanGivenOne(BigDecimal price);
}
