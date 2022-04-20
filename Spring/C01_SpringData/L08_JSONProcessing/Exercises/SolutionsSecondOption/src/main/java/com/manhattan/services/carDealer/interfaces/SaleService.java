package com.manhattan.services.carDealer.interfaces;

import com.manhattan.models.carDealer.dtos.SalesDiscountsDto;
import com.manhattan.models.carDealer.entities.Sale;

import java.util.List;

public interface SaleService {
    void saveAll(Iterable<Sale> sales);

    List<SalesDiscountsDto> getAllSalesWithDiscount();
}
