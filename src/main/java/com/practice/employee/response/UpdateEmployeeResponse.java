package com.practice.employee.response;

import com.practice.employee.request.EmployeeDetails;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateEmployeeResponse {

    private String message;
    private EmployeeDetails employeeDetails;
}
