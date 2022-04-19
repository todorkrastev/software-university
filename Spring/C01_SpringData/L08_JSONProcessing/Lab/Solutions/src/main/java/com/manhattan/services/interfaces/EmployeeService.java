package com.manhattan.services.interfaces;

import com.manhattan.dtos.EmployeeDetailsDto;
import com.manhattan.dtos.EmployeeDto;
import com.manhattan.dtos.ManagerCustomDto;
import com.manhattan.dtos.ManagerDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto findOne(int id);

    ManagerDto findManagerOne(int id);

    List<EmployeeDetailsDto> findEmployeesBornBefore(int year);

    ManagerCustomDto findEmployeesManager(int Id);
}
