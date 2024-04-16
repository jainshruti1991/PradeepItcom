package com.dev.spring.pradeepit.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="employee")
public class EmployeeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int eid;
    private String name;
    private String email;
    private Double salary;

}

