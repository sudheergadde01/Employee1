package com.practice.employee.service;

import com.practice.employee.request.EmployeeRequest;
import com.practice.employee.response.GetEmployeeResponse;
import com.practice.employee.response.EmployeeResponse;

public interface EmployeeService {

    EmployeeResponse registerEmployee(EmployeeRequest employeeRequest);

    GetEmployeeResponse getEmployeeById(Long id);

    EmployeeResponse updateEmployee(EmployeeRequest employeeRequest);

    EmployeeResponse deleteEmployee(Long id);


}
