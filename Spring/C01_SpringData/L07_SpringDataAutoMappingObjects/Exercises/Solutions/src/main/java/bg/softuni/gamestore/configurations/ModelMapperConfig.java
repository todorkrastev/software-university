package bg.softuni.gamestore.configurations;

import bg.softuni.gamestore.models.dto.GameAddDto;
import bg.softuni.gamestore.models.entities.Game;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        Converter<String, LocalDate> toLocalDate =
                mappingContext -> LocalDate.parse(mappingContext.getSource(), formatter);

        modelMapper
                .typeMap(GameAddDto.class, Game.class)
                .addMappings(mapper ->
                        mapper
                                .map(GameAddDto::getThumbnailURL, Game::setImageThumbnail))
                .addMappings(mapper ->
                        mapper
                                .using(toLocalDate)
                                .map(GameAddDto::getReleaseDate, Game::setReleaseDate));


        /*
              Converter<String, LocalDate> localDateConverter =
                mappingContext -> mappingContext.getSource() == null
                        ? LocalDate.now()
                        : LocalDate.parse(mappingContext.getSource(),
                        formatter);

                              modelMapper.addConverter(localDateConverter);
         */


        return modelMapper;
    }
}
