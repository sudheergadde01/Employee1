package com.practice.employee.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetEmployeeResponse {

    private int status;
    private String message;
    private EmployeeDetails employeeDetails;
}
