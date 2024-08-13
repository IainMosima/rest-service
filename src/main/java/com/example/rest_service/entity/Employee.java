package com.example.rest_service.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {
    private int employee_id;
    private String first_name;
    private String last_name;
    private String email;
    private String title;
}
