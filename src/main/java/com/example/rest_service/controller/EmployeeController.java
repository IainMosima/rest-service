package com.example.rest_service.controller;

import com.example.rest_service.entity.Employee;
import com.example.rest_service.service.EmployeeManager;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeManager employeeManager;

    public EmployeeController(EmployeeManager employeeManager) {
        this.employeeManager = employeeManager;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> getAllEmployees() {
       return employeeManager.getAllEmployees();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String addEmployee(@RequestBody Employee employee) {
        return employeeManager.addEmployee(employee);
    }

}
