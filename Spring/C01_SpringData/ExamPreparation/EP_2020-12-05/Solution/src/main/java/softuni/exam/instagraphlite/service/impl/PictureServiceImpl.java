package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.constant.GlobalConstant;
import softuni.exam.instagraphlite.models.dto.PictureSeedDto;
import softuni.exam.instagraphlite.models.entity.Picture;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class PictureServiceImpl implements PictureService {
    private final PictureRepository pictureRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public PictureServiceImpl(PictureRepository pictureRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.pictureRepository = pictureRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }


    @Override
    public boolean areImported() {
        return this.pictureRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(GlobalConstant.PICTURES_FILE_PATH));
    }

    @Override
    public String importPictures() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        PictureSeedDto[] picturesSeedDtos = this.gson.fromJson(readFromFileContent(), PictureSeedDto[].class);

        Arrays
                .stream(picturesSeedDtos)
                .filter(picturesSeedDto -> {
                    boolean isValid = this.validationUtil.isValid(picturesSeedDto)
                            && !doesEntityExist(picturesSeedDto.getPath());

                    stringBuilder
                            .append(isValid ?
                                    String.format("Successfully imported Picture, with size %.2f",
                                            picturesSeedDto.getSize()) :
                                    "Invalid Picture")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(picturesSeedDto -> this.modelMapper.map(picturesSeedDto, Picture.class))
                .forEach(this.pictureRepository::save);

        return stringBuilder.toString();
    }

    @Override
    public boolean doesEntityExist(String path) {
        return this.pictureRepository.existsByPath(path);
    }

    @Override
    public String exportPictures() {
        StringBuilder stringBuilder = new StringBuilder();

        this.pictureRepository
                .findAllBySizeGreaterThanOrderBySize(GlobalConstant.SIZE_OF_PICTURE)
                .forEach(picture -> stringBuilder
                        .append(String.format("%.2f - %s",
                                picture.getSize(), picture.getPath()))
                        .append(System.lineSeparator()));

        return stringBuilder.toString();
    }

    @Override
    public Picture findByPath(String path) {
        return this.pictureRepository
                .findByPath(path)
                .orElse(null);
    }
}
