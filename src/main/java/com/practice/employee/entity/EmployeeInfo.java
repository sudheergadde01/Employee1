package com.practice.employee.entity;

import jakarta.persistence.*;
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
    @Column(unique = true)
    private Long empId;
    private String name;
    private LocalDate dob;
    private Float salary;
    private String line1;
    private String line2;
    private String state;
    private String country;
}
