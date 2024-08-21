package com.example.rest_service.service;

import com.example.rest_service.entity.Employee;
import com.example.rest_service.entity.Employees;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
public class EmployeeManager {
    private final Employees employees;

    public EmployeeManager() {
        this.employees = new Employees();
        initializeEmployees();
    }

    private void initializeEmployees() {
        employees.addEmployee(new Employee(1, "iain", "mosima", "iain.mosima@gmail.com", "Software Engineer"));
        employees.addEmployee(new Employee(2, "bruce", "barner", "bruce.barner@outlook.com", "Dev ops"));
        employees.addEmployee(new Employee(3, "peter", "parker", "peter.parker@outlook.com", "Data Analyst"));
        employees.addEmployee(new Employee(4, "stephen", "strange", "stephen.strange@gmail.com", "UX Designer"));
    }

    public String addEmployee(Employee employee) {
        employees.addEmployee(employee);
        return "Employee added successfully";
    }

    public List<Employee> getAllEmployees() {
        return employees.getEmployeesList();
    }
}
