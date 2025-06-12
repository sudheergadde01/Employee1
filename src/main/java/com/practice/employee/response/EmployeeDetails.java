package com.practice.employee.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EmployeeDetails {

    private Long empId;
    private String name;
    private LocalDate dob;
    private Float salary;
    private String line1;
    private String line2;
    private String state;
    private String country;
}
