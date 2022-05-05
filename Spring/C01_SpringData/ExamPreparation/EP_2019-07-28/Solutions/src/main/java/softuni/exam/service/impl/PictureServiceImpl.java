package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.domain.dtos.PictureSeedDto;
import softuni.exam.domain.dtos.PictureSeedRootDto;
import softuni.exam.domain.entities.Picture;
import softuni.exam.repository.PictureRepository;
import softuni.exam.service.PictureService;
import softuni.exam.util.FileService;
import softuni.exam.util.MessageService;
import softuni.exam.util.ValidationUtil;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PictureServiceImpl implements PictureService {
    public static final String PICTURES_FILE_PATH = "src/main/resources/files/xml/pictures.xml";
    private final PictureRepository repository;
    private final FileService fileService;
    private final ValidationUtil validator;
    private final ModelMapper mapper;
    private final MessageService messageService;

    public PictureServiceImpl(PictureRepository repository,
                              FileService fileService,
                              ValidationUtil validator,
                              ModelMapper mapper,
                              MessageService messageService) {
        this.repository = repository;
        this.fileService = fileService;
        this.validator = validator;
        this.mapper = mapper;
        this.messageService = messageService;
    }

    @Override
    public boolean areImported() {
        return this.repository.count() > 0;
    }

    @Override
    public String readPicturesXmlFile() throws IOException {
        return this.fileService.readString(PICTURES_FILE_PATH);
    }

    @Override
    public Optional<Picture> getByUrl(String url) {
        return repository.findByUrl(url);
    }

    @Override
    public String importPictures() throws JAXBException, IOException {
        return this.fileService.readXmlFile(PICTURES_FILE_PATH, PictureSeedRootDto.class)
                .getPictures()
                .stream()
                .map(this::persistIfValid)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String persistIfValid(PictureSeedDto picture) {
        boolean isValid = this.validator.isValid(picture);
        String message = this.messageService.getMessage(picture, isValid);
        if (isValid) {
            this.repository.save(this.mapper.map(picture, Picture.class));
        }
        return message;
    }

}
