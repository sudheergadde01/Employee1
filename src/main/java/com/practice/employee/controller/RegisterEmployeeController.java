package com.practice.employee.controller;

import com.practice.employee.request.DeleteEmployeeRequest;
import com.practice.employee.request.GetEmployeeRequest;
import com.practice.employee.request.RegisterEmployeeRequest;
import com.practice.employee.request.UpdateEmployeeRequest;
import com.practice.employee.response.GetEmployeeResponse;
import com.practice.employee.response.RegisterEmployeeResponse;
import com.practice.employee.response.UpdateEmployeeResponse;
import com.practice.employee.service.EmployeeService;
import com.practice.employee.service.UpdateEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class RegisterEmployeeController {

    private final EmployeeService employeeService;
    private final UpdateEmployeeService updateEmployeeService;
    @Autowired
    public RegisterEmployeeController(EmployeeService employeeService, UpdateEmployeeService updateEmployeeService) {
        this.employeeService = employeeService;
        this.updateEmployeeService=updateEmployeeService;
    }

    @PostMapping("/registerEmployee")
    public RegisterEmployeeResponse registerEmployee(@RequestBody RegisterEmployeeRequest registerEmployeeRequest){
        System.out.println("/registerEmployee API working");
        return employeeService.registerEmployee(registerEmployeeRequest);
    }

    @GetMapping("/getEmployee")
    public GetEmployeeResponse getEmployee(@RequestBody GetEmployeeRequest getEmployeeRequest){
        return employeeService.getEmployee(getEmployeeRequest);
    }

    @PutMapping("/updateEmployee")
    public UpdateEmployeeResponse updateEmployee(@RequestBody UpdateEmployeeRequest updateEmployeeRequest){
        return updateEmployeeService.updateEmployeeSalary(updateEmployeeRequest);
    }

    @DeleteMapping("/deleteEmployee")
    public GetEmployeeResponse deleteEmployee(@RequestBody DeleteEmployeeRequest deleteEmployeeRequest){
        return updateEmployeeService.deleteEmployee(deleteEmployeeRequest);
    }
}
