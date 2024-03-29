package com.cmsprojects.emsbackend.controller;

import com.cmsprojects.emsbackend.dto.EmployeeDto;
import com.cmsprojects.emsbackend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    //BUILD ADD EMPLOYEE API ------------
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        if(savedEmployee != null){
            return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //BUILD GET EMPLOYEE REST API -------------
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
      EmployeeDto employeeDto =   employeeService.getEmployeeById(employeeId);
      if(employeeDto != null){
          return new ResponseEntity<>(employeeDto, HttpStatus.OK);
      }else{
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    }

    //BUILD GET ALL EMPLOYEES REST API ---------
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmpoyes(){
        List<EmployeeDto> list = employeeService.getAllEmployes();
        if(list != null){
            return new ResponseEntity<>(list, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //BUILD UPDATE EMPLOYEE REST API ------
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId,@RequestBody EmployeeDto updatedEmployee){
       EmployeeDto employeeDto = employeeService.updateEmployee(employeeId,updatedEmployee);
        if(employeeDto != null){
            return new ResponseEntity<>(employeeDto, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
