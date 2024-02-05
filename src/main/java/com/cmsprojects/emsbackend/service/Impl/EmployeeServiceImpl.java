package com.cmsprojects.emsbackend.service.Impl;

import com.cmsprojects.emsbackend.dto.EmployeeDto;
import com.cmsprojects.emsbackend.entity.Employee;
import com.cmsprojects.emsbackend.mapper.EmployeeMapper;
import com.cmsprojects.emsbackend.repository.EmployeeRepo;
import com.cmsprojects.emsbackend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepo employeeRepo;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee =  employeeRepo.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }
}
