package com.practice.employee.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name="Employee1")
public class EmployeeInfo {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private LocalDate dob;
    private Float salary;
    private String line1;
    private String line2;
    private String state;
    private String country;
}
