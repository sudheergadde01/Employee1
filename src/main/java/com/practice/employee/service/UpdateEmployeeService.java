package com.practice.employee.service;

import com.practice.employee.request.DeleteEmployeeRequest;
import com.practice.employee.request.UpdateEmployeeRequest;
import com.practice.employee.response.GetEmployeeResponse;
import com.practice.employee.response.UpdateEmployeeResponse;

public interface UpdateEmployeeService {

    UpdateEmployeeResponse updateEmployeeSalary(UpdateEmployeeRequest updateEmployeeRequest);

    GetEmployeeResponse deleteEmployee(DeleteEmployeeRequest deleteEmployeeRequest);
}
