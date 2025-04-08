package com.practice.employee.response;

import com.practice.employee.request.EmployeeDetails;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class GetEmployeeResponse {

    private String message;
    private EmployeeDetails employeeDetails;
}
