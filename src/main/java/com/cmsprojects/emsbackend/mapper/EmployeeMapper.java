package com.cmsprojects.emsbackend.mapper;

import com.cmsprojects.emsbackend.dto.EmployeeDto;
import com.cmsprojects.emsbackend.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstname(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }
}
