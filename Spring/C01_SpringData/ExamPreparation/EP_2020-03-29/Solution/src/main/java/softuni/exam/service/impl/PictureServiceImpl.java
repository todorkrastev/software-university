package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.constant.GlobalConstant;
import softuni.exam.models.dto.PictureSeedDto;
import softuni.exam.models.entity.Car;
import softuni.exam.models.entity.Picture;
import softuni.exam.repository.PictureRepository;
import softuni.exam.service.CarService;
import softuni.exam.service.PictureService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class PictureServiceImpl implements PictureService {
    private final PictureRepository pictureRepository;
    private final CarService carService;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public PictureServiceImpl(PictureRepository pictureRepository, CarService carService, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.pictureRepository = pictureRepository;
        this.carService = carService;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.pictureRepository.count() > 0;
    }

    @Override
    public String readPicturesFromFile() throws IOException {
        return Files
                .readString(Path.of(GlobalConstant.PICTURES_FILE_PATH));
    }

    @Override
    public String importPictures() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        PictureSeedDto[] picturesSeedDtos = this.gson.fromJson(readPicturesFromFile(), PictureSeedDto[].class);

        Arrays
                .stream(picturesSeedDtos)
                .filter(picturesSeedDto -> {
                    boolean isValid = this.validationUtil.isValid(picturesSeedDto);

                    stringBuilder.append(isValid
                                    ? String.format("Successfully import picture - %s", picturesSeedDto.getName())
                                    : "Invalid picture")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(picturesSeedDto -> {
                    Picture picture = this.modelMapper.map(picturesSeedDto, Picture.class);

                    Car car = this.carService.findById(picturesSeedDto.getCar());

                    picture.setCar(car);

                    return picture;
                })
                .forEach(this.pictureRepository::save);

        return stringBuilder.toString();
    }
}
