package com.manhattan.repositories;

import com.manhattan.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findAllByBirthdayBeforeOrderBySalaryDesc(LocalDate date);
}
