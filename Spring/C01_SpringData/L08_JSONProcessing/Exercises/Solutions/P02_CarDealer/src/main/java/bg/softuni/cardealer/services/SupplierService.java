package bg.softuni.cardealer.services;

import bg.softuni.cardealer.models.entities.Supplier;

import java.io.IOException;

public interface SupplierService {
    void seedSuppliers() throws IOException;

    Supplier getRandomSupplier();
}
