package com.codingshuttleModule4.prod_features.client;

import com.codingshuttleModule4.prod_features.dto.EmployeeDTO;

import java.util.List;


public interface EmployeeClient {
    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO getEmployeeById(Long id);

    EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO);
}