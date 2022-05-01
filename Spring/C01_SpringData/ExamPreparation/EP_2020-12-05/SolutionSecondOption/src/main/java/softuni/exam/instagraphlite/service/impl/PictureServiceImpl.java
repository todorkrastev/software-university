package softuni.exam.instagraphlite.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dtos.PictureListDto;
import softuni.exam.instagraphlite.models.dtos.PictureSeedDto;
import softuni.exam.instagraphlite.models.entities.Picture;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.util.FileService;
import softuni.exam.instagraphlite.util.MessageService;
import softuni.exam.instagraphlite.util.ValidationUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PictureServiceImpl implements PictureService {
    public static final String PICTURES_FILE_PATH = "src/main/resources/files/pictures.json";
    private final PictureRepository repository;
    private final FileService fileService;
    private final ValidationUtil validator;
    private final MessageService messageService;
    private final ModelMapper mapper;

    public PictureServiceImpl(PictureRepository repository,
                              FileService fileService,
                              ValidationUtil validator,
                              MessageService messageService,
                              ModelMapper mapper) {
        this.repository = repository;
        this.fileService = fileService;
        this.validator = validator;
        this.messageService = messageService;
        this.mapper = mapper;
    }

    @Override
    public boolean areImported() {
        return this.repository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return this.fileService.readString(PICTURES_FILE_PATH);
    }

    @Override
    public String importPictures() throws IOException {
        return Arrays.stream(this.fileService.readJsonFile(PICTURES_FILE_PATH, PictureSeedDto[].class))
                .map(this::persistIfValid)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String persistIfValid(PictureSeedDto picture) {
        boolean isValid = this.validator.isValid(picture, this::isUnique);
        String message = this.messageService.getMessage(picture, isValid);

        if (isValid){
            Picture dbPicture = this.mapper.map(picture, Picture.class);
            this.repository.save(dbPicture);
        }

        return message;
    }

    private boolean isUnique(PictureSeedDto c) {
        return !repository.existsByPath(c.getPath());
    }

    @Override
    public String exportPictures() {
        return repository.findAllBySizeGreaterThanOrderBySizeAsc(Double.valueOf(30000))
                .stream()
                .map(p -> mapper.map(p, PictureListDto.class))
                .map(PictureListDto::toString)
                .collect(Collectors.joining(System.lineSeparator()));

    }

    @Override
    public Optional<Picture> getPictureByPath(String profilePicture) {
        return repository.findOneByPath(profilePicture);
    }
}
