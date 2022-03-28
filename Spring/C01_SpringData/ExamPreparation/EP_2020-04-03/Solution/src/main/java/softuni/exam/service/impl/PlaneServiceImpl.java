package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.constant.GlobalConstant;
import softuni.exam.models.dto.PlaneRootSeedDto;
import softuni.exam.models.entity.Plane;
import softuni.exam.repository.PlaneRepository;
import softuni.exam.service.PlaneService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class PlaneServiceImpl implements PlaneService {
    private final PlaneRepository planeRepository;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public PlaneServiceImpl(PlaneRepository planeRepository, XmlParser xmlParser, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.planeRepository = planeRepository;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.planeRepository.count() > 0;
    }

    @Override
    public String readPlanesFileContent() throws IOException {
        return Files.readString(Path.of(GlobalConstant.PLANES_FILE_PATH));
    }

    @Override
    public String importPlanes() throws JAXBException, FileNotFoundException {
        StringBuilder stringBuilder = new StringBuilder();

        PlaneRootSeedDto dtos = this.xmlParser.fromFile(GlobalConstant.PLANES_FILE_PATH, PlaneRootSeedDto.class);

        dtos
                .getPlanes()
                .stream()
                .filter(planeSeedDto -> {
                    boolean isValid = this.validationUtil.isValid(planeSeedDto) &&
                            !doesEntityExist(planeSeedDto.getRegisterNumber());

                    stringBuilder
                            .append(isValid ?
                                    String.format("Successfully imported Plane %s",
                                            planeSeedDto.getRegisterNumber()) :
                                    "Invalid Plane")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(planeSeedDto -> this.modelMapper.map(planeSeedDto, Plane.class))
                .forEach(this.planeRepository::save);

        return stringBuilder.toString();
    }

    @Override
    public boolean doesEntityExist(String registerNumber) {
        return this.planeRepository.existsByRegisterNumber(registerNumber);
    }

    @Override
    public Plane findByRegisterNumber(String registerNumber) {
        return this.planeRepository.findByRegisterNumber(registerNumber).orElse(null);
    }
}
