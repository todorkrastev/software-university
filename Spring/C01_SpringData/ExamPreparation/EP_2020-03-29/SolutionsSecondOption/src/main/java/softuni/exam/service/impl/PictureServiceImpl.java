package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.PictureSeedDto;
import softuni.exam.models.entities.Picture;
import softuni.exam.repository.PictureRepository;
import softuni.exam.service.CarService;
import softuni.exam.service.FileService;
import softuni.exam.service.PictureService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PictureServiceImpl implements PictureService {
    public static final String PICTURES_FILE_PATH = "src/main/resources/files/json/pictures.json";
    private final PictureRepository pictureRepository;
    private final CarService carService;
    private final FileService fileService;
    private final ValidationUtil validator;
    private final ModelMapper mapper;

    public PictureServiceImpl(PictureRepository repository, CarService carService, FileService fileService, ValidationUtil validator, ModelMapper mapper) {
        this.pictureRepository = repository;
        this.carService = carService;
        this.fileService = fileService;
        this.validator = validator;
        this.mapper = mapper;
    }

    @Override
    public boolean areImported() {
        return this.pictureRepository.count() > 0;
    }

    @Override
    public String readPicturesFromFile() throws IOException {
        StringBuilder response = new StringBuilder();
        this.pictureRepository.saveAll(Arrays.stream(fileService.readJsonFile(PICTURES_FILE_PATH, PictureSeedDto[].class))
                .map(picture -> appendResponseMessage(response, picture))
                .filter(this.validator::isValid)
                .map(p -> {
                    Picture picture = this.mapper.map(p, Picture.class);
                    picture.setCar(carService.getCar(p.getCar()).orElse(null));
                    return picture;
                })
                .collect(Collectors.toList()));
        return response.toString().trim();
    }

    private PictureSeedDto appendResponseMessage(StringBuilder response, PictureSeedDto picture) {
        String message;
        if (this.validator.isValid(picture)) {
            message = String.format("Successfully import picture - %s", picture.getName());
        } else {
            message = "Invalid picture";
        }
        response.append(message).append(System.lineSeparator());
        return picture;
    }

    @Override
    public String importPictures() throws IOException {
        return this.fileService.readString(PICTURES_FILE_PATH);
    }
}
