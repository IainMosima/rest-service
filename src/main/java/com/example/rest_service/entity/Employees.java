package com.example.rest_service.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class Employees {
    private List<Employee> employeesList =  new ArrayList<>();

    public void addEmployee(Employee employee) {
        employeesList.add(employee);
    }
}
