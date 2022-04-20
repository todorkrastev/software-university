package com.manhattan.services.carDealer.interfaces;

import com.manhattan.models.carDealer.dtos.LocalSupplierDto;
import com.manhattan.models.carDealer.entities.Supplier;

import java.util.List;

public interface SupplierService {
    void saveAll(Iterable<Supplier> suppliers);
    boolean hasNoRecords();
    Supplier getRandomSupplier();
    List<LocalSupplierDto> gatAllLocalSuppliers();
}
