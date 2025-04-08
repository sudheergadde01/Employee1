package com.practice.employee.request;

import lombok.Getter;
import lombok.Setter;


import java.time.LocalDate;

@Getter
@Setter
public class RegisterEmployeeRequest {

    private String name;
    private LocalDate dob;
    private Float salary;
    private String line1;
    private String line2;
    private String state;
    private String country;
}
