package bg.softuni.cardealer.services.implementations;

import bg.softuni.cardealer.constants.GlobalConstant;
import bg.softuni.cardealer.models.dtos.SupplierSeedDto;
import bg.softuni.cardealer.models.entities.Supplier;
import bg.softuni.cardealer.repositories.SupplierRepository;
import bg.softuni.cardealer.services.SupplierService;
import bg.softuni.cardealer.utils.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public SupplierServiceImpl(SupplierRepository supplierRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.supplierRepository = supplierRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedSuppliers() throws IOException {
        if (this.supplierRepository.count() == 0) {
            String fileContent = Files.readString(Path.of(GlobalConstant.RESOURCES_FILE_PATH + GlobalConstant.SUPPLIERS_FILE_NAME));

            SupplierSeedDto[] supplierSeedDtos = this.gson.fromJson(fileContent, SupplierSeedDto[].class);

            Arrays
                    .stream(supplierSeedDtos)
                    .filter(this.validationUtil::isValid)
                    .map(supplierSeedDto -> this.modelMapper.map(supplierSeedDto, Supplier.class))
                    .forEach(this.supplierRepository::save);

        }
    }

    @Override
    public Supplier getRandomSupplier() {
        long randomId = ThreadLocalRandom
                .current()
                .nextLong(1, this.supplierRepository.count() + 1);

        return this.supplierRepository
                .findById(randomId)
                .orElse(null);
    }
}
