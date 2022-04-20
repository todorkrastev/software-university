package com.manhattan.services.carDealer.implementations;

import com.manhattan.models.carDealer.dtos.SalesDiscountsDto;
import com.manhattan.models.carDealer.entities.Sale;
import com.manhattan.repositories.carDealer.SaleRepository;
import com.manhattan.services.carDealer.interfaces.SaleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {
    private final SaleRepository repository;

    public SaleServiceImpl(SaleRepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveAll(Iterable<Sale> sales) {
        this.repository.saveAllAndFlush(sales);
    }

    @Override
    public List<SalesDiscountsDto> getAllSalesWithDiscount() {
        return this.repository.findAllWithDiscounts();
    }
}
