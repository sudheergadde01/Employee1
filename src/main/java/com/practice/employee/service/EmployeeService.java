package com.practice.employee.service;

import com.practice.employee.request.GetEmployeeRequest;
import com.practice.employee.request.RegisterEmployeeRequest;
import com.practice.employee.request.UpdateEmployeeRequest;
import com.practice.employee.response.GetEmployeeResponse;
import com.practice.employee.response.RegisterEmployeeResponse;
import com.practice.employee.response.UpdateEmployeeResponse;


public interface EmployeeService {

    RegisterEmployeeResponse registerEmployee(RegisterEmployeeRequest registerEmployeeRequest);

    GetEmployeeResponse getEmployee(GetEmployeeRequest getEmployeeRequest);

}
