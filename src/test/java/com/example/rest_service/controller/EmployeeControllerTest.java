package com.example.rest_service.controller;

import com.example.rest_service.entity.Employee;
import com.example.rest_service.service.EmployeeManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    EmployeeManager employeeManager;

    Employee employee_1 = new Employee(6, "Bruce", "Barner", "brucebarner@gmail.com", "backend developer");
    Employee employee_2 = new Employee(21, "Miles", "Morales", "milesmorales@gmail.com", "frontend developer");
    Employee employee_3 = new Employee(30, "Clark", "Kent", "clarkkent@gmail.com", "cloud developer");
    Employee employee_4 = new Employee(40, "Michael", "Jackson", "michaeljackson@gmail.com", "devops");

    @Test
    public void getAllEmployees_success() throws Exception {
        List<Employee> employees = new ArrayList<>(Arrays.asList(employee_1, employee_2, employee_3));

        Mockito.when(employeeManager.getAllEmployees()).thenReturn(employees);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/employees")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[2].first_name", is("Clark")));
    }

    @Test
    public void addEmployee_success() throws Exception {
        Mockito.when(employeeManager.addEmployee(employee_4)).thenReturn("Employee added successfully");

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/employees")
                        .content(objectMapper.writeValueAsString(employee_4))
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk());
    }
}