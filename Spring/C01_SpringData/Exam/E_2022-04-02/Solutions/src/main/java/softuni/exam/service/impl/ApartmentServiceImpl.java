package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.constant.GlobalConstant;
import softuni.exam.models.dto.ApartmentRootSeedDto;
import softuni.exam.models.dto.ApartmentSeedDto;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.service.ApartmentService;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class ApartmentServiceImpl implements ApartmentService {
    private final ApartmentRepository apartmentRepository;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final TownService townService;
    private final ModelMapper modelMapper;

    public ApartmentServiceImpl(ApartmentRepository apartmentRepository, XmlParser xmlParser, ValidationUtil validationUtil, TownService townService, ModelMapper modelMapper) {
        this.apartmentRepository = apartmentRepository;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.townService = townService;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.apartmentRepository.count() > 0;
    }

    @Override
    public String readApartmentsFromFile() throws IOException {
        return Files.readString(Path.of(GlobalConstant.APARTMENTS_FILE_PATH));
    }

    @Override
    public String importApartments() throws IOException, JAXBException {
        StringBuilder output = new StringBuilder();

        ApartmentRootSeedDto fromFile = this.xmlParser.fromFile(GlobalConstant.APARTMENTS_FILE_PATH, ApartmentRootSeedDto.class);

        fromFile
                .getApartments()
                .stream()
                .filter(apartmentSeedDto -> {
                    boolean isValid = this.validationUtil.isValid(apartmentSeedDto) &&
                            !doesTownNameAndAreaExist(apartmentSeedDto) &&
                            this.townService.doesEntityExist(apartmentSeedDto.getTown());

                    output
                            .append(isValid ?
                                    String.format("Successfully imported apartment %s - %.2f",
                                            apartmentSeedDto.getApartmentType().name(),
                                            apartmentSeedDto.getArea()) :
                                    "Invalid apartment")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(apartmentSeedDto -> {
                    Apartment apartment = this.modelMapper.map(apartmentSeedDto, Apartment.class);

                    String townName = apartmentSeedDto.getTown();
                    Town town = this.townService.findByName(townName);
                    apartment.setTown(town);

                    return apartment;
                })
                .forEach(this.apartmentRepository::save);

        return output.toString();
    }

    @Override
    public boolean existsById(Long id) {
        return this.apartmentRepository.existsById(id);
    }

    @Override
    public Apartment findById(Long id) {
        return this.apartmentRepository.findById(id).orElse(null);
    }

    private boolean doesTownNameAndAreaExist(ApartmentSeedDto apartmentSeedDto) {
        return this.apartmentRepository.existsByTownTownNameAndArea(apartmentSeedDto.getTown(), apartmentSeedDto.getArea());
    }
}
