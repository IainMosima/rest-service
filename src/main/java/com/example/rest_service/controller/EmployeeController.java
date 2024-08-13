package com.example.rest_service.controller;

import com.example.rest_service.entity.Employee;
import com.example.rest_service.service.EmployeeManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    private final EmployeeManager employeeManager;

    public EmployeeController(EmployeeManager employeeManager) {
        this.employeeManager = employeeManager;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
       return employeeManager.getEmployees().getEmployeesList();
    }

}
