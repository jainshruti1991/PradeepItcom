package com.dev.spring.pradeepit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private int eid;
    private String name;
    private String email;
    private Double salary;
}

