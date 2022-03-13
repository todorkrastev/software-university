package bg.softuni.automappingobjects.services;

import bg.softuni.automappingobjects.models.dto.ManagerDto;

import java.util.List;

public interface EmployeeService {

    ManagerDto findOne(Long id);

    List<ManagerDto> findAll();
}
