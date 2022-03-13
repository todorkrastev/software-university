package bg.softuni.automappingobjects.configurations;

import bg.softuni.automappingobjects.models.dto.EmployeeDto;
import bg.softuni.automappingobjects.models.entities.Employee;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.addMappings(new PropertyMap<Employee, EmployeeDto>() {

            @Override
            protected void configure() {
                map().setSalary(source.getSalary());
            }
        });

        return mapper;
    }
}
