package com.practice.employee.request;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDate;

@Getter
@Setter
public class EmployeeRequest {

    @NotNull(message = "Employee ID must not be null")
    private Long empId;


    @Size(max=50, message= "Name cannot be more than 50 characters")
    @NotBlank
    private String name;

    private LocalDate dob;

    @Min(100)
    @Max(1000000)
    private Float salary;

    @Size(max=50)
    private String line1;

    @Size(max=50)
    private String line2;

    @Size(max=2)
    private String state;

    @Size(max=3)
    private String country;
}
