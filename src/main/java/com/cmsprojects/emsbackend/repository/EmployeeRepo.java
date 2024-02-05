package com.cmsprojects.emsbackend.repository;

import com.cmsprojects.emsbackend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository <Employee,Long> {
}
