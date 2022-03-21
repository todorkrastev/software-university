package bg.softuni.cardealer.services.implementations;

import bg.softuni.cardealer.constants.GlobalConstant;
import bg.softuni.cardealer.models.dtos.PartSeedDto;
import bg.softuni.cardealer.models.entities.Part;
import bg.softuni.cardealer.models.entities.Supplier;
import bg.softuni.cardealer.repositories.PartRepository;
import bg.softuni.cardealer.services.PartService;
import bg.softuni.cardealer.services.SupplierService;
import bg.softuni.cardealer.utils.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class PartServiceImpl implements PartService {
    private final PartRepository partRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final SupplierService supplierService;

    public PartServiceImpl(PartRepository partRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil, SupplierService supplierService) {
        this.partRepository = partRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.supplierService = supplierService;
    }


    @Override
    public void seedParts() throws IOException {
        if (this.partRepository.count() == 0) {
            String fileContent = Files.readString(Path.of(GlobalConstant.RESOURCES_FILE_PATH + GlobalConstant.PARTS_FILE_NAME));

            PartSeedDto[] partSeedDtos = this.gson.fromJson(fileContent, PartSeedDto[].class);

            Arrays.stream(partSeedDtos)
                    .filter(this.validationUtil::isValid)
                    .map(partSeedDto -> {
                        Part part = this.modelMapper.map(partSeedDto, Part.class);
                        Supplier randomSupplier = this.supplierService.getRandomSupplier();

                        part.setSupplier(randomSupplier);

                        return part;
                    })
                    .forEach(this.partRepository::save);
        }
    }

    @Override
    public Set<Part> getRandomParts() {
        Set<Part> parts = new HashSet<>();

        int partsCounter = ThreadLocalRandom
                .current()
                .nextInt(3, 6);

        for (int i = 0; i < partsCounter; i++) {
            long randomId = ThreadLocalRandom
                    .current()
                    .nextLong(1L, this.partRepository.count() + 1);

            parts
                    .add(this.partRepository
                            .findById(randomId)
                            .orElse(null));
        }

        return parts;
    }
}
