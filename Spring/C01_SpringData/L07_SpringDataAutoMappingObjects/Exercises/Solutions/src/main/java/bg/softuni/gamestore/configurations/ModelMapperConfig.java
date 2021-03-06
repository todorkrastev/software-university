package bg.softuni.gamestore.configurations;

import bg.softuni.gamestore.models.dtos.GameAddDto;
import bg.softuni.gamestore.models.entities.Game;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
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

        Converter<String, LocalDate> localDateConverter = new Converter<String, LocalDate>() {
            @Override
            public LocalDate convert(MappingContext<String, LocalDate> mappingContext) {
                return mappingContext.getSource() == null
                        ? LocalDate.now()
                        : LocalDate.parse(mappingContext.getSource(), formatter);
            }
        };

        modelMapper.addConverter(localDateConverter);


        modelMapper
                .createTypeMap(GameAddDto.class, Game.class)
                .addMappings(mapper ->
                        mapper
                                .map(GameAddDto::getThumbnailURL, Game::setImageThumbnail));

        return modelMapper;
    }
}
