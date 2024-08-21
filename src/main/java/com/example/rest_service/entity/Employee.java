package com.example.rest_service.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private int employee_id;
    private String first_name;
    private String last_name;
    private String email;
    private String title;
}
