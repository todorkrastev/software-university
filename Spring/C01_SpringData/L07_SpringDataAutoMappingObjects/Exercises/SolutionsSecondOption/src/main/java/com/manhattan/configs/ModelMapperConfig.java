package com.manhattan.configs;

import com.manhattan.dtos.ManagerCustomDto;
import com.manhattan.entities.Employee;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();

        Converter<String, Integer> toStrLength =
                ctx -> ctx.getSource() == null ? 0 : ctx.getSource().length();

        mapper.createTypeMap(Employee.class, ManagerCustomDto.class)
                .addMappings(mpr ->
                        mpr.using(toStrLength).map(Employee::getLastName, ManagerCustomDto::setLastNameLength));

        return mapper;
    }
}
